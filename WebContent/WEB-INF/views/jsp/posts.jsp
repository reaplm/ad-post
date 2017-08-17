<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import = "java.util.List, java.util.ArrayList, java.util.Iterator,
    java.text.SimpleDateFormat, java.util.Date, com.adpost.domain.model.Menu,
    java.util.Date, com.adpost.domain.model.SubMenu"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
    
	<jsp:include page="/WEB-INF/views/jspinc/header.jsp"></jsp:include>
	<jsp:include page="/WEB-INF/views/jspinc/adminMenu.jsp"></jsp:include>
	<jsp:include page="/WEB-INF/views/jspinc/leftSidebar.jsp"></jsp:include>
	
	<div id="posts" class="content float-left">
					
    	<c:if test="${fn: length(advertList) > 0}">
		<% boolean odd = true; %>
			<div id="content-menu" class="menu-list">
					<h1>Posts</h1>
			</div>
			<table>
				<tr style="backgroud-color: #fff">
						<th>Subject</th>
						<th>Posted By</th>
						<th>Status</th>
						<th>Date Posted</th>
						<th></th>
					</tr>
				<c:forEach var="advert" items="${advertList}">
					<%  if(odd){ %>
					<tr style="background-color: #fb9d9d">
					<% } 
					else{ %>
					<tr style="background-color: #fff">
					<% } %>	
						<td><a href="/AdPost/admin/advert/detail?id=${advert.getAdvertId()}"
						 	class="admin-advert-dtl">
						 	${advert.advertDetail.getAdSubject()}</a></td>					
						<td>${advert.appUser.userDetail.getFirstName()} 
							${advert.appUser.userDetail.getLastName()}</td>
						<td>${advert.getAdvertStatus()}</td>
						<td>${advert.getSubmittedDate()}</td>
						<td><input type="checkbox" name="advertStatus" 
								 <c:if test="${advert.getAdvertStatus() == 'APPROVED'}">
								 	checked="checked"
								 </c:if>
								 />
							</td>
					</tr>
					<%  odd = !odd; %>
				</c:forEach>
			</table>
			</c:if>		
			<p></p>
			<jsp:include page="/WEB-INF/views/jspinc/actionMenu.jsp"></jsp:include>					
			
		</div>	
				
			<jsp:include page="/WEB-INF/views/jsp/menuDetails.jsp"></jsp:include>

		<jsp:include page="/WEB-INF/views/jspinc/footer.jsp"></jsp:include>							
	