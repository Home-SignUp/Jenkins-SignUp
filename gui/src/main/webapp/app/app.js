'use strict';

/* App Module */

var app = angular.module('app', ['ngRoute', 'ui.bootstrap', 'ngAnimate'])

app.config(['$routeProvider', '$httpProvider',
	function($routeProvider, $httpProvider) {
		$routeProvider
            .when('/home', {
				templateUrl: 'partials/home.tpl',
				controller: 'HomeCtrl'
			})
            .when('/customer', {
                templateUrl: 'partials/customer.tpl',
                controller: 'CustomersCrtl'
            })
            .when('/c_ustomer', {
                templateUrl: 'partials/c_ustomer.tpl',
                controller: 'C_ustomersCrtl'
            })
            .when('/products', {
                templateUrl: 'partials/products.tpl',
                controller: 'ProductsCtrl'
            })
            .otherwise({
				redirectTo: '/products'
			});
        $httpProvider.defaults.useXDomain = true;
        delete $httpProvider.defaults.headers.common['X-Requested-With'];
	}
]);
