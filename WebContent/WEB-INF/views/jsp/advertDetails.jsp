<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1" import = "com.adpost.domain.model.AppUser"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>	 
	
	<div id="advert-details" class="hidden dialog">
		<div class="profile-img">
			<img src="<%=request.getContextPath()%>/resources/images/account_pic.png" />
		</div>
		<div class="detail-header">
			<h3><span id="userName"></span></h3><br />
			<span id="adSubmittedDatetime"></span><br />
			<span id="adSubmittedLocation"></span>
		</div>
		<div class="clear"></div>
		<hr />
		<div class="detail-body">
			<h2><span id="adSubject"></span></h2><br />
			<span id="adBody"></span>
		</div>
		<hr />
		<div class="detail-pictures">
			<img src="<%=request.getContextPath()%>/resources/images/ic_keyboard_hide_black_48dp.png" 
				height="50px" width ="50px" />
		</div>
		<div class="detail-contact">
			<span id="adContactNo"></span><br />
			<span id="adContactEmail"></span>
		</div>
		<hr />
		<div class="detail-icons">
			
		</div>
	</div>
		
			


