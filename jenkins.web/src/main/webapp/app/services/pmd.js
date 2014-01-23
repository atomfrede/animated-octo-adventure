'use strict';

var pmdService = angular.module('ng-dashboard.services.pmd', ['ngResource']);

pmdService.factory('PmdFactory', function ($resource) {
    return $resource('./api/v1/pmd/default', {}, {
        query: { method: 'GET', params: {} }
    })
});