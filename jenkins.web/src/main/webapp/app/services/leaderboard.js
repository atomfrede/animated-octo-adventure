'use strict';

var leaderboardService = angular.module('ng-dashboard.services.leaderboard', ['ngResource']);

leaderboardService.factory('LeaderboardFactory', function ($resource) {
    return $resource('./api/v1/leaderboard/default', {}, {
        query: { method: 'GET', params: {} }
    })
});