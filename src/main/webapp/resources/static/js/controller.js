'use strict';

app.controller('UserController', ['$scope', '$http', function ($scope, $http) {

    $scope.headingTitle = "Register";
    $scope.roles = ['RECRUITER', 'APPLICANT'];
    $scope.genders = ['MALE', 'FEMALE'];
    $scope.date = new Date();

    $scope.submitCreateUserForm = function () {
        $scope.headingTitle = "All Users";
        $http.post('/RecruitmentSystem/user', $scope.user).then(function successCallback(response) {
            $scope.message = 'Successfully registered';
        }, function errorCallback(response) {
            $scope.message = response;
            console.log(response);
        });
    };

    $scope.fetchUsers = function () {
        $scope.headingTitle = "All Users";
        $http.get('/RecruitmentSystem/user').then(
            function (response) {
                $scope.users = response.data;
                console.log($scope.users);
            }, function errorCallback(response) {
                $scope.message = "Error fetching data";
                console.log(response);
            });
    };

    $scope.fetchUsers();

}]);

app.controller('CompanyController', ['$scope', '$http', function ($scope, $http) {


    $scope.createCompany = function () {
        $scope.headingTitle = "Register company";
        $http.post('/RecruitmentSystem/company', $scope.company)
            .then(function successCallback(response) {
                $scope.message = 'Successfully registered';
            }, function errorCallback(response) {
                $scope.message = 'Error registering company';
                console.log(response);
            });
    };


    $scope.fetchCompanies = function () {
        $http.get('/RecruitmentSystem/company').then(
            function (response) {
                $scope.companies = response.data;
            }, function (response) {
                $scope.error = "Error fetching data";
            }
        );
        $scope.headingTitle = "All registered companies";
    };

    $scope.fetchCompanies();

}]);

app.controller('PositionController', ['$scope', '$http', function ($scope, $http) {

    $scope.positionStatuses = ['ACTIVE', 'CLOSED'];
    $scope.positionStatus = $scope.positionStatuses[0];

    $scope.fetchPositions = function () {
        $http({
            url: '/RecruitmentSystem/position',
            method: "GET",
            params: {status: $scope.positionStatus}
        })
            .then(function successCallback(response) {
                $scope.positions = response.data;
            }, function errorCallback(response) {
                $scope.message = "Error fetching data";
                console.log(response);
            });
    };

    $scope.createPosition = function (position) {
        position.companyName = position.companyName.name;
        $http.post('/RecruitmentSystem/position', position)
            .then(function (response) {
                $scope.message = 'Successfully registered';
            }, function () {
                $scope.message = 'Error registering company';
                console.log(response);
            })
    };

    $scope.changeFetchedStatuses = function (newStatus) {
        $scope.positionStatus = newStatus;
    };

    $scope.fetchPositions();

}]);