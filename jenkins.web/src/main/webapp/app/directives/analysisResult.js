// create directive module (or retrieve existing module)
var App = angular.module('ng-dashboard.directives.demo', []);

// create the "my-dir" directive 
App.directive('demo', function($http) {
	  return {
	    restrict: 'A',
	    scope: {
	    	chart: '@',
	    	widget: '@',
	    	icon: '@'
	    	
	    },

	    transclude: true,
	    templateUrl: './app/templates/analysisResult.html'
	  
	  };
	});


