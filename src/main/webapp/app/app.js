'use strict';

var app = angular.module('myApp', ['ngRoute', 'ui.bootstrap', 'ngAnimate']);

// XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX
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
// XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX

// /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   (php cors header json)
// * (In PHP, you can use the below code to set the headers) http://hayageek.com/cross-domain-ajax-request-jquery/
//                                                           http://jeffmcmahan.info/blog/sometimes-apache-just-doesnt-like-cors-requests/
//                                                           http://stackoverflow.com/questions/26417734/set-access-control-allow-origin-without-server-side-scripting
//   (cors angular)
// * (How to enable CORS in AngularJs) http://stackoverflow.com/questions/23823010/how-to-enable-cors-in-angularjs
//
//   (Enabling Cross Origin Requests for a RESTful Web Service) https://spring.io/guides/gs/rest-service-cors/
//                                                 (Using CORS) http://www.html5rocks.com/en/tutorials/cors/
// /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

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
        $httpProvider.defaults.useXDomain = true;
        delete $httpProvider.defaults.headers.common['X-Requested-With'];
    }]);