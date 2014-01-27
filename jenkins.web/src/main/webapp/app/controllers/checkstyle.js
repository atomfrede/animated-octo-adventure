'use strict';

/* Controllers */

var app = angular.module('ng-dashboard.controllers.checkstyle', []);

app.controller('CheckstyleController', ['$scope', 'CheckstyleFactory', function ($scope, CheckstyleFactory) {
	CheckstyleFactory.query({}, function (data) {
	    $scope.numberOfWarnings = data.numberOfWarnings;
	    $scope.numberOfHighPriorityWarnings = data.numberOfHighPriorityWarnings;
	    $scope.numberOfNormalPriorityWarnings = data.numberOfNormalPriorityWarnings;
	    $scope.numberOfLowPriorityWarnings = data.numberOfLowPriorityWarnings;
	    $scope.numberOfNewWarnings = data.numberOfFixedWarnings - data.numberOfNewWarnings;
	    
	    setupCheckstyleChart(data);
	    
	    if((data.numberOfFixedWarnings - data.numberOfNewWarnings) > 0){
	    	$scope.more = true;
	    } else if((data.numberOfFixedWarnings - data.numberOfNewWarnings) < 0) {
	    	$scope.less = true;
	    } else {
	    	$scope.same = true;
	    }
	    
	    $scope.done = true;

	  }, function (error) {
		  $scope.error = true;
	  })
}]);

function setupCheckstyleChart(data) {
	var chartData = [
	        	{
	        		value: data.numberOfHighPriorityWarnings,
	        		color:"#d9534f"
	        	},
	        	{
	        		value : data.numberOfNormalPriorityWarnings,
	        		color : "#f0ad4e"
	        	},
	        	{
	        		value : data.numberOfLowPriorityWarnings,
	        		color : "#5bc0de"
	        	}

	        ]
	var ctx = document.getElementById("checkstyle-chart").getContext("2d");
	var checkstyleChart = new Chart(ctx).Doughnut(chartData);
}