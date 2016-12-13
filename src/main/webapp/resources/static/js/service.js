'use strict';

app.factory('CompanyService', ['$http', '$q', function ($http, $q) {

    return {

        createCompany: function (company) {
            return $http.post('/RecruitmentSystem/company', company)
                .then(function successCallback(response) {
                    return response.data;
                }, function errorCallback(errResponse) {
                    $scope.message = 'Error registering company';
                    return $q.reject(errResponse);
                });
        },

        fetchCompanies: function () {
            return $http.get('/RecruitmentSystem/company').then(
                function (response) {
                    return response.data;
                }, function (errResponse) {
                    console.error('Error fetching companies');
                    return $q.reject(errResponse);
                }
            );
        }
    }
}]);

app.factory('PositionService', ['$http', '$q', function ($http, $q) {

    return {
        fetchPositions: function (positionStatus) {
            return $http({
                url: '/RecruitmentSystem/position',
                method: "GET",
                params: {
                    status: positionStatus
                }
            }).then(
                function (response) {
                    return response.data;
                }, function (errResponse) {
                    console.error('Error fetching positions');
                    return $q.reject(errResponse);
                }
            );
        },
        createPosition: function (position) {
            $http.post('/RecruitmentSystem/position', position)
                .then(function (response) {
                    return 'Successfully registered';
                }, function () {
                    console.error('Error creating new positions');
                    return $q.reject(errResponse);
                })
        }

    }
}]);

app.factory('ApplyPositionService', ['$http', '$q', function ($http, $q) {

    var positionCode;

    return {
        setPosition: function (newPosition) {
            positionCode = newPosition;
        },
        getPosition: function () {
            return positionCode;
        },
        applyForPosition: function (applyPosition) {
            return $http.put('/RecruitmentSystem/position/apply', applyPosition).then(
                function (response) {
                    return response.data;
                }, function (errResponse) {
                    return $q.reject(errResponse);
                }
            );
        },
        getApplicantsForPosition: function (filterParams) {
            return $http({
                url: '/RecruitmentSystem/position/application',
                method: "GET",
                params: filterParams
            }).then(
                function (response) {
                    return response.data;
                }, function (errResponse) {
                    return $q.reject(errResponse);
                }
            );
        }
    }

}]);

app.factory('UserService', ['$http', '$q', function ($http, $q) {
    return {
        fetchUsers: function () {
            return $http.get('/RecruitmentSystem/user').then(
                function (response) {
                    return response.data;
                },
                function errorCallback(response) {
                    console.error('Error fetching users');
                    return $q.reject(errResponse);
                });
        },
        registerUser: function (user) {
            return $http.post('/RecruitmentSystem/user', user).then(
                function (response) {
                    return response;
                },
                function errorCallback(errResponse) {
                    console.error('Error registering user');
                    return $q.reject(errResponse);
                });
        }
    }
}]);

