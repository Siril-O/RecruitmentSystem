app.controller('UserController', ['$scope','$http', function($scope, $http) {
    $http.get('/RecruitmentSystem/user').then(
          function(response){
             $scope.users = response.data;
             console.log($scope.users);
          }
       );
    $scope.headingTitle = "All Users";
}]);

app.controller('CreateUserController', ['$scope','$http', function($scope, $http) {

    $scope.headingTitle = "Register";
    $scope.roles =['RECRUITER', 'APPLICANT'];
    $scope.genders =['MALE', 'FEMALE'];
    $scope.date = new Date();

    $scope.submitCreateUserForm = function(){
      var req = { method: 'POST',
                 url: '/RecruitmentSystem/user',
                 headers: {'Content-Type': 'application/json'},
                 data: $scope.user
                }
      console.log(req);
      $http(req).then(function successCallback(response) {$scope.message = 'Success'}, function errorCallback(response) {
                          $scope.message = response;
                          console.log(response);
                        });
    }
}]);

app.controller('CreatePositionController', ['$scope','$http', function($scope, $http) {

    $scope.headingTitle = "Create position";

    $scope.createPosition = function(){
      var req = { method: 'POST',
                 url: '/RecruitmentSystem/user',
                 headers: {'Content-Type': 'application/json'},
                 data: $scope.user
                }
      console.log(req);
      $http(req).then(function successCallback(response) {$scope.message = 'Success'}, function errorCallback(response) {
                          $scope.message = response;
                          console.log(response);
                        });
    }
}]);
