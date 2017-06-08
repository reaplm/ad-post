<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import = "java.util.List, java.util.Iterator,
    java.text.SimpleDateFormat, java.util.Date, com.adpost.domain.model.Menu,
    java.util.Date, com.adpost.domain.model.SubMenu"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
	<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
	
	<jsp:include page="/WEB-INF/views/jspinc/header.jsp"></jsp:include>
    <jsp:include page="/WEB-INF/views/jspinc/topMenu.jsp"></jsp:include>
    <jsp:include page="/WEB-INF/views/jspinc/bottomMenu.jsp"></jsp:include>
    
    
    <div id="advert-list" class="content float-left">
	    <c:if test="${fn: length(advertList) > 0}">
					<c:forEach var="advert" items="${advertList}">
						<h2>
							<a href="/AdPost/advert/detail?id=${advert.getAdvertId()}" 
								class="advert-details-link">${advert.advertDetail.getAdSubject()}</a>
						</h2>
						 <div>
						 	<p>${advert.advertDetail.getAdBody()}</p>
					 </div>
				</c:forEach>
			</c:if>											
	</div>
	<jsp:include page="/WEB-INF/views/jspinc/rightSidebar.jsp"></jsp:include>
	<jsp:include page="/WEB-INF/views/jspinc/footer.jsp"></jsp:include>							
	