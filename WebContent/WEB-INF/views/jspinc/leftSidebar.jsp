<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
	<div class = "sidebar" > 
	
		<div class="user-pic-text">
	
		<%	if((Boolean)session.getAttribute("loggedIn")){
						%>
			<img src="<%=request.getContextPath()%>/resources/images/account_pic.png" 
							 height="100px" width ="100px" />		 
			<div>
				<p>Welcome, <a href="login">${username}</a></p>
			</div>
		<%} %>
		</div>
	<div class="clear"></div>
		<div class= "sidebar-accordion" >
			<h3>Home</h3>
			<ul class= "nav">
				<li><a href="#">Dashboard</a></li>
				<li><a href="#">MyProfile</a></li>
				<li><a href="#">Messages</a></li>
			</ul>
			<h3>Manage</h3>
			<ul>
				<li><a href="/AdPost/admin/users">Users</a></li>
				<li><a href="#">Adverts</a></li>
				<li><a href="/AdPost/menus">menus</a></li>
				<li><a href="/AdPost/admin/permissions">Permissions</a></li>
			</ul>
			<h3>Site Administration</h3>
			<ul >
				<li><a href=" ">Alerts</a></li>
				<li><a href="#">Settings</a></li>
				<li><a href="#">Look and Feel</a></li>
			</ul>
			<h3>Site Activity</h3>
			<ul >
				<li id = "side-bar-products"><a href=" ">Recently Viewed</a></li>
				<li><a href="#">My Ads</a></li>
				<li><a href="#">Favorites</a></li>
			</ul>
			<h3>Reports</h3>
			<ul >
				<li id = "side-bar-products"><a href=" ">Users</a></li>
				<li><a href="#">Roles</a></li>
				<li id = "side-bar-products"><a href="#">Activities</a></li>
				<li id = "side-bar-products"><a href="#">Adverts</a></li>
			</ul>
		</div>
</div>