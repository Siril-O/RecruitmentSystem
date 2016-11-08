<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<!--[if lt IE 7]>      <html lang="en" ng-app="app" class="no-js lt-ie9 lt-ie8 lt-ie7"> <![endif]-->
<!--[if IE 7]>         <html lang="en" ng-app="app" class="no-js lt-ie9 lt-ie8"> <![endif]-->
<!--[if IE 8]>         <html lang="en" ng-app="app" class="no-js lt-ie9"> <![endif]-->
<!--[if gt IE 8]><!--> <html lang="en" ng-app="app" class="no-js"> <!--<![endif]-->

<c:url var="angularUrl" value="/webjars/angularjs/1.4.8/angular.js" />
<c:url var="angularResourceUrl" value="/webjars/angularjs/1.4.8/angular-resource.js" />
<c:url var="angularRouteUrl" value="/webjars/angularjs/1.4.8/angular-route.js" />
<c:url var="angularCookieUrl" value="/webjars/angular-cookies/1.4.8/angular-cookies.js" />

<c:url var="appJsUrl" value="/resources/static/js/app.js" />
<c:url var="controllerJsUrl" value="/resources/static/js/controller.js" />
<c:url var="serviceJsUrl" value="/resources/static/js/service.js" />

<c:url var="constantsJsUrl" value="/resources/static/js/constants.js" />
<c:url var="authenticationControllerUrl" value="/resources/static/js/modules/authentication/controllers.js" />
<c:url var="authenticationServiceUrl" value="/resources/static/js/modules/authentication/services.js" />

<c:url var="bootstrapUrl" value="/webjars/bootstrap/3.3.6/css/bootstrap.css" />
<c:url var="appCssUrl" value="/resources/static/css/app.css" />

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>Recruiting system home page</title>
    <meta name="description" content="">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="${appCssUrl}">
</head>
<body>
<nav class="navbar navbar-default">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="#">Recruiting system</a>
    </div>
    <ul class="nav navbar-nav">
      <li><a href="#/user">Users</a></li>
      <li><a href="#/user/create">Add new user</a></li>
      <li><a ng-controller="LoginController" ng-click="logout()" href="#">Logout</a></li>
    </ul>
  </div>
</nav>
<div ng-view class ="container" class="ng-cloak"></div>
<script src="${angularUrl}"></script>
<script src="${angularResourceUrl}"></script>
<script src="${angularRouteUrl}"></script>
<script src="${appJsUrl}"></script>
<script src="${controllerJsUrl}"></script>
<script src="${serviceJsUrl}"></script>
<link rel="stylesheet" href="${bootstrapUrl}">

<script src="${authenticationControllerUrl}"></script>
<script src="${authenticationServiceUrl}"></script>
<script src="${angularCookieUrl}"></script>
</body>
</html>