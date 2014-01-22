'use strict';

var dryService = angular.module('ng-dashboard.services.dry', ['ngResource']);

dryService.factory('DryFactory', function ($resource) {
    return $resource('./api/v1/dry/default', {}, {
        query: { method: 'GET', params: {} }
    })
});