'use strict';

app.factory('CompanyService', ['$http', '$q', function ($http, $q) {

    return {

        createCompany: function (company) {
            return $http.post('/RecruitmentSystem/company', company)
                .then(function successCallback(response) {
                    return response.data;
                }, function errorCallback(response) {
                    $scope.message = 'Error registering company';
                    return $q.reject(errResponse);
                });
        },

        fetchCompanies: function () {
            return $http.get('/RecruitmentSystem/company').then(
                function (response) {
                    return response.data;
                }, function (response) {
                    console.error('Error fetching companies');
                    return $q.reject(errResponse);
                }
            );
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
                }, function (response) {
                    console.error('Error fetching companies');
                    return $q.reject(errResponse);
                }
            );
        }
    }

}]);

