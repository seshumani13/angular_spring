<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User Management</title>
<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.3.3/angular.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.3.3/angular-route.min.js"></script>
</head>
<body>
<h1> Student Management</h1>
<div ng-app="mainApp">
<p><a href="#addStudent">Add Student</a></p>
<p><a href="#viewStudent">View Student</a></p>
<p><a href="#edit">Edit Student Record</a></p>
<p><a href="#delete">Delete Student Record</a></p>
<div ng-view></div>
<div ng-bind-html="content"></div>
</div>

<script>
var mainApp = angular.module("mainApp",['ngRoute']);
mainApp.config(['$routeProvider',function($routeProvider){
	$routeProvider.
	when('/addStudent',{
		templateUrl:'addStudent.jsp'
		
	}).
	when('/viewStudent',{
	
	
	templateUrl:'http://localhost:8080/Angular_SpringMVC/viewStudent'
	//controller:'viewController'
	
	}).
	when('/edit',{
		templateUrl:'edit.jsp'
		
	}).
	when('/delete',{
	
		templateUrl:'delete.jsp'
		
	});


}]);

mainApp.controller("viewController",function($scope,$http,$sce){
alert("inside controller");
	$http.get("http://localhost:8080/Angular_SpringMVC/viewStudent")
	.then(function(response){
	console.log("list from controller"+response.data);
	$scope.content=$sce.trustAsHtml(response.data);
	},function(response){
	//console.log("list not retrieved");
	$scope.content="Something went wrong";
	});
});

</script>
</body>

</html>