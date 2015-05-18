'use strict';

/* ApplicationCtrl */

//angular.module('app')
angular
    .module('app')
    .controller('ApplicationCtrl', ApplicationCtrl);

//.controller('ApplicationCtrl', function($scope, $location, $UserService) {
ApplicationCtrl.$inject = ['UserService', '$rootScope', '$scope', '$location'];
function ApplicationCtrl(UserService, $rootScope, $scope, $location) {
    $scope.user = null;
    $scope.allUsers = [];

    $rootScope.$on('$locationChangeStart', function (event, next, current) {
        var loggedIn = $rootScope.globals.currentUser;
        if (loggedIn) {
            initController();
        }
    });

    $scope.isLogin = function() {
        if($scope.user == null){
            return false; //Just as a test to make sure it works
        } else {
            return true;
        }
    }
    $scope.isLogout = function() {
        if($scope.user == null){
            return true;
        } else {
            return false;
        }
    }

    $scope.IsUser = function(){
        return $scope.UserRole == "Biplane-Buh"
            || $scope.UserRole == "Biplane-Cashier"
            || $scope.UserRole == "Biplane-Dept"
            || $scope.UserRole == "Biplane-WebCashier"
            || $scope.UserRole == "Irbis"
            || $scope.UserRole == "jenkins"
            || $scope.UserRole == "Oktopus"
            || $scope.UserRole == "Reports"
            || $scope.UserRole == "Tickets"
            || $scope.UserRole == "Vitrina"
            || $scope.UserRole == "undefined";
    }
    $scope.IsManager = function(){
        return $scope.UserRole == "Biplane-Admin"
            || $scope.UserRole == "Test";
    }
    $scope.IsAdmin = function(){
        return $scope.UserRole == "admin";
    }

    function initController() {
        loadCurrentUser();
    }
    function loadCurrentUser() {
        UserService.GetByUsername($rootScope.globals.currentUser.username)
            .then(function (user) {
                $scope.user = user.data; //vm.user = user.data;
                $scope.UserRole = user.data.groupName;
            });
    }

    $scope.isActive = function(path) {
        if ($location.path().substr(0, path.length) === path) {
            if (path === "/" && $location.path() === "/") {
                return true;
            } else if (path === "/") {
                return false;
            } else {
                return true;
            }
        } else {
            return false;
        }
    };
//})
}