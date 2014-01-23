'use strict';

var testreportService = angular.module('ng-dashboard.services.testreport', ['ngResource']);

testreportService.factory('TestreportFactory', function ($resource) {
    return $resource('./api/v1/testreport/default', {}, {
        query: { method: 'GET', params: {} }
    })
});