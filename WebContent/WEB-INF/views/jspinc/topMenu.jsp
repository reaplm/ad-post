<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<div id="top-header" class="header">
				<ul id="top-menu" class="menu-list float-right-menu link-list" >
						<sec:authorize access="hasRole('ROLE_ANONYMOUS')">						
							<li><a href="/AdPost/login">Sign In</a></li>
							<li>|</li>
							<li><a href="/AdPost/register">Register</a></li>
						</sec:authorize>
						<sec:authorize access="hasAnyRole('ADMIN','USER')">	
							<li><a href="/AdPost/adverts">Post Ad</a></li>
							<li>|</li>					
							<li><a href="/AdPost/admin">Admin</a></li>
							<li>|</li>					
							<li><a href="/AdPost/advert/newpost">Post Ad</a></li>
						</sec:authorize>
				</ul>								
			</div>
			
		
