'use strict';

/* Controllers */

var app = angular.module('ng-dashboard.controllers.findbugs', []);

app.controller('FindbugsController', ['$scope', 'FindbugsFactory', function ($scope, FindbugsFactory) {
	FindbugsFactory.query({}, function (data) {
	    $scope.numberOfWarnings = data.numberOfWarnings;
	    $scope.numberOfHighPriorityWarnings = data.numberOfHighPriorityWarnings;
	    $scope.numberOfNormalPriorityWarnings = data.numberOfNormalPriorityWarnings;
	    $scope.numberOfLowPriorityWarnings = data.numberOfLowPriorityWarnings;

	    $scope.diffLow = data.numberOfNewLowPriorityWarnings;
	    $scope.diffNormal = data.numberOfNewNormalPriorityWarnings;
	    $scope.diffHigh = data.numberOfNewHighPriorityWarnings;

	    $scope.numberOfNewWarnings = data.numberOfNewWarnings - data.numberOfFixedWarnings;

	    setupFindbugsChart(data);
	    
	    if((data.numberOfFixedWarnings - data.numberOfNewWarnings) > 0){
	    	$scope.less = true;
	    } else if((data.numberOfFixedWarnings - data.numberOfNewWarnings) < 0) {
	    	$scope.more = true;
	    } else {
	    	$scope.same = true;
	    }
	    
	    $scope.done = true;
	    
	    fn_computeSize();

	  }, function (error) {
		  $scope.error = true;
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