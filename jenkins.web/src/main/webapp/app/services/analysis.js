'use strict';

var analysisService = angular.module('ng-dashboard.services.analysis', ['ngResource']);

analysisService.factory('AnalysisFactory', function ($resource) {
    return $resource('./api/v1/analysis/default', {}, {
        query: { method: 'GET', params: {} }
    })
});