//'use strict';
//
///* SignupCtrl */
//
//angular.module('app')
//
//.controller('SignupCtrl', ['$rootScope', '$scope', '$routeParams', '$http',
//	function($rootScope, $scope, $routeParams, $http) {
//        var that = this;
//
//        that.createProduct = function() {
//			console.log('BEGIN createProduct');
//
//            if(!that.name){
//                that.nameRequired = 'Name Required';
//            }
//
//			//$http.post('server/api/person', {
//            $http.post('http://localhost:8081/server/api/products', {
//					"name": that.name
//			})
//			.success(function(data, status, headers, config) {
//				console.log('data = ' , data);
//                    that.name = '';
//                    that.newUserId = data;
//			})
//			.error(function(data, status, headers, config) {
//				console.log('error: data = ' , data);
//			});
//		};
//
//        that.searchProduct = function() {
//			//$http.get('server/api/person/' + that.searchPersonId)
//            $http.get('http://localhost:8081/server/api/products/' + that.searchProductId)
//			.success(function(data, status, headers, config) {
//				console.log('data = ' , data);
//                    that.product = data;
//			})
//			.error(function(data, status, headers, config) {
//				console.log('error: data = ' , data);
//			});
//		};
//	}
//]);
