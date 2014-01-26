// create directive module (or retrieve existing module)
var App = angular.module('ng-dashboard.directives.jacoco', []);

// create the "my-dir" directive
App.directive('jacoco', function() {
	return {
		restrict : 'A',
		templateUrl : './app/templates/jacoco.html'

	};
});
