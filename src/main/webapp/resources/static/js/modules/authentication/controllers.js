'use strict';

angular.module('Authentication')

    .controller('LoginController',
        ['$scope', '$rootScope', '$location', 'AuthenticationService',
            function ($scope, $rootScope, $location, AuthenticationService) {
                // reset login status
                AuthenticationService.clearCredentials();

                $scope.login = function () {
                    AuthenticationService.login($scope.username, $scope.password)
                        .then(function (data) {
                            AuthenticationService.setCredentials(data);
                            $location.path('/');
                        }, function () {
                            $scope.message = 'Wrong username or password';
                            console.log(response);
                        });


                };

                $scope.logout = function () {
                    AuthenticationService.clearCredentials();
                    $location.path('/login');
                };
            }]);

