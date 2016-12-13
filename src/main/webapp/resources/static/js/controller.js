'use strict';

app.controller('UserController', ['UserService', 'ROLES', 'GENDER', '$scope', '$location', function (UserService, ROLES,
                                                                                                     GENDER, $scope, $location) {

    $scope.roles = ROLES;
    $scope.genders = GENDER;
    $scope.date = new Date();

    $scope.submitCreateUserForm = function () {
        $scope.headingTitle = "Register User";
        UserService.registerUser($scope.user).then(
            function () {
                $scope.message = 'Successfully registered';
            }, function (response) {
                if (response.status == 409) {
                    $scope.message = "User with email: already exist";
                } else {
                    $scope.message = "Error registering user";
                }
            }
        );
    };

    $scope.fetchUsers = function () {
        $scope.headingTitle = "All Users";
        UserService.fetchUsers().then(
            function (data) {
                $scope.users = data;
            },
            function (error) {
                $scope.message = "Error fetching users";
            }
        );
    };

    function init() {
        if ($location.path() != '/user/register') {
            $scope.fetchUsers();
        }
    }

    init();

}]);

app.controller('CompanyController', ['CompanyService', '$scope', function (CompanyService, $scope) {


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

app.controller('PositionController', ['PositionService', 'ApplyPositionService', 'AuthenticationService', '$scope',
    function (PositionService, ApplyPositionService, AuthenticationService, $scope) {

        $scope.positionStatuses = ['ACTIVE', 'CLOSED'];
        $scope.positionStatus = $scope.positionStatuses[0];

        $scope.fetchPositions = function () {
            var positions;
            PositionService.fetchPositions($scope.positionStatus)
                .then(
                    function (data) {
                        positions = data;
                        var filterParams = {
                            applicantEmails: AuthenticationService.getCurrentUser().email
                        };
                        ApplyPositionService.getApplicantsForPosition(filterParams).then(
                            function (data) {
                                $scope.applications = data;
                                var appliedPositionCodes = data.map(el = > el.position.code
                                )
                                ;
                                positions.forEach(function (position) {
                                    position.canApply = !appliedPositionCodes.includes(position.code);
                                });
                                $scope.positions = positions;
                            }, function () {
                                $scope.error = "Error fetching data";
                            }
                        )
                    },
                    function (error) {
                        $scope.error = "Error fetching data";
                    }
                );

            $scope.positions = positions;
        };

        $scope.createPosition = function (position) {
            position.companyName = position.companyName.name;
            PositionService.createPosition().then(
                function () {
                    $scope.message = 'Successfully registered';

                },
                function (error) {
                    $scope.error = "Error registering company";

                });
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

        $scope.isAuthorisedToViewApplicants = function () {
            return $scope.isAuthorisedToAddPositions();
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
            ApplyPositionService.applyForPosition(applyPosition).then(
                function (data) {
                    $scope.message = 'You have applied on position';
                },
                function (response) {
                    if (response.status == 409) {
                        $scope.message = "You have already applied on this position";
                    } else {
                        $scope.message = "Error applying on position";
                    }
                }
            );
        };


    }]);

app.controller('ApplicationsController', ['ApplyPositionService', '$scope',
    function (ApplyPositionService, $scope) {

        $scope.fetchApplies = function () {
            var position = ApplyPositionService.getPosition();
            ApplyPositionService.getApplicantsForPosition({positionCodes: position.code}).then(
                function (data) {
                    $scope.applications = data;
                },
                function (error) {
                    $scope.error = "Error fetching data";
                }
            );
        };

        $scope.fetchApplies();

    }]);
