<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<link rel='stylesheet' href='./webjars/bootstrap/3.0.3/css/bootstrap.min.css'>
<link rel="stylesheet" href="./webjars/bootstrap/3.0.3/css/bootstrap-theme.min.css">
<link rel="stylesheet" href="./webjars/font-awesome/4.0.3/css/font-awesome.min.css">
<script src="./webjars/jquery/2.0.3/jquery.min.js"></script>
<script src="./webjars/bootstrap/3.0.3/js/bootstrap.min.js"></script>

<style>
	th {
		font-weight: bold;
		font-size: x-large;
		font-variant: normal;
		font-style: normal;
	}
	
	td {
		font-size: x-large;
		font-variant: normal;
		font-style: normal;
	}
</style>

<body class="container" >
	<div class="row">
  		<div class="col-md-12">
  			<div class="panel panel-success">
  				<div class="panel-heading">
  					<h3>
  						<c:if test="${buildjob.building}">
  							<i class="fa fa-spinner fa-spin fa-lg"></i> 
  						</c:if>
  					 ${buildjob.fullDisplayName }</h3>
  				</div>
  				<div class="panel-body">
    				<p><i class="fa fa-time"></i> Duration: ${buildjob.durationText} </p>
 				 </div>
 				 <table class="table table-striped">
 				 	<thead>
 				 		<tr>
 				 			<th></th>
 				 			<th>Current</th>
 				 			<th>Difference</th>
 				 			<th>Trend</th>
 				 		</tr>
 				 	</thead>
 				 	<tbody>
						<tr>
							<td>High Priority</td>
							<td>${analysisSummaryView.numberOfHighPriorityWarnings }</td>
							<td>${analysisSummaryView.diffHighPriorityWarnings }</td>
							<td>
								<c:if test="${analysisSummaryView.diffHighPriorityWarnings == 0}">
									<i class="fa fa-circle-o"></i>
								</c:if>
								<c:if test="${analysisSummaryView.diffHighPriorityWarnings > 0}">
									<i class="fa fa-thumbs-o-down"></i>
								</c:if>
								<c:if test="${analysisSummaryView.diffHighPriorityWarnings < 0}">
									<i class="fa fa-thumbs-o-up"></i>
								</c:if>
							</td>
						</tr>
						<tr>
							<td>Normal Priority</td>
							<td>${analysisSummaryView.numberOfNormalPriorityWarnings }</td>
							<td>${analysisSummaryView.diffNormalPriorityWarnings }</td>
							<td>
								<c:if test="${analysisSummaryView.diffNormalPriorityWarnings == 0}">
									<i class="fa fa-circle-o"></i>
								</c:if>
								<c:if test="${analysisSummaryView.diffNormalPriorityWarnings > 0}">
									<i class="fa fa-thumbs-o-down"></i>
								</c:if>
								<c:if test="${analysisSummaryView.diffNormalPriorityWarnings < 0}">
									<i class="fa fa-thumbs-o-up"></i>
								</c:if>
							</td>
						</tr>
						<tr>
							<td>Low Priority</td>
							<td>${analysisSummaryView.numberOfLowPriorityWarnings }</td>
							<td>${analysisSummaryView.diffLowPriorityWarnings }</td>
							<td>
								<c:if test="${analysisSummaryView.diffLowPriorityWarnings == 0}">
									<i class="fa fa-circle-o"></i>
								</c:if>
								<c:if test="${analysisSummaryView.diffLowPriorityWarnings > 0}">
									<i class="fa fa-thumbs-o-down"></i>
								</c:if>
								<c:if test="${analysisSummaryView.diffLowPriorityWarnings < 0}">
									<i class="fa fa-thumbs-o-up"></i>
								</c:if>
							</td>
						</tr>
					</tbody>
  				</table>
  			</div>
  			
  			<div class="panel panel-danger">
  				<div class="panel-heading">
  					<h3><i class="fa fa-bug fa-lg"></i> Findbugs</h3>
  				</div>
  				 <table class="table table-striped">
 				 	<thead>
 				 		<tr>
 				 			<th></th>
 				 			<th>Current</th>
 				 			<th>Difference</th>
 				 			<th>Trend</th>
 				 		</tr>
 				 	</thead>
 				 	<tbody>
						<tr>
							<td>High Priority</td>
							<td>${findbugsSummaryView.numberOfHighPriorityWarnings }</td>
							<td>${findbugsSummaryView.diffHighPriorityWarnings }</td>
							<td>
								<c:if test="${findbugsSummaryView.diffHighPriorityWarnings == 0}">
									<i class="fa fa-circle-o"></i>
								</c:if>
								<c:if test="${findbugsSummaryView.diffHighPriorityWarnings > 0}">
									<i class="fa fa-thumbs-o-down"></i>
								</c:if>
								<c:if test="${findbugsSummaryView.diffHighPriorityWarnings < 0}">
									<i class="fa fa-thumbs-o-up"></i>
								</c:if>
							</td>
						</tr>
						<tr>
							<td>Normal Priority</td>
							<td>${findbugsSummaryView.numberOfNormalPriorityWarnings }</td>
							<td>${findbugsSummaryView.diffNormalPriorityWarnings }</td>
							<td>
								<c:if test="${findbugsSummaryView.diffNormalPriorityWarnings == 0}">
									<i class="fa fa-circle-o"></i>
								</c:if>
								<c:if test="${findbugsSummaryView.diffNormalPriorityWarnings > 0}">
									<i class="fa fa-thumbs-o-down"></i>
								</c:if>
								<c:if test="${findbugsSummaryView.diffNormalPriorityWarnings < 0}">
									<i class="fa fa-thumbs-o-up"></i>
								</c:if>
							</td>
						</tr>
						<tr>
							<td>Low Priority</td>
							<td>${findbugsSummaryView.numberOfLowPriorityWarnings }</td>
							<td>${findbugsSummaryView.diffLowPriorityWarnings }</td>
							<td>
								<c:if test="${findbugsSummaryView.diffLowPriorityWarnings == 0}">
									<i class="fa fa-circle-o"></i>
								</c:if>
								<c:if test="${findbugsSummaryView.diffLowPriorityWarnings > 0}">
									<i class="fa fa-thumbs-o-down"></i>
								</c:if>
								<c:if test="${findbugsSummaryView.diffLowPriorityWarnings < 0}">
									<i class="fa fa-thumbs-o-up"></i>
								</c:if>
							</td>
						</tr>
					</tbody>
  				</table>
  			</div>
  			
  		<div id="carousel-example-generic" class="carousel slide bs-docs-carousel-example" data-interval="60000">
        <ol class="carousel-indicators">
          <li data-target="#carousel-example-generic" data-slide-to="0" class="active"></li>
          <li data-target="#carousel-example-generic" data-slide-to="1"></li>
          <li data-target="#carousel-example-generic" data-slide-to="2"></li>
        </ol>
        <div class="carousel-inner">
          <div class="item active">
           	<div class="panel panel-info">
  				<div class="panel-heading">
  					<h3><i class="fa fa-check-square-o fa-lg"></i> Checkstyle</h3>
  				</div>
  				 <table class="table table-striped">
 				 	<thead>
 				 		<tr>
 				 			<th></th>
 				 			<th>Current</th>
 				 			<th>Difference</th>
 				 			<th>Trend</th>
 				 		</tr>
 				 	</thead>
 				 	<tbody>
						<tr>
							<td>High Priority</td>
							<td>${checkstyleSummaryView.numberOfHighPriorityWarnings }</td>
							<td>${checkstyleSummaryView.diffHighPriorityWarnings }</td>
							<td>
								<c:if test="${checkstyleSummaryView.diffHighPriorityWarnings == 0}">
									<i class="fa fa-circle-o"></i>
								</c:if>
								<c:if test="${checkstyleSummaryView.diffHighPriorityWarnings > 0}">
									<i class="fa fa-thumbs-o-down"></i>
								</c:if>
								<c:if test="${checkstyleSummaryView.diffHighPriorityWarnings < 0}">
									<i class="fa fa-thumbs-o-up"></i>
								</c:if>
							</td>
						</tr>
						<tr>
							<td>Normal Priority</td>
							<td>${checkstyleSummaryView.numberOfNormalPriorityWarnings }</td>
							<td>${checkstyleSummaryView.diffNormalPriorityWarnings }</td>
							<td>
								<c:if test="${checkstyleSummaryView.diffNormalPriorityWarnings == 0}">
									<i class="fa fa-circle-o"></i>
								</c:if>
								<c:if test="${checkstyleSummaryView.diffNormalPriorityWarnings > 0}">
									<i class="fa fa-thumbs-o-down"></i>
								</c:if>
								<c:if test="${checkstyleSummaryView.diffNormalPriorityWarnings < 0}">
									<i class="fa fa-thumbs-o-up"></i>
								</c:if>
							</td>
						</tr>
						<tr>
							<td>Low Priority</td>
							<td>${checkstyleSummaryView.numberOfLowPriorityWarnings }</td>
							<td>${checkstyleSummaryView.diffLowPriorityWarnings }</td>
							<td>
								<c:if test="${checkstyleSummaryView.diffLowPriorityWarnings == 0}">
									<i class="fa fa-circle-o"></i>
								</c:if>
								<c:if test="${checkstyleSummaryView.diffLowPriorityWarnings > 0}">
									<i class="fa fa-thumbs-o-down"></i>
								</c:if>
								<c:if test="${checkstyleSummaryView.diffLowPriorityWarnings < 0}">
									<i class="fa fa-thumbs-o-up"></i>
								</c:if>
							</td>
						</tr>
					</tbody>
  				</table>
  			</div>
          </div>
          <div class="item">
           	 	<div class="panel panel-info">
  				<div class="panel-heading">
  					<h3><i class="fa fa-copy fa-lg"></i> DRY</h3>
  				</div>
  				 <table class="table table-striped">
 				 	<thead>
 				 		<tr>
 				 			<th></th>
 				 			<th>Current</th>
 				 			<th>Difference</th>
 				 			<th>Trend</th>
 				 		</tr>
 				 	</thead>
 				 	<tbody>
						<tr>
							<td>High Priority</td>
							<td>${drySummaryView.numberOfHighPriorityWarnings }</td>
							<td>${drySummaryView.diffHighPriorityWarnings }</td>
							<td>
								<c:if test="${drySummaryView.diffHighPriorityWarnings == 0}">
									<i class="fa fa-circle-o"></i>
								</c:if>
								<c:if test="${drySummaryView.diffHighPriorityWarnings > 0}">
									<i class="fa fa-thumbs-o-down"></i>
								</c:if>
								<c:if test="${drySummaryView.diffHighPriorityWarnings < 0}">
									<i class="fa fa-thumbs-o-up"></i>
								</c:if>
							</td>
						</tr>
						<tr>
							<td>Normal Priority</td>
							<td>${drySummaryView.numberOfNormalPriorityWarnings }</td>
							<td>${drySummaryView.diffNormalPriorityWarnings }</td>
							<td>
								<c:if test="${drySummaryView.diffNormalPriorityWarnings == 0}">
									<i class="fa fa-circle-o"></i>
								</c:if>
								<c:if test="${drySummaryView.diffNormalPriorityWarnings > 0}">
									<i class="fa fa-thumbs-o-down"></i>
								</c:if>
								<c:if test="${drySummaryView.diffNormalPriorityWarnings < 0}">
									<i class="fa fa-thumbs-o-up"></i>
								</c:if>
							</td>
						</tr>
						<tr>
							<td>Low Priority</td>
							<td>${drySummaryView.numberOfLowPriorityWarnings }</td>
							<td>${drySummaryView.diffLowPriorityWarnings }</td>
							<td>
								<c:if test="${drySummaryView.diffLowPriorityWarnings == 0}">
									<i class="fa fa-circle-o"></i>
								</c:if>
								<c:if test="${drySummaryView.diffLowPriorityWarnings > 0}">
									<i class="fa fa-thumbs-o-down"></i>
								</c:if>
								<c:if test="${drySummaryView.diffLowPriorityWarnings < 0}">
									<i class="fa fa-thumbs-o-up"></i>
								</c:if>
							</td>
						</tr>
					</tbody>
  				</table>
  			</div>
          </div>
        </div>
        <a class="left carousel-control" href="#carousel-example-generic" data-slide="prev">
          <span class="icon-prev"></span>
        </a>
        <a class="right carousel-control" href="#carousel-example-generic" data-slide="next">
          <span class="icon-next"></span>
        </a>
      </div>
  			
  		</div>
  		<div class="col-md-4">
  		
  		</div>
	</div>
</body>
</html>