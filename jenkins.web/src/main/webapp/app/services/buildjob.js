'use strict';

var buildjobService = angular.module('ng-dashboard.services.buildjob', ['ngResource']);

buildjobService.factory('BuildjobFactory', function ($resource) {
    return $resource('./api/v1/buildjob/default', {}, {
        query: { method: 'GET', params: {} }
    })
});