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


<body ng-app="ng-dashboard" class="container">


<div class="row">
	<div class="panel " ng-class="{'panel-success': success, 'panel-warning': unstable, 'panel-danger': failure}" ng-controller="BuildjobController">
  <div class="panel-heading" >{{fullDisplayName}}</div>
  
  <div class="panel-body">
  
   <div class="col-md-4 widget" ng-controller="AnalysisController">
	<div class="panel panel-default">
  		<div class="panel-heading widget-heading"><i class="fa fa-warning"></i> Analysis</div>
  		<div class="panel-body">
    		<div class="all-warnings">
    			{{numberOfWarnings}} 
    			<i class="fa fa-circle-o" ng-show="same"></i>
    			<i class="fa fa-thumbs-down" ng-show="more"></i>
    			<i class="fa fa-thumbs-up" ng-show="less"></i>
    		</div>
    		<div class="chart">
    			<canvas id="analysis-chart" width="auto" height="200px;"></canvas>
    		</div>
    		<div class="details">
    			<span class="label label-danger">{{numberOfHighPriorityWarnings}}</span>
    			<span class="label label-warning">{{numberOfNormalPriorityWarnings}}</span>
    			<span class="label label-info">{{numberOfLowPriorityWarnings}}</span>
    		</div>
 	 	</div>
	</div>
</div>
  
  <div class="col-md-4 widget" ng-controller="FindbugsController">
	<div class="panel panel-default">
  		<div class="panel-heading widget-heading"><i class="fa fa-bug"></i> Findbugs</div>
  		<div class="panel-body">
    		<div class="all-warnings">
    			{{numberOfWarnings}} 
    			<i class="fa fa-circle-o" ng-show="same"></i>
    			<i class="fa fa-thumbs-down" ng-show="more"></i>
    			<i class="fa fa-thumbs-up" ng-show="less"></i>
    		</div>
    		<div class="chart">
    			<canvas id="findbugs-chart" width="auto" height="200px;"></canvas>
    		</div>
    		<div class="details">
    			<span class="label label-danger">{{numberOfHighPriorityWarnings}}</span>
    			<span class="label label-warning">{{numberOfNormalPriorityWarnings}}</span>
    			<span class="label label-info">{{numberOfLowPriorityWarnings}}</span>
    		</div>
 	 	</div>
	</div>
  </div>
  
  <div class="col-md-4 widget" ng-controller="CheckstyleController">
	<div class="panel panel-default">
  		<div class="panel-heading widget-heading"><i class="fa fa-check-square-o"></i> Checkstyle</div>
  		<div class="panel-body">
    		<div class="all-warnings">
    			{{numberOfWarnings}} 
    			<i class="fa fa-circle-o" ng-show="same"></i>
    			<i class="fa fa-thumbs-down" ng-show="more"></i>
    			<i class="fa fa-thumbs-up" ng-show="less"></i>
    		</div>
    		<div class="chart">
    			<canvas id="checkstyle-chart" width="auto" height="200px;"></canvas>
    		</div>
    		<div class="details">
    			<span class="label label-danger">{{numberOfHighPriorityWarnings}}</span>
    			<span class="label label-warning">{{numberOfNormalPriorityWarnings}}</span>
    			<span class="label label-info">{{numberOfLowPriorityWarnings}}</span>
    		</div>
 	 	</div>
	</div>
  </div>
  
  <div class="col-md-4 widget" ng-controller="DryController">
	<div class="panel panel-default">
  		<div class="panel-heading widget-heading"><i class="fa fa-copy"></i> DRY</div>
  		<div class="panel-body">
    		<div class="all-warnings">
    			{{numberOfWarnings}} 
    			<i class="fa fa-circle-o" ng-show="same"></i>
    			<i class="fa fa-thumbs-down" ng-show="more"></i>
    			<i class="fa fa-thumbs-up" ng-show="less"></i>
    		</div>
    		<div class="chart">
    			<canvas id="dry-chart" width="auto" height="200px;"></canvas>
    		</div>
    		<div class="details">
    			<span class="label label-danger">{{numberOfHighPriorityWarnings}}</span>
    			<span class="label label-warning">{{numberOfNormalPriorityWarnings}}</span>
    			<span class="label label-info">{{numberOfLowPriorityWarnings}}</span>
    		</div>
 	 	</div>
	</div>
</div>

<div class="col-md-4 widget" ng-controller="TestreportController">
	<div class="panel panel-default">
  		<div class="panel-heading widget-heading"><i class="fa fa-stack-overflow"></i> Test Results</div>
  		<div class="panel-body">
    		<div class="all-warnings">
    			<span class="label " ng-class="{'label-success': good, 'panel-danger': failed}">
    				{{successcount}}/{{totalcount}} 
    			</span>
    			<i class="fa fa-circle-o" ng-show="same"></i>
    			<i class="fa fa-thumbs-down" ng-show="more"></i>
    			<i class="fa fa-thumbs-up" ng-show="less"></i>
    		</div>

    		<div class="details">
    			<span class="label label-danger">{{failcount}}</span>
    			<span class="label label-warning">{{skipcount}}</span>
    		</div>
 	 	</div>
	</div>
</div>

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