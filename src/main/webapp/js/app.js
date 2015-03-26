'use strict';

/* App Module */

angular.module('app', ['ngRoute', 'ui.bootstrap'])

.config(['$routeProvider',
	function($routeProvider) {
		$routeProvider
            .when('/home', {
				templateUrl: 'partials/home.html',
				controller: 'HomeCtrl'
			})
            .when('/customer', {
                templateUrl: 'partials/customer.html',
                controller: 'customersCrtl'
            })
            .otherwise({
				redirectTo: '/customer'
			});
	}
]);
