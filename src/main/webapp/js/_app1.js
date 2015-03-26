'use strict';

/* App Module */

angular.module('app',
    ['ngRoute'])

.config(['$routeProvider',
	function($routeProvider) {
		$routeProvider.
			when('/home', {
				templateUrl: '../partials/home.html',
				controller: 'HomeCtrl'
			}).
			otherwise({
				redirectTo: '/home'
			});
	}
]);
