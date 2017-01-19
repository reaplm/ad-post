<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<link href="<%=request.getContextPath()%>/resources/css/style.css" rel = "stylesheet" type = "text/css" />
		<link href="<%=request.getContextPath()%>/resources/js/jquery-ui-1.10.3/themes/base/jquery.ui.all.css" rel = "stylesheet" type = "text/css" />
		<script type="text/javascript" src="<%=request.getContextPath()%>/resources/js/jquery-ui-1.10.3/jquery-1.9.1.js"></script>
				<script type="text/javascript" src="<%=request.getContextPath()%>/resources/js/jquery.validate.js"></script>
		<script type="text/javascript" src="<%=request.getContextPath()%>/resources/js/scripts.js"></script>
		<script type="text/javascript" src="<%=request.getContextPath()%>/resources/js/jquery-ui-1.10.3/ui/jquery-ui.js"></script>
		<script type="text/javascript" src="<%=request.getContextPath()%>/resources/js/jquery-ui-1.10.3/ui/jquery.ui.tabs.js"></script>
		<script type="text/javascript" src="<%=request.getContextPath()%>/resources/js/jquery-ui-1.10.3/ui/jquery.ui.core.js"></script>
		<script type="text/javascript" src="<%=request.getContextPath()%>/resources/js/jquery-ui-1.10.3/ui/jquery.ui.widget.js"></script>
		<script type="text/javascript" src="<%=request.getContextPath()%>/resources/js/jquery-ui-1.10.3/ui/jquery.ui.dialog.js"></script>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>${param.title}</title>
	</head>
	<body>
	
		<div id = "admin-header">
		 <div id="admin-menu">
			<div class="logo">
					<p>adPost</p>
			</div>
			<div class="menu-list nav">
				<ul id="top-menu">						
					<sec:authorize access="hasRole('ADMIN')">
						<li><a href="/AdPost/admin">Admin</a></li>
						<li>|</li>
					</sec:authorize>
					<sec:authorize access="hasAnyRole('ADMIN','USER')">
						<li><a href="/AdPost/settings">Settings</a></li>
						<li>|</li>
						<li><a href="/AdPost/logout">Log Out</a></li>
					</sec:authorize>
				</ul>				
			</div>
			</div>
		</div>
			<div class="clear"></div>	
