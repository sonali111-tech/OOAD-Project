'use strict';

/**
 * @ngdoc function
 * @name demoApp.controller:HistoryCtrl
 * @description
 * # HistoryCtrl
 * Controller of the demoApp
 */
angular.module('demoApp')
    .controller('LoginCtrl', ['$scope', '$q', '$http','$location' , function ($scope, $q, $http,$location ) {
        //$scope.loginNew = login;
        $scope.title = "Shoping Cart Login";
        $scope.username = null;
        $scope.password = null;

        $scope.formSubmit = function(){

         
            if($scope.username =="user1@gmail.com" && $scope.password=="user1"){
                $location.url('/Home');
            }
            else  if($scope.username =="user2@gmail.com" && $scope.password=="user2"){
                $location.url('/Home');
            }
             else{
                 alert("Invaild User name or Password!")
                $location.url('/');
            }
            
        }

    }]);