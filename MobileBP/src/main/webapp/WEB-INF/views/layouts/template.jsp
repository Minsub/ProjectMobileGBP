<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">

<title>Sales GBP</title>

<!-- Latest compiled and minified CSS -->
<link href="<c:url value='/css/template-docs.css'/>" rel="stylesheet">
<link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap.min.css">
<!-- Optional theme -->
<link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap-theme.min.css">

<!-- <link href="<c:url value='/css/bootstrap-responsive.css'/>" rel="stylesheet">  -->
<!-- <link rel="stylesheet" href="http://code.jquery.com/mobile/1.3.1/jquery.mobile-1.3.1.min.css" />  -->

<!-- Latest compiled and minified JavaScript -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.8.3/jquery.min.js"></script>
<script src="//netdna.bootstrapcdn.com/bootstrap/3.1.1/js/bootstrap.min.js"></script>


<!-- <script src="http://code.jquery.com/jquery-1.9.1.min.js"></script>  -->
<script src="http://code.jquery.com/mobile/1.3.1/jquery.mobile-1.3.1.min.js"></script>

<script language="javascript">
$(function(){
    $("#mainBody").bind("swipeleft", function(){
    	eventLeftSwipe();
    });
    $("#mainBody").bind("swiperight", function(){
    	eventRightSwipe();
    });
}); 

function showDiv() {
	
}
//window.onload=showDiv
</script>	
	

</head>

<body onload="showDiv()">

<div id="wrap">
	<header class="navbar navbar-inverse bs-docs-nav" role="navigation">
		<div class="container">
			<div class="navbar-header">
				<button class="navbar-toggle" type="button" data-toggle="collapse" data-target=".bs-navbar-collapse">
					<span class="sr-only">Toggle navigation</span> 
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
				</button>
				<a href="/cntr/gbp" class="navbar-brand">Home</a>
			</div>
			<nav class="collapse navbar-collapse bs-navbar-collapse" role="navigation">
				<ul class="nav navbar-nav">
					<li><a href="/cntr/gbp">Sales GBP</a></li>
					<li><a href="/cntr/gbp">Accuracy</a></li>
					<li><a href="/cntr/gbp">KPI</a></li>
				</ul>
				<ul class="nav navbar-nav navbar-right">
					<li class="dropdown"><a href="#" class="dropdown-toggle" data-toggle="dropdown">Ji Minsub (0123)</a>
						<ul class="dropdown-menu">
							<li><a href="#">Change Info.</a></li>
							<li><a href="/cntr/logout">Logout</a></li>
						</ul>
					</li>
				</ul>
			</nav>
			
		</div>
	</header>
	
	<div id="mainBody" class="container bs-docs-container">
		<div class="row">
			<div class="col-xs-10" role="main">
				<div id="body">
					<tiles:insertAttribute name="body" />
				</div>
			</div>
		</div>
	</div>

</div>



	
<!--
<div class="well">
		<p>Hyundai Ubiquitous & Information technology</p>
       <p>This is a private system operated for Hyundai U&I company business. All corporate policies and standards must be strictly followed. 
	<br>2014 Hyundai U&I Co.,LTD All Rights Reserved.</p>


</div>
 -->
</body>
</html>