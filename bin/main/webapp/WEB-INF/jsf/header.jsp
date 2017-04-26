<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<jsp:useBean id="date" class="java.util.Date" />

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, shrink-to-fit=no, initial-scale=1">
<meta name="description" content="Point of sale manager">
<meta name="author" content="John Mungai">
<title>SqiLab POS</title>

<script src="https://code.jquery.com/jquery-3.1.1.js"
	integrity="sha256-16cdPddA6VdVInumRGo6IbivbERE8p7CQR3HzTBuELA="
	crossorigin="anonymous"></script>
<script src="http://code.jquery.com/ui/1.12.1/jquery-ui.min.js"
	integrity="sha256-VazP97ZCwtekAsvgPBSUwPFKdrwD3unUfSGVYrahUqU="
	crossorigin="anonymous"></script>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
	integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
	crossorigin="anonymous">

<!-- Optional theme -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css"
	integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp"
	crossorigin="anonymous">

<!-- Latest compiled and minified JavaScript -->
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"
	integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa"
	crossorigin="anonymous"></script>
<style type="text/css">
body, html {
	height: 100%;
}

.top-bar {
	backgound-color: #334;
}

nav.sidebar, .main {
	-webkit-transition: margin 200ms ease-out;
	-moz-transition: margin 200ms ease-out;
	-o-transition: margin 200ms ease-out;
	transition: margin 200ms ease-out;
}

.main {
	padding: 10px 10px 0 10px;
}

@media ( min-width : 765px) {
	.main {
		position: absolute;
		width: calc(100% - 40px);
		margin-left: 40px;
		float: right;
	}
	nav.sidebar:hover+.main {
		margin-left: 200px;
	}
	nav.sidebar.navbar.sidebar>.container .navbar-brand, .navbar>.container-fluid .navbar-brand
		{
		margin-left: 0px;
	}
	nav.sidebar .navbar-brand, nav.sidebar .navbar-header {
		text-align: center;
		width: 100%;
		margin-left: 0px;
	}
	nav.sidebar a {
		padding-right: 13px;
	}
	nav.sidebar .navbar-nav>li:first-child {
		border-top: 1px #e5e5e5 solid;
	}
	nav.sidebar .navbar-nav>li {
		border-bottom: 1px #e5e5e5 solid;
	}
	nav.sidebar .navbar-nav .open .dropdown-menu {
		position: static;
		float: none;
		width: auto;
		margin-top: 0;
		background-color: transparent;
		border: 0;
		-webkit-box-shadow: none;
		box-shadow: none;
	}
	nav.sidebar .navbar-collapse, nav.sidebar .container-fluid {
		padding: 0 0px 0 0px;
	}
	.navbar-inverse .navbar-nav .open .dropdown-menu>li>a {
		color: #777;
	}
	nav.sidebar {
		width: 200px;
		height: 100%;
		margin-left: -160px;
		float: left;
		margin-bottom: 0px;
		background-color: #334;
	}
	nav.sidebar li {
		width: 100%;
	}
	nav.sidebar:hover {
		margin-left: 0px;
	}
	.forAnimate {
		opacity: 0;
	}
}

@media ( min-width : 1330px) {
	.main {
		width: calc(100% - 200px);
		margin-left: 200px;
	}
	nav.sidebar {
		margin-left: 0px;
		float: left;
	}
	nav.sidebar .forAnimate {
		opacity: 1;
	}
}

nav.sidebar .navbar-nav .open .dropdown-menu>li>a:hover, nav.sidebar .navbar-nav .open .dropdown-menu>li>a:focus
	{
	color: #CCC;
	background-color: transparent;
}

nav:hover .forAnimate {
	opacity: 1;
}

section {
	padding-left: 15px;
}
</style>
</head>
<body>
	<nav class="navbar navbar-default sidebar" role="navigation">
	<div class="container-fluid">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle" data-toggle="collapse"
				data-target="#bs-sidebar-navbar-collapse-1">
				<span class="sr-only">POS server</span> <span class="icon-bar"></span>
				<span class="icon-bar"></span> <span class="icon-bar"></span>
			</button>
		</div>
		<div class="collapse navbar-collapse"
			id="bs-sidebar-navbar-collapse-1">
			<ul class="nav navbar-nav">
				<li class="active"><a href="/">Home<span
						style="font-size: 16px;"
						class="pull-right hidden-xs showopacity glyphicon glyphicon-home"></span></a></li>
				<li class="dropdown"><a href="#" class="dropdown-toggle"
					data-toggle="dropdown">Inventory <span class="caret"></span> <span
						style="font-size: 16px;"
						class="pull-right hidden-xs showopacity glyphicon glyphicon-user">
					</span></a>

					<ul class="dropdown-menu" role="menu">
						<li><a href="/category/view">Categories</a></li>
						<li><a href="/product/view">Products</a></li>
						<li><a href="/order/view">Sales</a></li>
						<li><a href="/supply/view">Product Supply</a></li>
						<li><a href="/suplier/view">Supliers</a></li>
					</ul></li>
				<li><a href="/transactions/view">Transactions<span
						style="font-size: 16px;"
						class="pull-right hidden-xs showopacity glyphicon glyphicon-th-list"></span></a></li>
				<li><a href="/employee/view">Employees<span
						style="font-size: 16px;"
						class="pull-right hidden-xs showopacity glyphicon glyphicon-th-list"></span></a></li>
				<li><a href="/customer/view">Customers<span
						style="font-size: 16px;"
						class="pull-right hidden-xs showopacity glyphicon glyphicon-th-list"></span></a></li>
				<li><a href="#">Reports<span style="font-size: 16px;"
						class="pull-right hidden-xs showopacity glyphicon glyphicon-th-list"></span></a></li>
				<li><a href="#">POS terminals<span style="font-size: 16px;"
						class="pull-right hidden-xs showopacity glyphicon glyphicon-th-list"></span></a></li>
				<li><a href="#">Settings<span style="font-size: 16px;"
						class="pull-right hidden-xs showopacity glyphicon glyphicon-th-list"></span></a></li>
			</ul>
		</div>
	</div>
	</nav>
	<section>
	<div class="container-fluid">