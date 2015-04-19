'use strict';

/* P_roductsCtrl */

angular.module('app')

.controller('P_roductsCtrl', ['$scope', '$http', '$timeout', 'Data',
    function ($scope, $http, $timeout, Data) {
        var that = this;

        ////$http.get('server/api/customers').success(function(data){
        //$http.get('http://localhost:8081/server/api/customers').success(function(data){
        //    that.list          = data;
        //    that.currentPage   = 1;                // current page
        //    that.entryLimit    = 5;                // max no of items to display in a page
        //    that.filteredItems = that.list.length; // Initially for no filter
        //    that.totalItems    = that.list.length;
        //});

        //$scope.product = {};
        Data.get('products').then(function(data){
            //$scope.products = data.data;
            that.list          = data.data;
            that.currentPage   = 1;                // current page
            that.entryLimit    = 5;                // max no of items to display in a page
            that.filteredItems = that.list.length; // Initially for no filter
            that.totalItems    = that.list.length;
        });


        that.setPage = function (pageNo) {
            that.currentPage = pageNo;
        };
        that.filter = function () {
            $timeout(function () {
                that.filteredItems = that.filtered.length;
            }, 10);
        };
        that.sort_by = function (predicate) {
            that.predicate = predicate;
            that.reverse = !that.reverse;
        };
    }
]);