'use strict';

// declare modules
angular.module('Authentication', []);

var app = angular.module('app', ['Authentication','ngRoute','ngResource', 'ngCookies']);
app.config(function($routeProvider){
    $routeProvider
        .when('/user',{
            templateUrl: 'resources/static/views/users.html',
            controller: 'UserController'
        })
        .when('/user/create',{
            templateUrl: 'resources/static/views/createUser.html',
            controller: 'CreateUserController'
        })
        .when('/login', {
            templateUrl: 'resources/static/js/modules/authentication/views/login.html',
            controller: 'LoginController'
        })
        .when('/',{
             templateUrl: 'resources/static/views/createUser.html',
             controller: 'CreateUserController'
        })
        .otherwise({ redirectTo: '/login' });
})

.run(['$rootScope', '$location', '$cookieStore', '$http',
    function ($rootScope, $location, $cookieStore, $http) {
        // keep user logged in after page refresh
        $rootScope.globals = $cookieStore.get('globals') || {};

        $rootScope.$on('$locationChangeStart', function (event, next, current) {
            // redirect to login page if not logged in
            if ($location.path() !== '/login' && !$rootScope.globals.currentUser) {
                $location.path('/login');
            }
        });
    }]);
