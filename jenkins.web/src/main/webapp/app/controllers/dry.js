'use strict';

/* Controllers */

var app = angular.module('ng-dashboard.controllers.dry', []);

app.controller('DryController', ['$scope', 'DryFactory', function ($scope, DryFactory) {
	DryFactory.query({}, function (data) {
	    $scope.numberOfWarnings = data.numberOfWarnings;
	    $scope.numberOfHighPriorityWarnings = data.numberOfHighPriorityWarnings;
	    $scope.numberOfNormalPriorityWarnings = data.numberOfNormalPriorityWarnings;
	    $scope.numberOfLowPriorityWarnings = data.numberOfLowPriorityWarnings;
	    setupDryChart(data);
	    
	    if((data.numberOfFixedWarnings - data.numberOfNewWarnings) > 0){
	    	$scope.more = true;
	    } else if((data.numberOfFixedWarnings - data.numberOfNewWarnings) < 0) {
	    	$scope.more = true;
	    } else {
	    	$scope.same = true;
	    }
	    
	    $scope.done = true;

	  })
}]);

function setupDryChart(data) {
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
	var ctx = document.getElementById("dry-chart").getContext("2d");
	var dryChart = new Chart(ctx).Doughnut(chartData);
}