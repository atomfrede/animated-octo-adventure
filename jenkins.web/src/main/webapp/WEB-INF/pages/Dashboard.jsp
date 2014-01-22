<!DOCTYPE html>
<html>
<link rel='stylesheet' href='./webjars/bootstrap/3.0.3/css/bootstrap.min.css'>
<link rel="stylesheet" href="./webjars/bootstrap/3.0.3/css/bootstrap-theme.min.css">
<link rel="stylesheet" href="./webjars/font-awesome/4.0.3/css/font-awesome.min.css">
<link rel="stylesheet" href="./resources/css/dashboard.css">
<script src="./webjars/jquery/2.0.3/jquery.min.js"></script>
<script src="./webjars/bootstrap/3.0.3/js/bootstrap.min.js"></script>
<script src="./webjars/angularjs/1.2.9/angular.js"></script>
<script src="./webjars/angularjs/1.2.9/angular-resource.js"></script>
<script src="./resources/js/lib/chart.min.js"></script>
<script src="./app/app.js"></script>
<script src="./app/services/findbugs.js"></script>
<script src="./app/controllers/findbugs.js"></script>
<script src="./app/services/checkstyle.js"></script>
<script src="./app/controllers/checkstyle.js"></script>
<script src="./app/services/analysis.js"></script>
<script src="./app/controllers/analysis.js"></script>


<body ng-app="ng-dashboard" class="container">

<div class="row">
   <div class="col-md-4 widget" ng-controller="AnalysisController">
	<div class="panel panel-default">
  		<div class="panel-heading widget-heading"><i class="fa fa-bug"></i> Analysis</div>
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


</div>

</body>

</html>