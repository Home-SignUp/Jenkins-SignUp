'use strict';

/* RegisterCtrl */

angular.module('app')
    //.controller('RegisterCtrl', RegisterCtrl);

.controller('RegisterCtrl', ['$location', '$rootScope', '$scope', '$routeParams', '$http',
	function($location, $rootScope, $scope, $routeParams, $http) {
//RegisterCtrl.$inject = ['UserService', '$location', '$rootScope', '$scope', '$routeParams', '$http', 'FlashService'];
//    function RegisterCtrl(UserService, $location, $rootScope, $scope, $routeParams, $http, FlashService) {
        var that = this;

        //that.register = register;
        //
        //function register() {
        //    that.dataLoading = true;
        //    UserService.Create(that.user)
        //        .then(function (response) {
        //            if (response.success) {
        //                FlashService.Success('Registration successful', true);
        //                $location.path('/login');
        //            } else {
        //                FlashService.Error(response.message);
        //                that.dataLoading = false;
        //            }
        //        });
        //}

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

        that.createUser = function() {
			console.log('BEGIN createUser');

            if(!that.userName){
                that.nameRequired = 'userName Required';
            }
            if(!that.userPass){
                that.passRequired = 'userPass Required';
            }
            if(!that.userLdap){
                that.ldapRequired = 'userLdap Required';
            }
            if(!that.userFio){
                that.fioRequired = 'userFio Required';
            }
            if(!that.email){
                that.emailRequired = 'email Required';
            }
            if(!that.groupName){
                that.groupRequired = 'groupName Required';
            }

            var hashUserPass = md5(that.userPass);
            $http.post('https://127.0.0.1:8443/server/api/users', { //$http.post('server/api/person', {
            //$http.post('https://10.13.71.153:8443/server/api/users', {
					"userName": that.userName
                    ,"userPass": hashUserPass
					,"userLdap": that.userLdap
					,"userFio": that.userFio
                    ,"email": that.email
                    ,"groupName": that.groupName.value
                    ,"status": 'Inactive'
			})
			.success(function(data, status, headers, config) {
                 $location.path('/login');
			})
			.error(function(data, status, headers, config) {
				console.log('error: data = ' , data);
			});
		};
	}
]);
