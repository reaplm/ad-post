<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    import="java.util.ArrayList, java.util.List, com.adpost.domain.model.Menu,
    	com.adpost.domain.model.SubMenu" 
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
        <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
	<% List<Menu> adminMenus = (ArrayList<Menu>)session.getAttribute("adminMenus"); %>
	<div class = "sidebar float-left"> 
	
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
	<div class= "sidebar-accordion block-menu" >
		<c:if test="${fn: length(adminMenus) > 0}">
			<c:forEach var="menu" items="${adminMenus}">
					<h3>${menu.getMenuName()}</h3>
					<ul class="menu">
						<c:if test="${fn: length(menu.getSubMenu()) > 0}">
							<c:forEach var="subMenu" items="${menu.subMenu}">
								<li><a href="${subMenu.getUrl()}">${subMenu.getSubMenuName()}</a></li>
							</c:forEach>
						</c:if>
					</ul>
			</c:forEach>
		</c:if>			
	</div>
</div>