'use strict';

/* RegisterCtrl */

angular.module('app')

.controller('RegisterCtrl', ['$rootScope', '$scope', '$routeParams', '$http',
	function($rootScope, $scope, $routeParams, $http) {
        var that = this;

        that.createProduct = function() {
			console.log('BEGIN createProduct');

            if(!that.name){
                that.nameRequired = 'Name Required';
            }
            if(!that.price){
                that.priceRequired = 'Price Required';
            }
            if(!that.stock){
                that.stockRequired = 'Stock Required';
            }
            if(!that.packing){
                that.packingRequired = 'Packing Required';
            }

			//$http.post('server/api/person', {
            $http.post('http://localhost:8081/server/api/products', {
					"name": that.name
                    ,"description": that.description
					,"price": that.price
					,"stock": that.stock
                    ,"packing": that.packing
                    ,"status": 'Inactive'
			})
			.success(function(data, status, headers, config) {
				console.log('data = ' , data);
                    that.name = '';
                    that.description = '';
                    that.price = '';
                    that.stock = '';
                    that.packing = '';
                    that.status = '';
                    that.newUserId = data;
			})
			.error(function(data, status, headers, config) {
				console.log('error: data = ' , data);
			});
		};

        that.searchProduct = function() {
			//$http.get('server/api/person/' + that.searchPersonId)
            $http.get('http://localhost:8081/server/api/products/' + that.searchProductId)
			.success(function(data, status, headers, config) {
				console.log('data = ' , data);
                    that.product = data;
			})
			.error(function(data, status, headers, config) {
				console.log('error: data = ' , data);
			});
		};
	}
]);
