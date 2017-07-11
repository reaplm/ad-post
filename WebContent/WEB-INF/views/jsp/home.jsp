<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
    
    <jsp:include page="/WEB-INF/views/jspinc/header.jsp"></jsp:include>
    <jsp:include page="/WEB-INF/views/jspinc/topMenu.jsp"></jsp:include>
    <jsp:include page="/WEB-INF/views/jspinc/logo.jsp"></jsp:include>
    <jsp:include page="/WEB-INF/views/jspinc/searchBar.jsp"></jsp:include>
	<div class="clear"></div>
	<div id="pg-home">
		
			<c:if test="${fn: length(categories) > 0}">
			<% int rowCount = 0; %>
			
				<c:forEach var="category" items="${categories}">
					
					<% if(rowCount%3 == 0) { %>
					<div class="clear"></div>
					<hr />
					<% }%>
					
					<div class="category">
						<div class="cat-icon">
							<a href="AdPost/${category.getMenuName()}"><img 
								src="<%=request.getContextPath()%>/resources/images/
								homeIcons/${category.getIcon()}"/>
							</a>
						</div>
						<div class="cat-title">
							<a href="">${category.getMenuName()}</a>
							<p>${category.getMenuDesc()}</p>
						</div>
						<div class="clear"></div>
						
						<c:if test="${fn: length(category.getSubMenu()) > 0}">
							<c:forEach var="submenu" items="${category.getSubMenu()}">
								<div class="cat-submenu">
									<a href="/AdPost/submenu/detail?id=${submenu.getSubMenuId()}">
										${submenu.getSubMenuName()}</a>
								</div>
							</c:forEach>
						</c:if>
						
					</div>
					<% rowCount++; %>
					
				</c:forEach>
				
			</c:if>
		
		
		
		
		<div class="clear"></div>
		<br />
		<div ><a href="/AdPost/adverts">BROWSE CATEGORIES</a></div>
	</div>

	<jsp:include page="/WEB-INF/views/jspinc/footer.jsp"></jsp:include>							
							
				
	