<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1" import = "com.adpost.domain.model.AppUser"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>	
 
	<jsp:include page="/WEB-INF/views/jspinc/header.jsp"></jsp:include>
    <jsp:include page="/WEB-INF/views/jspinc/topMenu.jsp"></jsp:include>
    <jsp:include page="/WEB-INF/views/jspinc/bottomMenu.jsp"></jsp:include>
	<div id="ad-dtl">
		<div class="ad-dtl-user profile-img">
			<img src="<%=request.getContextPath()%>/resources/images/account_pic.png" />
			<p>userDetails.getFirstName() userDetails.getLastName()</p>
			<p>user.getUserCreateDate()</p>
		</div>
		<div class="ad-dtl-title">
			<h3>advertDetails.getAdSubject()</h3>
			<div class="menu-list">
				<ul>
					<li id="adSubmittedDatetime">advertDetails.getPublishedDate()</li>
					<li id="adSubmittedDatetime">advertDetails.getAdLocation()</li>
				</ul>		
			</div>			
		</div>
		<hr />
		<div class="ad-dtl-body">
			<p>advertDetails.getAdBody()</p>
		</div>
		<hr />
		<div class="ad-dtl-pics">
			<img src="<%=request.getContextPath()%>/resources/images/ic_keyboard_hide_black_48dp.png" 
				height="50px" width ="50px" />
		</div>
		<div class="ad-dtl-contact">
			<p>advertDetails.getContactNo()</p>
			<p>advertDetails.getContactEmail()</p>
		</div>
		<hr />

	</div>
		
	    <jsp:include page="/WEB-INF/views/jspinc/footer.jsp"></jsp:include>
	


