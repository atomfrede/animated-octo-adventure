<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<link rel='stylesheet' href='./webjars/bootstrap/3.0.0/css/bootstrap.min.css'>
<link rel="stylesheet" href="./webjars/bootstrap/3.0.0/css/bootstrap-theme.min.css">
<link rel="stylesheet" href="./webjars/font-awesome/3.2.1/css/font-awesome.min.css">
<script src="./webjars/jquery/2.0.3/jquery.min.js"></script>
<script src="./webjars/bootstrap/3.0.0/js/bootstrap.min.js"></script>
<body>
	<div class="row">
  		<div class="col-md-8">
  			<div class="panel panel-success">
  				<div class="panel-heading"><h3>
  					<c:if test="${buildjob.building}">
  						<i class="icon-spinner icon-spin icon-large"></i> 
  					</c:if>
  					
  					 ${buildjob.fullDisplayName }</h3>
  				</div>
  				<div class="panel-body">
    				<h3><i class="icon-code"></i> No changes. </h3>
    				<p><i class="icon-play"></i> Build wurde zeitgesteuert gestartet. </p>
    				<p><i class="icon-time"></i> Dauer: 25 Minuten. </p>
 				 </div>
 				 <table class="table table-striped">
 				 	<thead>
 				 		<tr>
 				 			<th></th>
 				 			<th></th>
 				 			<th>All</th>
 				 			<th>New</th>
 				 			<th>Fixed</th>
 				 			<th>Trend</th>
 				 		</tr>
 				 	</thead>
 				 	<tbody>
						<tr class="success">
							<td><i class="icon-check"></i></td>
							<td>Checkstyle</td>
							<td>${checkstyle.numberOfWarnings }</td>
							<td>${checkstyle.numberOfNewWarnings }</td>
							<td>${checkstyle.numberOfFixedWarnings }</td>
							<td><i class="icon-circle-arrow-down"></i></td>
						<tr>
						<tr class="danger">
							<td><i class="icon-bug"></i></td>
							<td>Findbugs</td>
							<td>${findbugs.numberOfWarnings }</td>
							<td>${findbugs.numberOfNewWarnings }</td>
							<td>${findbugs.numberOfFixedWarnings }</td>
							<td><i class="icon-circle-arrow-up"></i></td>
						<tr>
					</tbody>
  				</table>
  			</div>
  		</div>
  		<div class="col-md-4">
  		
  		</div>
	</div>
</body>
</html>