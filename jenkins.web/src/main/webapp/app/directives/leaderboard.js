// create directive module (or retrieve existing module)
var App = angular.module('ng-dashboard.directives.leaderboard', []);

// create the "my-dir" directive
App.directive('leaderboard', function() {
	return {
		restrict : 'A',
		templateUrl : './app/templates/leaderboard.html'

	};
});
