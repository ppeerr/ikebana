'use strict';

angular.module('ikebana')
    .controller('OrderCtrl', ['$scope', 'orders', '$http', function ($scope, orders, $http) {
        $scope.ordersList = orders;
    }]);