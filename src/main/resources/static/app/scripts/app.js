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

                  products: function() {
                    return [
                    {"id":1,
                    "type":"BOUQUET",
                    "name":"Букет1",
                    "description":"Букет алых роз",
                    "quantity":25,
                    "price":1000},
                    {"id":2,
                     "type":"BOUQUET",
                     "name":"Букет2",
                     "description":"Букет белых роз",
                     "quantity":10,
                     "price":2000},
                    {"id":3,
                     "type":"BASKET",
                     "name":"Корзинка1",
                     "description":"Корзинка с лютиками",
                     "quantity":100,"price":1500}
                    ];
                      }
//                    products: function ($http) {
//                        return $http.get("http://128.199.36.211:9090/api/products").then(function (response) {
//                            return response.data;
//                        })
//                    }
                }
            })

            .when('/orders', {
                templateUrl: 'app/views/orders.html',
                controller: 'OrderCtrl',
                controllerAs: 'orders',
                resolve: {
                    orders: function ($http) { //  data assign to order list
                        return $http.get("http://128.199.36.211:9090/api/orders").then(function (response) {
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
