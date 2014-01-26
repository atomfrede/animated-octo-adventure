// create directive module (or retrieve existing module)
var App = angular.module('ng-dashboard.directives.testreport', []);

// create the "my-dir" directive
App.directive('testreport', function() {
	return {
		restrict : 'A',
		templateUrl : './app/templates/testreport.html'

	};
});
