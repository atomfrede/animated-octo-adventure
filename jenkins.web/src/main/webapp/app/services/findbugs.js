'use strict';

var findbugsService = angular.module('ng-dashboard.services.findbugs', ['ngResource']);

findbugsService.factory('FindbugsFactory', function ($resource) {
    return $resource('./api/v1/findbugs/default', {}, {
        query: { method: 'GET', params: {} }
    })
});