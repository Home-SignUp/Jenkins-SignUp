'use strict';

/* SearchCtrl */

angular.module('app')

.controller('SearchCtrl', ['$rootScope', '$scope', '$routeParams', '$http',
	function($rootScope, $scope, $routeParams, $http) {
        var that = this;

        that.createUser = function() {
			console.log('BEGIN createUser');

            if(!that.userName){
                that.nameRequired = 'Name Required';
            }

            $http.post('https://127.0.0.1:8443/server/api/users', { //$http.post('server/api/person', {
            //$http.post('https://10.13.71.153:8443/server/api/users', {
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
            $http.get('https://127.0.0.1:8443/server/api/users/' + that.searchUserName) //$http.get('server/api/person/' + that.searchPersonId)
            //$http.get('https://10.13.71.153:8443/server/api/users/' + that.searchUserName)
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
