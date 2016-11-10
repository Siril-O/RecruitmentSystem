'use strict';

// declare modules
angular.module('Authentication', []);

var app = angular.module('app', ['Authentication', 'ngRoute', 'ngResource', 'ngCookies']);
app.config(function ($routeProvider) {
    $routeProvider
        .when('/user', {
            templateUrl: 'resources/static/views/user/list.html',
            controller: 'UserController'
        })
        .when('/user/register', {
            templateUrl: 'resources/static/views/user/register.html',
            controller: 'UserController'
        })
        .when('/position/create', {
            templateUrl: 'resources/static/views/position/create.html',
            controller: 'PositionController'
        })
        .when('/position', {
            templateUrl: 'resources/static/views/position/list.html',
            controller: 'PositionController'
        })
        .when('/company/create', {
            templateUrl: 'resources/static/views/company/create.html',
            controller: 'CompanyController'
        })
        .when('/company', {
            templateUrl: 'resources/static/views/company/list.html',
            controller: 'CompanyController'
        })
        .when('/login', {
            templateUrl: 'resources/static/js/modules/authentication/views/login.html',
            controller: 'LoginController'
        })
        .when('/', {
            templateUrl: 'resources/static/views/position/list.html',
            controller: 'PositionController'
        })
        .when('/position/apply', {
            templateUrl: 'resources/static/views/position/apply.html',
            controller: 'ApplyPositionController'
        })
        .otherwise({redirectTo: '/'});
})

    .run(['$rootScope', '$location', '$cookieStore',
        function ($rootScope, $location, $cookieStore) {
            // keep user logged in after page refresh
            $rootScope.globals = $cookieStore.get('globals') || {};

            $rootScope.$on('$locationChangeStart', function (event, next, current) {
                // redirect to login page if not logged in
                if ($location.path() !== '/login' && $location.path() !== '/user/register' && !$rootScope.globals.currentUser) {
                    $location.path('/login');
                }
            });
        }]);
    app.constant('ROLES', ['RECRUITER', 'APPLICANT']);


