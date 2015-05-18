app.factory("Data", ['$http', '$location',
    function ($http, $q, $location) {

        //var serviceBase = 'api/v1/';
        //var serviceBase = 'http://127.0.0.1/angularjs/lesson-products/api/v1/';
        var serviceBase = 'https://10.13.71.153:8443/server/api/'; //var serviceBase = 'https://localhost:8443/server/api/'; //var serviceBase = 'http://localhost:8081/server/api/';

        var obj = {};

        obj.get = function (q) {
            return $http.get(serviceBase + q).then(function (results) {
                return results.data;
            });
        };
        obj.post = function (q, object) {
            return $http.post(serviceBase + q, object).then(function (results) {
                return results.data;
            });
        };
        obj.put = function (q, object) {
            return $http.put(serviceBase + q, object).then(function (results) {
                return results.data;
            });
        };
        obj.delete = function (q) {
            return $http.delete(serviceBase + q).then(function (results) {
                return results.data;
            });
        };
        return obj;
}]);
