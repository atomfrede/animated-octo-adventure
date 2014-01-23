'use strict';

/* Controllers */

var app = angular.module('ng-dashboard.controllers.leaderboard', []);

app.controller('LeaderboardController', ['$scope', 'LeaderboardFactory', function ($scope, LeaderboardFactory) {
	LeaderboardFactory.query({}, function (data) {
		console.log(data);
		$scope.participants = data.participants;
	  })
}]);

