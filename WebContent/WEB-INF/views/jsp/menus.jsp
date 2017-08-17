<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import = "java.util.List, java.util.Iterator,
    java.text.SimpleDateFormat, java.util.Date, com.adpost.domain.model.Menu,
    java.util.Date, com.adpost.domain.model.SubMenu"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    
<jsp:include page="/WEB-INF/views/jspinc/header.jsp"></jsp:include>
<jsp:include page="/WEB-INF/views/jspinc/adminMenu.jsp"></jsp:include>	<jsp:include page="/WEB-INF/views/jspinc/leftSidebar.jsp"></jsp:include>
	
	<div id="menus" class="content float-left">
				<div class="content-menu" class="list-menu">
					<h1>Menus</h1>
					<ul class="menu-list">
						<li class="button">
							<img src="<%=request.getContextPath()%>
								/resources/images/add_circle.png" id="new-menu" />
						</li>
					</ul>
				</div>
		
				<div class="clear"></div>
				<div id="menu-tabs" class="menu-list">
					<ul>
						<li><a href="/AdPost/menus/home?menuType=category">Home</a></li>
						<li><a href="/AdPost/menus/home?menuType=admin">Admin</a></li>
					</ul>
				</div>
				<p></p>
			<jsp:include page="/WEB-INF/views/jspinc/actionMenu.jsp"></jsp:include>					
			
		</div>
	<div class="clear"></div>
	<div class = "error-msg menu-list hidden"></div>
		<jsp:include page="/WEB-INF/views/jsp/addMenuForm.jsp"></jsp:include>
		<jsp:include page="/WEB-INF/views/jsp/menuDetails.jsp"></jsp:include>
	<jsp:include page="/WEB-INF/views/jspinc/footer.jsp"></jsp:include>							
							
				
	