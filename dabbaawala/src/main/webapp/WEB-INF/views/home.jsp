<!doctype html>
<html>
<head>
<title>Hello AngularJS</title>
<link href="/resources/css/bootstrap.css" rel="stylesheet">
<link href="/resources/css/bootstrap-theme.css" rel="stylesheet">
<script src="/resources/js/angular.js" type="text/javascript"></script>
<script src="/resources/js/ui-bootstrap-tpls-0.14.3.js" type="text/javascript"></script>
<style type="text/css">
[ng\:cloak], [ng-cloak], .ng-cloak {
  display: none !important;
}
</style>
</head>

<body ng-app="hello" >
  <div class="container">
    <h1>Greeting</h1>
    <div ng-controller="home" ng-cloak class="ng-cloak">
      <p>The ID is {{greeting.id}}</p>
      <p>The content is {{greeting.content}}</p>
    </div>
  </div>
  <script src="js/angular-bootstrap.js" type="text/javascript"></script>
  <script src="js/hello.js"></script>
</body>
</html>