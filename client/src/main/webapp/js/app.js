'use strict';

/* App Module */

var app = angular.module('app', ['ngRoute', 'ui.bootstrap', 'ngAnimate'])

app.config(['$routeProvider', '$httpProvider',
	function($routeProvider, $httpProvider) {
		$routeProvider
            .when('/home', {
				templateUrl: 'partials/home.html',
				controller: 'HomeCtrl'
			})
            .when('/customer', {
                templateUrl: 'partials/customer.html',
                controller: 'customersCrtl'
            })
            .when('/products', {
                templateUrl: 'partials/products.tpl',
                controller: 'productsCtrl'
            })
            .otherwise({
				redirectTo: '/customer'
			});
        $httpProvider.defaults.useXDomain = true;
        delete $httpProvider.defaults.headers.common['X-Requested-With'];
	}
]);
