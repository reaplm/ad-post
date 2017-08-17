<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import = "java.util.List, java.util.Iterator,
    java.text.SimpleDateFormat, java.util.Date, com.adpost.domain.model.AppUser"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
    
    <jsp:include page="/WEB-INF/views/jspinc/header.jsp"></jsp:include>
<jsp:include page="/WEB-INF/views/jspinc/adminMenu.jsp"></jsp:include>
	<jsp:include page="/WEB-INF/views/jspinc/leftSidebar.jsp"></jsp:include>
	
	<div id="users" class="content">
		<c:if test="${fn: length(userList) > 0}">
				<% boolean odd = true; %>
				<div id="content-menu" class="menu-list">
					<h1>Users</h1>
				</div>
				
				<table>
					<tr style="backgroud-color: #fff">
						<th>Name</th>
						<th>Email</th>
						<th>Last Login Date</th>
						<th>User Status</th>
					</tr>
					<c:forEach var="user" items="${userList}">
						<%  if(odd){ %>
						<tr style="background-color: #fb9d9d">
						<% } 
						else{ %>
						<tr style="background-color: #fff">
						<% } %>	
							<td><a href="/AdPost/admin/user/detail?id=${user.getUserId()}"
							 	class="lnk-user-details">
							 	${user.userDetail.getFirstName()} ${user.userDetail.getLastName()}</a></td>					
							<td>${user.getEmail()}</td>
							<td>${user.getLastLoginDate()}</td>
							<td>${user.getUserStatus()}</td>
						</tr>
						<%  odd = !odd; %>
					</c:forEach>
				</table>
		</c:if>	
		<div class="clear"></div>
		<p></p>
		<jsp:include page="/WEB-INF/views/jspinc/actionMenu.jsp"></jsp:include>					
			
	</div>
	<div class = "error-msg" class="menu-list" class="hidden"></div>
	
		
		<jsp:include page="/WEB-INF/views/jsp/userDetails.jsp"></jsp:include>

	<jsp:include page="/WEB-INF/views/jsp/addUser.jsp"></jsp:include>
	<jsp:include page="/WEB-INF/views/jspinc/footer.jsp"></jsp:include>							
							
				
	