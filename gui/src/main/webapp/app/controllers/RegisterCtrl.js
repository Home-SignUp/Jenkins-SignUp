'use strict';

/* RegisterCtrl */

angular.module('app')

.controller('RegisterCtrl', ['$rootScope', '$scope', '$routeParams', '$http',
	function($rootScope, $scope, $routeParams, $http) {
        var that = this;

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
            $http.post('http://localhost:8081/server/api/users', {
					"userName": that.userName
                    ,"userPass": that.userPass
					,"userLdap": that.userLdap
					,"userFio": that.userFio
                    ,"email": that.email
                    ,"groupName": that.groupName
                    ,"status": 'Inactive'
			})
			.success(function(data, status, headers, config) {
				console.log('data = ' , data);
                    that.userName = '';
                    that.userPass = '';
                    that.userLdap = '';
                    that.userFio = '';
                    that.email = '';
                    that.groupName = '';
                    that.status = '';
                    that.newUserName = data;
			})
			.error(function(data, status, headers, config) {
				console.log('error: data = ' , data);
			});
		};
	}
]);
