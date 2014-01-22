'use strict';

/* Controllers */

var app = angular.module('ng-dashboard.controllers.buildjob', []);

app.controller('BuildjobController', ['$scope', 'BuildjobFactory', function ($scope, BuildjobFactory) {
	BuildjobFactory.query({}, function (data) {
	    $scope.fullDisplayName = data.fullDisplayName;
	    if(data.result === 'SUCCESS') {
	    	$scope.success = true;
	    } else if(data.result === 'UNSTABLE') {
	    	$scope.unstable = true;
	    } else if(data.result === 'FAILURE') {
	    	$scope.failure = true;
	    }

	  })
}]);

