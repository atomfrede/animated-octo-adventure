'use strict';

/* Controllers */

var app = angular.module('ng-dashboard.controllers.findbugs', []);

app.controller('FindbugsController', ['$scope', 'FindbugsFactory', function ($scope, FindbugsFactory) {
	FindbugsFactory.query({}, function (data) {
	    $scope.numberOfWarnings = data.numberOfWarnings;
	    $scope.numberOfHighPriorityWarnings = data.numberOfHighPriorityWarnings;
	    $scope.numberOfNormalPriorityWarnings = data.numberOfNormalPriorityWarnings;
	    $scope.numberOfLowPriorityWarnings = data.numberOfLowPriorityWarnings;
	    setupFindbugsChart(data);
	    
	    if((data.numberOfFixedWarnings - data.numberOfNewWarnings) > 0){
	    	$scope.more = true;
	    } else if((data.numberOfFixedWarnings - data.numberOfNewWarnings) > 0) {
	    	$scope.more = true;
	    } else {
	    	$scope.same = true;
	    }
	    
	    $scope.done = true;

	  })
}]);

function setupFindbugsChart(data) {
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
	var ctx = document.getElementById("findbugs-chart").getContext("2d");
	var findbugsChart = new Chart(ctx).Doughnut(chartData);
}