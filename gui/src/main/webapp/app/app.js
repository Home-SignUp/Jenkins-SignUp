'use strict';

/* App Module */

var app = angular.module('app', ['ngRoute', 'ui.bootstrap', 'ngAnimate'])

app.config(['$routeProvider', '$httpProvider',
	function($routeProvider, $httpProvider) {
		$routeProvider
            .when('/register', {
                templateUrl: 'partials/register.tpl',
                controller: 'RegisterCtrl'
            })
            .when('/users', {
                templateUrl: 'partials/users.tpl',
                controller: 'UsersCtrl'
            })
            .when('/register-product', {
                templateUrl: 'partials/registerProduct.tpl',
                controller: 'RegisterProductCtrl'
            })
            .when('/products', {
                templateUrl: 'partials/products.tpl',
                controller: 'ProductsCtrl'
            })
            .when('/signup', {
                templateUrl: 'partials/signup.tpl',
                controller: 'SignupCtrl'
            })
            .otherwise({
				redirectTo: '/register'
			});
        $httpProvider.defaults.useXDomain = true;
        delete $httpProvider.defaults.headers.common['X-Requested-With'];
	}
]);
