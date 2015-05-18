'use strict';

/* App Module */

var app = angular
                .module('app', ['ngRoute', 'ui.bootstrap', 'ngAnimate', 'ngCookies'])
                .config(config)
                .run(run);

//app.config.$inject(['$routeProvider', '$httpProvider',
//	function($routeProvider, $httpProvider) {
config.$inject = ['$routeProvider', '$locationProvider', '$httpProvider'];
function config($routeProvider, $locationProvider, $httpProvider) {
		$routeProvider
            .when('/', {
                controller: 'HomeController',
                templateUrl: 'partials/profile.tpl',
                controllerAs: 'vm'
            })

            .when('/register', {
                templateUrl: 'partials/register.tpl',
                controller: 'RegisterCtrl'
            })
            .when('/users', {
                templateUrl: 'partials/users.tpl',
                controller: 'UsersCtrl'
            })
            .when('/signup', {
                templateUrl: 'partials/signup.tpl',
                controller: 'SignupCtrl'
            })

            .when('/l_ogin', {
                controller: 'LoginController',
                templateUrl: 'partials/l_ogin.tpl',
                controllerAs: 'vm'
            })
            .when('/r_egister', {
                controller: 'RegisterController',
                templateUrl: 'partials/r_egister.tpl',
                controllerAs: 'vm'
            })
            .when('/profile', {
                controller: 'HomeController',
                templateUrl: 'partials/profile.tpl',
                controllerAs: 'vm'
            })

            .when('/upload', {
                templateUrl: 'partials/upload.tpl',
                controller: 'UploadController'
            })

            .otherwise({
				redirectTo: '/register'
			});
        $httpProvider.defaults.useXDomain = true;
        delete $httpProvider.defaults.headers.common['X-Requested-With'];
	}
//]);


//app.config.$inject(['$rootScope', '$location', '$cookieStore', '$http',
//    function($rootScope, $location, $cookieStore, $http) {
run.$inject = ['$rootScope', '$location', '$cookieStore', '$http'];
function run($rootScope, $location, $cookieStore, $http) {
    // keep user logged in after page refresh
        $rootScope.globals = $cookieStore.get('globals') || {};
        if ($rootScope.globals.currentUser) {
            $http.defaults.headers.common['Authorization'] = 'Basic ' + $rootScope.globals.currentUser.authdata; // jshint ignore:line
        }

        $rootScope.$on('$locationChangeStart', function (event, next, current) {
            // redirect to login page if not logged in and trying to access a restricted page
            var restrictedPage = $.inArray($location.path(), ['/l_ogin', '/r_egister', '/register', '/signup']) === -1;
            var loggedIn = $rootScope.globals.currentUser;
            if (restrictedPage && !loggedIn) {
                $location.path('/register');
            }
        });
    }
//]);
