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
                controller: 'customersCrtl'
            })
            .when('/products', {
                templateUrl: 'partials/products.tpl',
                controller: 'productsCtrl'
            })
            .otherwise({
				redirectTo: '/products'
			});
        $httpProvider.defaults.useXDomain = true;
        delete $httpProvider.defaults.headers.common['X-Requested-With'];
	}
]);
