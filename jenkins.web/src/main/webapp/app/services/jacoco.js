'use strict';

var jacocoService = angular.module('ng-dashboard.services.jacoco', ['ngResource']);

jacocoService.factory('JacocoFactory', function ($resource) {
    return $resource('./api/v1/jacoco/default', {}, {
        query: { method: 'GET', params: {} }
    })
});