'use strict';

angular
    .module('ikebana', [
        // 'ngAnimate',
        // 'ngCookies',
        'ngResource',
        'ngRoute'
        // 'ngSanitize',
        // 'ngTouch'
    ])
    .config(function ($routeProvider) {
        $routeProvider
            .when('/', {
                templateUrl: 'app/views/main.html',
                controller: 'MainCtrl',
                controllerAs: 'main',
                resolve: {
                    products: function ($http) {
                        return $http.get("/api/products").then(function (response) {
                            return response.data;
                        })
                    }
                }
            })

            .when('/orders', {
                templateUrl: 'app/views/orders.html',
                controller: 'OrderCtrl',
                controllerAs: 'orders',
                resolve: {
                    orders: function ($http) { //  data assign to order list
                        return $http.get("/api/orders").then(function (response) {
                            return response.data;
                        })
                    }
                }
            })

            // .when('/history', {
            //     templateUrl: 'app/views/history.html',
            //     controller: 'HistoryCtrl',
            //     controllerAs: 'history',
            //     resolve: {
            //         history: function ($http) {
            //             return $http.get("http://localhost:8080/shoppingcart/history").then(function (response) {
            //                 return response.data;
            //             })
            //         }
            //     }
            // })

            .otherwise({
                redirectTo: '/'
            });
    });
