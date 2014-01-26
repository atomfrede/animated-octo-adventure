'use strict';

/* Controllers */

var app = angular.module('ng-dashboard.controllers.jacoco', []);

app.controller('JacocoController', ['$scope', 'JacocoFactory', function ($scope, JacocoFactory) {
	JacocoFactory.query({}, function (data) {
	    setupJacocoChart(data);
	    $scope.done = true;

	  },
	  function (error) {
		  $scope.error = true;
	  })
}]);

function setupJacocoChart(data) {
	var chartData = {
			labels : ["Method","Branch","Line"],
			datasets : [
			    		{
			    			fillColor : "rgba(220,220,220,0.5)",
			    			strokeColor : "rgba(220,220,220,1)",
			    			data : [data.methodCoverage.percentage, data.branchCoverage.percentage, data.lineCoverage.percentage]
			    		}

			    	]
	}

	var ctx = document.getElementById("jacoco-chart").getContext("2d");
	var jacocoChart = new Chart(ctx).Bar(chartData);
}