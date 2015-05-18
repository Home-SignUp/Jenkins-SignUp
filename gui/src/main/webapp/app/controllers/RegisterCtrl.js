'use strict';

/* RegisterCtrl */

angular.module('app')

.controller('RegisterCtrl', ['$location', '$rootScope', '$scope', '$routeParams', '$http',
	function($location, $rootScope, $scope, $routeParams, $http) {
        var that = this;

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

			//$http.post('server/api/person', {
            var hashUserPass = md5(that.userPass);
            $http.post('https://10.13.71.153:8443/server/api/users', { //$http.post('https://localhost:8443/server/api/users', {
					"userName": that.userName
                    ,"userPass": hashUserPass
					,"userLdap": that.userLdap
					,"userFio": that.userFio
                    ,"email": that.email
                    ,"groupName": that.groupName.value
                    ,"status": 'Inactive'
			})
			.success(function(data, status, headers, config) {
				//console.log('data = ' , data);
                 //   that.userName = '';
                 //   that.userPass = '';
                 //   that.userLdap = '';
                 //   that.userFio = '';
                 //   that.email = '';
                 //   that.groupName.value = ''; //that.groupName = '';
                 //   that.status = '';
                 //   that.newUserName = data;
                 $location.path('/l_ogin');
			})
			.error(function(data, status, headers, config) {
				console.log('error: data = ' , data);
			});
		};
	}
]);
