var app = angular.module('app', ['ngRoute','ngResource']);
app.config(function($routeProvider){
    $routeProvider
        .when('/user',{
            templateUrl: 'resources/static/views/users.html',
            controller: 'userController'
        })
        .when('/user/create',{
            templateUrl: 'resources/static/views/createUser.html',
            controller: 'createUserController'
        })
        .otherwise(
            { redirectTo: '/'}
        );
});