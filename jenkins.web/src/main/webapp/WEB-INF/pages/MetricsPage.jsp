<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<link rel='stylesheet' href='./webjars/bootstrap/3.0.3/css/bootstrap.min.css'>
<link rel="stylesheet" href="./webjars/bootstrap/3.0.3/css/bootstrap-theme.min.css">
<link rel="stylesheet" href="./webjars/font-awesome/4.0.3/css/font-awesome.min.css">
<script src="./webjars/jquery/2.0.3/jquery.min.js"></script>
<script src="./webjars/bootstrap/3.0.3/js/bootstrap.min.js"></script>
<body>
	<div class="row">
  		<div class="col-md-8">
  			<div class="panel panel-success">
  				<div class="panel-heading"><h3>
  					<c:if test="${buildjob.building}">
  						<i class="fa fa-spinner fa-spin fa-lg"></i> 
  					</c:if>
  					
  					 ${buildjob.fullDisplayName }</h3>
  				</div>
  				<div class="panel-body">
    				<h3><i class="fa fa-code"></i> No changes. </h3>
    				<p><i class="fa fa-play"></i> Build wurde zeitgesteuert gestartet. </p>
    				<p><i class="fa fa-time"></i> Dauer: 25 Minuten. </p>
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
							<td></td>
						</tr>
						<tr>
							<td>Normal Priority</td>
							<td>${analysisSummaryView.numberOfNormalPriorityWarnings }</td>
							<td>${analysisSummaryView.diffNormalPriorityWarnings }</td>
							<td></td>
						</tr>
						<tr>
							<td>Low Priority</td>
							<td>${analysisSummaryView.numberOfLowPriorityWarnings }</td>
							<td>${analysisSummaryView.diffLowPriorityWarnings }</td>
							<td></td>
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
							<td></td>
						</tr>
						<tr>
							<td>Normal Priority</td>
							<td>${findbugsSummaryView.numberOfNormalPriorityWarnings }</td>
							<td>${findbugsSummaryView.diffNormalPriorityWarnings }</td>
							<td></td>
						</tr>
						<tr>
							<td>Low Priority</td>
							<td>${findbugsSummaryView.numberOfLowPriorityWarnings }</td>
							<td>${findbugsSummaryView.diffLowPriorityWarnings }</td>
							<td></td>
						</tr>
					</tbody>
  				</table>
  			</div>
  			
  		<div id="carousel-example-generic" class="carousel slide bs-docs-carousel-example">
        <ol class="carousel-indicators">
          <li data-target="#carousel-example-generic" data-slide-to="0" class="active"></li>
          <li data-target="#carousel-example-generic" data-slide-to="1"></li>
          <li data-target="#carousel-example-generic" data-slide-to="2"></li>
        </ol>
        <div class="carousel-inner">
          <div class="item active">
            <img src="http://lorempixel.com/400/200/" data-src="holder.js/900x500/auto/#777:#555/text:First slide" alt="First slide">
          </div>
          <div class="item">
            <img src="http://lorempixel.com/400/200/" data-src="holder.js/900x500/auto/#666:#444/text:Second slide" alt="Second slide">
          </div>
          <div class="item">
            <img src="http://lorempixel.com/400/200/" data-src="holder.js/900x500/auto/#555:#333/text:Third slide" alt="Third slide">
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