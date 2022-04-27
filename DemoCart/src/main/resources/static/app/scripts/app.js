'use strict';

/**
 * @ngdoc overview
 * @name demoApp
 * @description
 * # demoApp
 *
 * Main module of the application.
 */
angular
    .module('demoApp', [
        'ngAnimate',
        'ngCookies',
        'ngResource',
        'ngRoute',
        'ngSanitize',
        'ngTouch'
    ])
    .config(function ($routeProvider) {
        $routeProvider
            .when('/Home', {
                templateUrl: 'app/views/main.html',
                controller: 'MainCtrl',
                controllerAs: 'main',
                resolve: {
                    products: function ($http) {
                        return $http.get("http://localhost:8080/shoppingcart/products").then(function (response) {
                            return response.data;
                        })
                    }
                }
            })
            .when('/', {
                templateUrl: 'app/views/login.html',
                controller: 'LoginCtrl',
                controllerAs: 'login',
                resolve: {
                    products: function ($http) {
                        return $http.get("http://localhost:8080/shoppingcart/products").then(function (response) {
                            return response.data;
                        })
                    }
                }
            })


            .when('/Cart', {
                templateUrl: 'app/views/cart.html',
                controller: 'CartCtrl',
                controllerAs: 'cart',
                resolve: {
                    shoppingCart: function ($http) { //  data assign to shoppingCart list
                        return $http.get("http://localhost:8080/shoppingcart/shoppingCart").then(function (response) {
                            return response.data;
                        })
                    }
                }
            })

            .when('/History', {
                templateUrl: 'app/views/history.html',
                controller: 'HistoryCtrl',
                controllerAs: 'history',
                resolve: {
                    history: function ($http) {
                        return $http.get("http://localhost:8080/shoppingcart/history").then(function (response) {
                            return response.data;
                        })
                    }
                }
            })

            .otherwise({
                redirectTo: '/Home'
            });
    });
