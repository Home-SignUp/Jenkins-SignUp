'use strict';

/* SignupCtrl */

angular.module('app')

.controller('SignupCtrl', ['$rootScope', '$scope', '$routeParams', '$http',
	function($rootScope, $scope, $routeParams, $http) {
        var that = this;

        that.createUser = function() {
			console.log('BEGIN createUser');

            if(!that.userName){
                that.nameRequired = 'Name Required';
            }

			//$http.post('server/api/person', {
            $http.post('http://localhost:8081/server/api/users', {
					"userName": that.userName
			})
			.success(function(data, status, headers, config) {
				console.log('data = ' , data);
                    that.userName = '';
                    that.newUserName = data;
			})
			.error(function(data, status, headers, config) {
				console.log('error: data = ' , data);
			});
		};

        that.searchUser = function() {
			//$http.get('server/api/person/' + that.searchPersonId)
            $http.get('http://localhost:8081/server/api/users/' + that.searchUserName)
			.success(function(data, status, headers, config) {
				console.log('data = ' , data);
                    that.user = data;
			})
			.error(function(data, status, headers, config) {
				console.log('error: data = ' , data);
			});
		};
	}
]);
