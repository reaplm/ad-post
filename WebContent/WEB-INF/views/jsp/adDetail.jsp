<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1" import = "com.adpost.domain.model.AppUser, 
	com.adpost.domain.model.Advert, com.adpost.domain.model.AdvertDetail"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>	
 
	<jsp:include page="/WEB-INF/views/jspinc/header.jsp"></jsp:include>
    <jsp:include page="/WEB-INF/views/jspinc/topMenu.jsp"></jsp:include>
    <jsp:include page="/WEB-INF/views/jspinc/bottomMenu.jsp"></jsp:include>
    
	    <jsp:include page="/WEB-INF/views/jsp/advertDetails.jsp"></jsp:include>
	
	<div id="open-image" class="hidden dialog"></div>
	<jsp:include page="/WEB-INF/views/jspinc/rightSidebar.jsp"></jsp:include>
	   <jsp:include page="/WEB-INF/views/jspinc/footer.jsp"></jsp:include>