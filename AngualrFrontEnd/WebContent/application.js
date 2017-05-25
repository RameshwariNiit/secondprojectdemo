/**
 * 
 */


var app=angular.module('MyApplication',['ngRoute','regmodule','loginapp','ngCookies']);

app.constant('REST_URI','http://localhost:8086/fraternization/');

app.controller('HomeController',function($scope,$rootScope,$cookies){
	/*$rootScope.Userrole="home";*/
	$rootScope.Userrole=$cookies.get('role');
	console.log($cookies.get('role'));
	var name='secondproject';
	$scope.name=name;
	console.log(name);
})


app.config(function($routeProvider)
{
	
	$routeProvider
	.when("/home",{
		templateUrl:'index.html',
		controller :'HomeController',
		controllerAs:'home'
	})
	
	.when("/signup",
			
	{
		templateUrl :'./userdata/SignUp.html',
		controller : 'RegisterController',
		controllerAs:'regCtrl'
		
			
	})
		
	}		

)


