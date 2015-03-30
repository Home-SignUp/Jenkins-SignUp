'use strict';

var app = angular.module('myApp', ['ngRoute', 'ui.bootstrap', 'ngAnimate']);

// (angularjs ajax json
//   https://www.youtube.com/watch?v=kHV7gOHvNdk)
//   http://blog.hfarazm.com/angularjs-service/
//   http://tutorials.jenkov.com/angularjs/ajax.html
// (AngularJS Политика одного источника запрещает чтение удаленного ресурса)
// * https://toster.ru/q/159325
//   https://toster.ru/q/114947
//   http://hashcode.ru/questions/388036/javascript-помогите-побороть-cors-в-angularjs
// (AngularJS включением CORS)
// * http://oleg.so/2013/08/05/cors-angularjs-node-js/
//   http://habrahabr.ru/post/120917/
//   http://codehint.ru/articles/2013-06-13_asp_net_web_api_cors/2
//   http://overcram.com/questions/?qid=411061
// (AngularJS $routeProvider включением CORS)
// * (Блог Makeomatic: разработка сайтов и мобильных приложений) https://makeomatic.ru/blog/2013/08/14/AngularJSIntro/
//   https://gist.github.com/kkurni/4618210
// * (AngularJS and CORS) http://draptik.github.io/blog/2013/08/19/angularjs-and-cors/
//                        https://github.com/draptik/angulardemorestful
//   http://georgi-naumov.blogspot.com/2014/02/angularjs-http-cors-and-http.html

app.config(['$routeProvider', '$httpProvider',
    function($routeProvider, $httpProvider) {
        $routeProvider
        .when('/', {
                title: 'Products',
                templateUrl: 'partials/products.tpl',
                controller: 'productsCtrl'
            })
        .otherwise({
            redirectTo: '/'
            });
        $httpProvider.defaults.withCredentials = true;
        delete $httpProvider.defaults.headers.common["X-Requested-With"];
        //$httpProvider.defaults.headers.get["Content-Type"] = "application/x-www-form-urlencoded";
    }]);
//.config(['$httpProvider',
//    function ($httpProvider) {
//    //$httpProvider.defaults.headers.post["Content-Type"] = "application/x-www-form-urlencoded";
//    $httpProvider.defaults.headers.get["Content-Type"] = "application/x-www-form-urlencoded";
//    $httpProvider.defaults.transformRequest = function(data){
//        if (data === undefined) {
//            return data;
//        }
//        return $.param(data);
//    }
//}]);
    