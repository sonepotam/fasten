<%@ page import="java.util.List" %>
<%@ page import="org.springframework.data.domain.Page" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ taglib prefix="c"      uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form"   uri="http://www.springframework.org/tags/form" %>

<%@ page session="false" %>
<%@ page language="java" session="false"%>




<html>
<head>
<meta content="text/html; charset=utf-8" http-equiv="content-type">



<!-- jQuery -->
<script src="http://code.jquery.com/jquery-1.10.2.js"></script>


<script src="https://code.jquery.com/jquery-migrate-1.2.1.min.js"></script>


<link href="http://code.jquery.com/ui/1.10.4/themes/ui-lightness/jquery-ui.css" rel="stylesheet">
<script src="http://code.jquery.com/ui/1.10.4/jquery-ui.js"></script>



<!-- Bootstrap -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7" crossorigin="anonymous">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap-theme.min.css" integrity="sha384-fLW2N01lMqjakBkx3l/M9EahuwpSfeNvV63J5ezn3uZzapT0u7EYsXMjQV+0En5r" crossorigin="anonymous">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js" integrity="sha384-0mSbJDEHialfmuBBQP6A4Qrprq5OVfW37PRR3j5ELqxss1yVqOtnepnHVP9aJ7xS" crossorigin="anonymous"></script>


<!-- DataTable -->
<script src="https://cdn.datatables.net/1.10.11/js/jquery.dataTables.min.js"></script>
<link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.10.11/css/jquery.dataTables.min.css">

<!-- Noty -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-noty/2.3.7/packaged/jquery.noty.packaged.min.js"></script>
<link rel="stylesheet" type="text/css" href="https://cdnjs.cloudflare.com/ajax/libs/animate.css/3.4.0/animate.min.css">

<!-- hwind -->
<script src="<c:url value="/resources/js/controller.js" />"></script>


</head>
<body>


<div class="navbar navbar-inverse navbar-fixed-top">
	<div class="container">
		<div class="navbar-header navbar-brand">Fasten TEST Application</div>
		<div class="navbar-collapse collapse">
			<ul class="nav navbar-nav navbar-right">
				<li>
					<a class="navbar-brand navbar-right" href="http://www.github.com/sonepotam">GitHub</a>
				</li>
			</ul>
		</div>
	</div>
</div>


<h2>Fasten TEST Application</h2>
<hr>

<div class="jumbotron">
	<div class="container">
		<div class="shadow">
			<div class="panel panel-primary">
				<div class="panel-heading">
			       <h3 class="panel-title">Отправка сообщений Websocket API</h3>
				</div>
				<div class="panel-body">
                <!-- panel -->
                	<div class="view-box">
						<!-- окно для вывода -->
						<div class="form-group">
							<label for="sequence_id" class="control-label col-sm-2">sequence ID</label>
							<div class="col-sm-10">
								<input class="form-control" id="sequence_id" name="sequence_id" placeholder="ID сообщения">
							</div>
						</div>

						<br/>
						<div class="form-group">
							<label for="email" class="control-label col-sm-2">E-mail</label>
							<div class="col-sm-10">
								<input class="form-control" id="email" name="email" placeholder="E-mail">
							</div>
						</div>
						<br/>

						<div class="form-group">
							<label for="password" class="control-label col-sm-2">Password</label>
							<div class="col-sm-10">
								<input class="form-control" id="password" name="password" placeholder="Пароль">
							</div>
						</div>
						<br/>
						<div class="form-group">
						<label id="status">Статус соединения</label>
						</div>


					</div> <!-- view box -->
            	</div> <!-- panel-body -->

				<div class="panel-footer">

					<nav class="navbar navbar-default">
						<div class="container-fluid">
							<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">

								<form class="navbar-form navbar-left" >
									<div class="form-group">
										<a id="start"  class="btn btn-success">Открыть сессию</a>
										<a id="send"   class="btn btn-success">Отправить сообщение</a>
										<a id="stop"   class="btn btn-success">Закрыть сессию</a>
									</div>
								</form>
							</div><!-- /.navbar-collapse -->
						</div>
					</nav>
				</div>
			</div> <!-- panel -->
		</div>
	</div>
</div>




</body>



</html>
