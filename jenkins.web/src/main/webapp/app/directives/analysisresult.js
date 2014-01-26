// create directive module (or retrieve existing module)
var App = angular.module('ng-dashboard.directives.analysisresult', []);

// create the "my-dir" directive
App.directive('analysisresult', function() {
	return {
		restrict : 'A',
		scope : {
			chart : '@',
			widget : '@',
			icon : '@'

		},

		transclude : true,
		templateUrl : './app/templates/analysisresult.html'

	};
});
