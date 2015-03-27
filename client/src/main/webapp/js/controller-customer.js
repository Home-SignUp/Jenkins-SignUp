'use strict';

/* Controller-Customer */

angular.module('app')

.controller('customersCrtl', ['$scope', '$http', '$timeout',
    function ($scope, $http, $timeout) {
        var that = this;

        //$http.get('server/api/customers').success(function(data){
        $http.get('http://localhost:8080/server/api/customers').success(function(data){
            that.list          = data;
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