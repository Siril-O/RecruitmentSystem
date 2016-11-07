<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<!--[if lt IE 7]>      <html lang="en" ng-app="app" class="no-js lt-ie9 lt-ie8 lt-ie7"> <![endif]-->
<!--[if IE 7]>         <html lang="en" ng-app="app" class="no-js lt-ie9 lt-ie8"> <![endif]-->
<!--[if IE 8]>         <html lang="en" ng-app="app" class="no-js lt-ie9"> <![endif]-->
<!--[if gt IE 8]><!--> <html lang="en" ng-app="app" class="no-js"> <!--<![endif]-->

<c:url var="angularUrl" value="/webjars/angularjs/1.4.8/angular.js" />
<c:url var="angularResourceUrl" value="/webjars/angularjs/1.4.8/angular-resource.js" />
<c:url var="angularRouteUrl" value="/webjars/angularjs/1.4.8/angular-route.js" />

<c:url var="appJsUrl" value="/resources/static/js/app.js" />
<c:url var="controllerJsUrl" value="/resources/static/js/controller.js" />
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
<h2>Recruiting system home page</h2>
<div class="home-section">
    <ul class="menu-list">
        <li><a href="#/user">Users</a></li>
        <li><a href="#/user/create">Add new user</a></li>
    </ul>
</div>
<div ng-view class ="container"></div>
<script src="${angularUrl}"></script>
<script src="${angularResourceUrl}"></script>
<script src="${angularRouteUrl}"></script>
<script src="${appJsUrl}"></script>
<script src="${controllerJsUrl}"></script>
<link rel="stylesheet" href="${bootstrapUrl}">
</body>
</html>