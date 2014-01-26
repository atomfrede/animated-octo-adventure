<!DOCTYPE html>
<html>
<link rel='stylesheet' href='./webjars/bootstrap/3.0.3/css/bootstrap.min.css'>
<link rel="stylesheet" href="./webjars/bootstrap/3.0.3/css/bootstrap-theme.min.css">
<link rel="stylesheet" href="./webjars/font-awesome/4.0.3/css/font-awesome.min.css">
<link rel="stylesheet" href="./resources/css/dashboard.css">
<link rel="stylesheet" href="./resources/css/bootstrap-notify.css">
<script src="./webjars/jquery/2.0.3/jquery.min.js"></script>
<script src="./webjars/bootstrap/3.0.3/js/bootstrap.min.js"></script>
<script src="./webjars/angularjs/1.2.9/angular.js"></script>
<script src="./webjars/angularjs/1.2.9/angular-resource.js"></script>
<script src="./resources/js/lib/chart.min.js"></script>
<script src="./resources/js/lib/bootstrap-notify.js"></script>
<script src="./app/app.js"></script>
<script src="./app/services/findbugs.js"></script>
<script src="./app/controllers/findbugs.js"></script>
<script src="./app/services/checkstyle.js"></script>
<script src="./app/controllers/checkstyle.js"></script>
<script src="./app/services/analysis.js"></script>
<script src="./app/controllers/analysis.js"></script>
<script src="./app/services/dry.js"></script>
<script src="./app/controllers/dry.js"></script>
<script src="./app/services/buildjob.js"></script>
<script src="./app/controllers/buildjob.js"></script>
<script src="./app/services/testreport.js"></script>
<script src="./app/controllers/testreport.js"></script>
<script src="./app/services/pmd.js"></script>
<script src="./app/controllers/pmd.js"></script>
<script src="./app/services/leaderboard.js"></script>
<script src="./app/controllers/leaderboard.js"></script>
<script src="./app/services/jacoco.js"></script>
<script src="./app/controllers/jacoco.js"></script>

<script src="./app/directives/analysisresult.js"></script>
<script src="./app/directives/leaderboard.js"></script>
<script src="./app/directives/testreport.js"></script>
<script src="./app/directives/jacoco.js"></script>

<body ng-app="ng-dashboard" class="container">


<div class="row">
	<div class="panel " ng-class="{'panel-success': success, 'panel-warning': unstable, 'panel-danger': failure}" ng-controller="BuildjobController">
  <div class="panel-heading" >{{fullDisplayName}}</div>
  
  <div class="panel-body">
  
	<div analysisresult done={{done}} chart="analysis-chart"
			widget="Analysis"
			icon="fa-warning"
			ng-controller="AnalysisController"></div>
			
	
		<div analysisresult  done={{done}} chart="findbugs-chart" 
   			widget="Findbugs" 
   			icon="fa-bug	" 
   			ng-controller="FindbugsController"></div>
   					
   	<div analysisresult chart="checkstyle-chart" 
   			widget="Checkstyle" 
   			icon="fa-check-square-o" 
   			ng-controller="CheckstyleController"></div>
   			
   	<div analysisresult chart="dry-chart" 
   			widget="DRY" 
   			icon="fa-copy" 
   			ng-controller="DryController"></div>


<div jacoco></div>

<div testreport></div>

<div leaderboard></div>



</div>
</div>
</div>

</body>
<script type="text/javascript">
$( document ).ready(function() {
	var ws = new WebSocket('ws://localhost:8080/jenkins-monitor/notifications');
	
	  ws.onopen = function(event) {
	      console.log('websocket connection open', event);
	      ws.send('a message from the client');
	  };
	  
	  ws.onclose = function(event) {
	      console.log('websocket connection closed', event);
	  };
	  
	  ws.onmessage = function(event) {
	      console.log('websocket message received', event);
	  };
	  
	  ws.onerror = function(event) {
	      console.log('an error occurred', event);
	  };
});

</script>
</html>