'use strict';

/* UsersCtrl */

angular.module('app')

.controller('UsersCtrl', function ($scope, $modal, $filter, $http, $timeout, Data) {
    $scope.user = {};


    Data.get('users').then(function(data){
        $scope.users = data.data;
        $scope.currentPage   = 1;                // current page
        $scope.entryLimit    = 5;                // max no of items to display in a page
        $scope.filteredItems = $scope.users.length; // Initially for no filter
        $scope.totalItems    = $scope.users.length;
    });
    $scope.setPage = function (pageNo) {
        $scope.currentPage = pageNo;
    };
    $scope.filter = function () {
        $timeout(function () {
            $scope.filteredItems = $scope.filtered.length;
        }, 10);
    };
    $scope.sort_by = function (predicate) {
        $scope.predicate = predicate;
        $scope.reverse = !$scope.reverse;
    };

    $scope.changeUserStatus = function(user){
        user.status = (user.status=="Active" ? "Inactive" : "Active");
        //Data.put("users/"+user.userName,{status:user.status});
        Data.put("users/"+user.userName,{userPass:user.userPass,status:user.status});
    };
    $scope.deleteUser = function(user){
        if(confirm("Are you sure to remove the user")){
            Data.delete("users/"+user.userName).then(function(result){
                $scope.users = _.without($scope.users, _.findWhere($scope.users, {userName:user.userName}));
            });
        }
    };
    $scope.open = function (u,size) {
        var modalInstance = $modal.open({
          templateUrl: 'partials/userEdit.tpl',
          controller: 'userEditCtrl',
          size: size,
          resolve: {
            item: function () {
              return u;
            }
          }
        });
        modalInstance.result.then(function(selectedObject) {
            if(selectedObject.save == "insert"){
                $scope.users.push(selectedObject);
                $scope.users = $filter('orderBy')($scope.users, 'userName', 'reverse');
            }else if(selectedObject.save == "update"){
                u.userFio = selectedObject.userFio;
                u.email = selectedObject.email;
                u.groupName = selectedObject.groupName;
            }
        });
    };
    
 $scope.columns = [
                    {text:"IP Register",predicate:"ip",reverse:true,sortable:true},
                    {text:"Date Register",predicate:"regdate",reverse:true,sortable:true},
                    {text:"Username",predicate:"userName",reverse:true,sortable:true}, //{text:"UserName",predicate:"userName",sortable:true,dataType:"number"},
                    {text:"Full Name",predicate:"userFio",reverse:true,sortable:true},
                    {text:"LDAP",predicate:"userLdap",reverse:true,sortable:true},
                    {text:"E-mail",predicate:"email",reverse:true,sortable:true}, //{text:"Email",predicate:"email",reverse:true,sortable:true,dataType:"number"},
                    {text:"Group",predicate:"groupName",reverse:true,sortable:true},
                    {text:"IP Update",predicate:"updateIp",reverse:true,sortable:true},
                    {text:"Date Update",predicate:"updateRegdate",reverse:true,sortable:true},
                    {text:"Status",predicate:"status",reverse:true,sortable:true},
                    {text:"Action",predicate:"",sortable:false}
                ];

})


/* userEditCtrl */

.controller('userEditCtrl', function ($scope, $modalInstance, item, Data) {
        $scope.user = angular.copy(item);

        $scope.groups = [
            {value:'admin', type:'System', text:'admin', notAnOption:true},
            {value:'Biplane-Admin', type:'Biplane', text:'Biplane-Admin'},
            {value:'Biplane-Buh', type:'Biplane', text:'Biplane-Buh'},
            {value:'Biplane-Cashier', type:'Biplane', text:'Biplane-Cashier'},
            {value:'Biplane-Dept', type:'Biplane', text:'Biplane-Dept'},
            {value:'Biplane-WebCashier', type:'Biplane-Web', text:'Biplane-WebCashier'},
            {value:'Irbis', type:'Irbis', text:'Irbis'},
            {value:'jenkins', type:'jenkins', text:'jenkins'},
            {value:'Oktopus', type:'Oktopus', text:'Oktopus'},
            {value:'Reports', type:'Reports', text:'Reports'},
            {value:'Test', type:'Test', text:'Test'},
            {value:'Tickets', type:'Tickets', text:'Tickets'},
            {value:'Vitrina', type:'Vitrina', text:'Vitrina'}
        ];
        $scope.groupSelect = [
            { groupValue:$scope.user.groupName }
        ];

        $scope.cancel = function () {
            $modalInstance.dismiss('Close');
        };
        $scope.title = (item.userName > 0) ? 'Edit User' : 'Add User';
        $scope.buttonText = (item.userName > 0) ? 'Update User' : 'Add New User';

        var original = item;
        $scope.isClean = function() {
            return angular.equals(original, $scope.user);
        };
        $scope.saveUser = function (user) {
            //user.uuserName = $scope.uuserName;
            user.groupName = $scope.user.groupName.value;
            if(user.userName != null){ //if(user.userName > 0){
                Data.put('users/'+user.userName, user).then(function (result) {
                    if(result.status != 'error'){
                        var x = angular.copy(user);
                        x.save = 'update';
                        $modalInstance.close(x);
                    }else{
                        console.log(result);
                    }
                });
            } else {
                user.status = 'Inactive';
                Data.post('users', user).then(function (result) {
                    if(result.status != 'error'){
                        var x = angular.copy(user);
                        x.save = 'insert';
                        x.id = result.data;
                        $modalInstance.close(x);
                    }else{
                        console.log(result);
                    }
                });
            }
        };
});
