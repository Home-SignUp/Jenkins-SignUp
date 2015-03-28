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

app.config(['$routeProvider',
  function($routeProvider) {
    $routeProvider
        .when('/', {
                title: 'Products',
                templateUrl: 'partials/products.tpl',
                controller: 'productsCtrl'
            })
            .otherwise({
                redirectTo: '/'
            });
        //.defaults.headers.get["Content-Type"] = "application/x-www-form-urlencoded";
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
    