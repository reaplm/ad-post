<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import = "java.util.List, java.util.Iterator,
    java.text.SimpleDateFormat, java.util.Date, com.adpost.domain.model.Menu,
    java.util.Date, com.adpost.domain.model.SubMenu"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
    
    <% boolean odd = true; %>
    
    <c:if test="${fn: length(menuList) > 0}">
					<c:forEach var="menu" items="${menuList}">
					<h2>${menu.getMenuName()} - ${menu.getMenuDesc()}</h2>
					<h3>Menu Type: ${menu.getMenuType()} Status: ${menu.getMenuStatus()} </h3>
					    <c:if test="${fn: length(menu.getSubMenu()) > 0}">
						<table>
							<tr style="backgroud-color: #fff">
								<th>Name</th>
								<th>Description</th>
								<th>Status</th>
							</tr>
							<c:forEach var="subMenu" items="${menu.subMenu}">
								<%  if(odd){ %>
								<tr style="background-color: #fb9d9d">
								<% } 
								else{ %>
								<tr style="background-color: #fff">
								<% } %>	
									<td><a href="/AdPost/submenu/detail?id=${subMenu.getSubMenuId()}"
									 	class="menu-details-link">
									 	${subMenu.getSubMenuName()}</a></td>					
									<td>${subMenu.getSubMenuDesc()}</td>
									<td>${subMenu.getMenuStatus()}</td>
								</tr>
								<%  odd = !odd; %>
							</c:forEach>
						</table>
						</c:if>
					</c:forEach>
				</c:if>							
							