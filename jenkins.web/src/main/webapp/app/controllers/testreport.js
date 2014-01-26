'use strict';

/* Controllers */

var app = angular.module('ng-dashboard.controllers.testreport', []);

app.controller('TestreportController', ['$scope', 'TestreportFactory', function ($scope, TestreportFactory) {
	TestreportFactory.query({}, function (data) {
	    $scope.totalcount = data.totalCount;
	    $scope.successcount = data.totalCount - data.failCount;
	    if(data.failCount > 0) {
	    	$scope.failed = true;
	    } else {
	    	$scope.good = true;
	    }
	    
	    $scope.done = true;

	  }, function(error) {
		  $scope.error = true;
	  })
}]);

