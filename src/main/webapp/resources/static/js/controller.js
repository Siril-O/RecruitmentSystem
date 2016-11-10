'use strict';

app.controller('UserController', ['ROLES', '$scope', '$http', '$location', function (ROLES, $scope, $http, $location) {

    $scope.roles = ['RECRUITER', 'APPLICANT'];
    $scope.genders = ['MALE', 'FEMALE'];
    $scope.date = new Date();

    $scope.submitCreateUserForm = function () {
        $scope.headingTitle = "Register User";
        $http.post('/RecruitmentSystem/user', $scope.user).then(function successCallback(response) {
            $scope.message = 'Successfully registered';
        }, function errorCallback(response) {
            if (response.status == 409) {
                $scope.message = "User with email: already exist";
            } else {
                $scope.message = "Error registering user";
            }
            console.log(response);
        });
    };

    $scope.fetchUsers = function () {
        $scope.headingTitle = "All Users";
        $http.get('/RecruitmentSystem/user').then(
            function (response) {
                $scope.users = response.data;
                console.log($scope.users);
            },
            function errorCallback(response) {
                $scope.message = "Error fetching data";
                console.log(response);
            });
    };

    function init() {
        if ($location.path() != '/user/register') {
            $scope.fetchUsers();
        }
    }

    init();

}]);

app.controller('CompanyController', ['CompanyService', '$scope', '$http', function (CompanyService, $scope, $http) {


    $scope.createCompany = function () {
        $scope.headingTitle = "Register company";
        CompanyService.createCompany($scope.company)
            .then(
                function (data) {
                    $scope.message = 'Successfully registered';
                },
                function (error) {
                    $scope.error = "Error creating company";
                }
            );
    };

    $scope.fetchCompanies = function () {
        $scope.headingTitle = "All registered companies";
        CompanyService.fetchCompanies()
            .then(
                function (data) {
                    $scope.companies = data;
                },
                function (error) {
                    $scope.error = "Error fetching data";
                }
            );
    };

    $scope.fetchCompanies();

}]);

app.controller('PositionController', ['ApplyPositionService', 'AuthenticationService', '$scope', '$http',
    function (ApplyPositionService, AuthenticationService, $scope, $http) {

        $scope.positionStatuses = ['ACTIVE', 'CLOSED'];
        $scope.positionStatus = $scope.positionStatuses[0];

        $scope.fetchPositions = function () {
            $http({
                url: '/RecruitmentSystem/position',
                method: "GET",
                params: {
                    status: $scope.positionStatus
                }
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
            $scope.fetchPositions();
        };

        $scope.isAuthorisedToAddPositions = function () {
            return AuthenticationService.getCurrentUser().userRole == 'RECRUITER';
        };

        $scope.isAuthorisedToApplyPositions = function () {
            return AuthenticationService.getCurrentUser().userRole == 'APPLICANT';
        };

        $scope.setPosition = function (position) {
            ApplyPositionService.setPosition(position);
        };


        $scope.fetchPositions();

    }]);

app.controller('ApplyPositionController', ['ApplyPositionService', 'AuthenticationService', '$scope',
    function (ApplyPositionService, AuthenticationService, $scope) {

        $scope.position = ApplyPositionService.getPosition();

        $scope.applyForPosition = function (applyPosition) {
            applyPosition.applicantEmail = AuthenticationService.getCurrentUser().email;
            applyPosition.positionCode = $scope.position.code;
            console.log(applyPosition);
                ApplyPositionService.applyForPosition(applyPosition).then(
                    function (data) {
                        $scope.message = 'You have applied on position';
                    },
                    function (error) {
                        $scope.error = "Error applying on position";
                    }
                );
        }
    }]);
