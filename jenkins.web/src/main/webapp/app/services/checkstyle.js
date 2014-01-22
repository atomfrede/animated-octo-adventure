'use strict';

var findbugsService = angular.module('ng-dashboard.services.checkstyle', ['ngResource']);

findbugsService.factory('CheckstyleFactory', function ($resource) {
    return $resource('./api/v1/checkstyle/default', {}, {
        query: { method: 'GET', params: {} }
    })
});