<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import = "java.util.List, java.util.Iterator,
    java.text.SimpleDateFormat, java.util.Date, com.adpost.domain.model.Menu,
    java.util.Date, com.adpost.domain.model.SubMenu"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    
    <jsp:include page="/WEB-INF/views/jspinc/adminHeader.jsp"></jsp:include>
	<jsp:include page="/WEB-INF/views/jspinc/leftSidebar.jsp"></jsp:include>
	
	<div id="menus" class="content float-left">
				<div class="content-menu" class="menu-list">
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
						<li><a href="/AdPost/menus/sidebar?menuType=sidebar">Sidebar</a></li>
					</ul>
				</div>
		</div>
	<div class="clear"></div>
	<div class = "error-msg menu-list hidden"></div>
	<div id="add-menu" class="hidden dialog" >
		<jsp:include page="/WEB-INF/views/jsp/newMenuForm.jsp"></jsp:include>
	</div>
	<div id="edit-menu" class="hidden dialog" >
		<jsp:include page="/WEB-INF/views/jsp/editMenu.jsp"></jsp:include>
	</div>
	<jsp:include page="/WEB-INF/views/jspinc/footer.jsp"></jsp:include>							
							
				
	