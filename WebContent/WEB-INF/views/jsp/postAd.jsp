<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import = "java.util.List, java.util.Iterator,
    java.text.SimpleDateFormat, java.util.Date, com.adpost.domain.model.Menu,
    java.util.Date, com.adpost.domain.model.SubMenu"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

	<jsp:include page="/WEB-INF/views/jspinc/header.jsp"></jsp:include>
    <jsp:include page="/WEB-INF/views/jspinc/topMenu.jsp"></jsp:include>
    <jsp:include page="/WEB-INF/views/jspinc/bottomMenu.jsp"></jsp:include>
    <div id="post-ad" class="content">
	    <jsp:include page="/WEB-INF/views/jsp/newAdForm.jsp"></jsp:include>							
	 </div>
		<jsp:include page="/WEB-INF/views/jspinc/footer.jsp"></jsp:include>							
	