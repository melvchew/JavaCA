<%@page import="model.UsersDTO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator"
	prefix="decorator"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>LAPS</title>
<!-- Tell the browser to be responsive to screen width -->
<meta
	content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no"
	name="viewport">
<!-- Bootstrap 3.3.6 -->
<link rel="stylesheet" href="../bootstrap/css/bootstrap.min.css">
<!-- Font Awesome -->
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.5.0/css/font-awesome.min.css">
<!-- Ionicons -->
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/ionicons/2.0.1/css/ionicons.min.css">
<!-- Theme style -->
<link rel="stylesheet" href="../dist/css/AdminLTE.min.css">

<link rel="stylesheet" href="../dist/css/skins/skin-blue.min.css">

<!-- bootstrap datepicker -->
<link rel="stylesheet" href="../plugins/datepicker/datepicker3.css">

<!--[if lt IE 9]>
  <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
  <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
  <![endif]-->
</head>
<%
	session = request.getSession(false);
	UsersDTO lguser = (UsersDTO) session.getAttribute("loggedInUser");
%>
<body class="hold-transition skin-blue sidebar-mini">
	<div class="wrapper">

		<!-- Main Header -->
		<header class="main-header">

			<!-- Logo -->
			<a href="#" class="logo"> <!-- mini logo for sidebar mini 50x50 pixels -->
				<span class="logo-mini"><b>L</b>APS</span> <!-- logo for regular state and mobile devices -->
				<span class="logo-lg"><b>ISS</b>LAPS</span>
			</a>

			<!-- Header Navbar -->
			<nav class="navbar navbar-static-top" role="navigation">
				<!-- Sidebar toggle button-->
				<a href="#" class="sidebar-toggle" data-toggle="offcanvas"
					role="button"> <span class="sr-only">Toggle navigation</span>
				</a>
				<!-- Navbar Right Menu -->
				<div class="navbar-custom-menu">
					<ul class="nav navbar-nav">

						<!-- User Account Menu -->
						<li class="dropdown user user-menu">
							<!-- Menu Toggle Button --> <a href="#" class="dropdown-toggle"
							data-toggle="dropdown"> <!-- The user image in the navbar-->
								<span class="hidden-xs"><%= lguser.getName() %></span>
						</a>
							<ul class="dropdown-menu">
								<!-- The user image in the menu -->

									<p><%= lguser.getName() %> - <%= lguser.getPosition().getJobTitle() %></p></li>
								<li class="user-footer">
									<div class="pull-left">
										<a href="/Laps/employee/viewleavehistory" class="btn btn-default btn-flat">View Leave
											History</a>
									</div>
									<div class="pull-right">
										<a href="/Laps/Login" class="btn btn-default btn-flat">Sign out</a>
									</div>
								</li>
							</ul>
						</li>
					</ul>
				</div>
			</nav>
		</header>
		<!-- Left side column. contains the logo and sidebar -->
		<aside class="main-sidebar">

			<section class="sidebar">



				<!-- Sidebar Menu -->
				<ul class="sidebar-menu">
					<li class="header">NAVIGATION</li>
					<!-- Optionally, you can add icons to the links -->
					<%
					if (lguser.getPosition().getAccessLevel().getAccessLevelName().equals("Admin")) {
					%>
					<li class="active"><a href="/Laps/admin/home"><i class="fa fa-dashboard"></i>
					<% } else {%>
					<li class="active"><a href="/Laps/employee/home"><i class="fa fa-dashboard"></i>
					<% } %>
							<span>Dashboard</span></a></li>

					<%
						System.out.println(lguser.getPosition().getAccessLevel().getAccessLevelName());
						System.out.println(lguser.getPosition().getAccessLevel().getAccessLevelName().equals("Manager"));
						if (lguser.getPosition().getAccessLevel().getAccessLevelName().equals("Manager")) {
					%>



					<li class="treeview"><a href="#"><i
							class="fa fa-calendar-check-o"></i> <span>Manager
								Functions</span> <span class="pull-right-container"> <i
								class="fa fa-angle-left pull-right"></i>
						</span> </a>
						<ul class="treeview-menu">
							<li><a href="/Laps/manager/viewapplications"><i
									class="fa fa-circle-o"></i>Pending Leave Application</a></li>
							<li><a href="/Laps/manager/ViewUsersHistoryByManager"><i class="fa fa-circle-o"></i>View
									Employee History</a></li>
						</ul></li>

					<%
						}
					%>
					<li class="treeview"><a href="#"><i
							class="fa fa-calendar-check-o"></i> <span>Leave</span> <span
							class="pull-right-container"> <i
								class="fa fa-angle-left pull-right"></i>
						</span> </a>
						<ul class="treeview-menu">
							<li><a href="/Laps/employee/submitleave"><i
									class="fa fa-circle-o"></i>Submit Leave Application</a></li>
						</ul></li>
					<li><a href="/Laps/employee/viewleavehistory"><i
							class="fa fa-hourglass-end"></i> <span>Leave History</span></a></li>
					<li><a href="/Laps/Login"><i class="fa fa-reply"></i> <span>Sign
								Out</span></a></li>
				</ul>
				<!-- /.sidebar-menu -->
			</section>
			<!-- /.sidebar -->
		</aside>

		<!-- Content Wrapper. Contains page content -->
		<div class="content-wrapper">
			<!-- Content Header (Page header) -->
			<section class="content-header">
				<h1>
					LAPS
				</h1>
			</section>

			<!-- Main content -->
			<section class="content">

				<!-- Your Page Content Here -->
				<decorator:body />

			</section>
			<!-- /.content -->
		</div>
		<!-- /.content-wrapper -->

		<!-- Main Footer -->
		<footer class="main-footer">
			<!-- To the right -->
			<div class="pull-right hidden-xs">Laps</div>
			<!-- Default to the left -->
			<strong>Copyright &copy; 2017 <a href="#">Company</a>.
			</strong> All rights reserved.
		</footer>

		<!-- ./wrapper -->

		<!-- REQUIRED JS SCRIPTS -->

		<!-- jQuery 2.2.3 -->
		<script src="../plugins/jQuery/jquery-2.2.3.min.js"></script>
		<!-- Bootstrap 3.3.6 -->
		<script src="../bootstrap/js/bootstrap.min.js"></script>
		<!-- AdminLTE App -->
		<script src="../dist/js/app.min.js"></script>
		<!-- bootstrap datepicker -->
		<script src="../plugins/datepicker/bootstrap-datepicker.js"></script>
		<!-- Page script -->
		<script>
			$(function() {

				//Date picker
				$('#datepicker').datepicker({
					autoclose : true
				});

			});
		</script>
</body>
</html>
