'use strict';

/* Controllers */

angular.module('app')

.controller('HomeCtrl', ['$rootScope', '$scope', '$routeParams', '$http',
	function($rootScope, $scope, $routeParams, $http) {
        var that = this;

        that.createPerson = function() {
			console.log('BEGIN createPerson');

            if(!that.userName){
                that.userRequired = 'Name Required';
            }
            if(!that.firstName){
                that.firstRequired = 'First Name Required';
            }
            if(!that.lastName){
                that.lastRequired = 'Last Name Required';
            }

			$http.post('api/person', {
					"userName": that.userName
					,"firstName": that.firstName
					,"lastName": that.lastName
			})
			.success(function(data, status, headers, config) {
				console.log('data = ' , data);
                    that.userName = '';
                    that.firstName = '';
                    that.lastName = '';
                    that.newUserId = data;
			})
			.error(function(data, status, headers, config) {
				console.log('error: data = ' , data);
			});
		};

        that.searchPerson = function() {
			$http.get('api/person/' + that.searchPersonId)
			.success(function(data, status, headers, config) {
				console.log('data = ' , data);
                    that.person = data;
			})
			.error(function(data, status, headers, config) {
				console.log('error: data = ' , data);
			});
		};
	}
]);
