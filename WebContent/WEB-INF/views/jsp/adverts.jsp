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
    <jsp:include page="/WEB-INF/views/jspinc/logo.jsp"></jsp:include>
    
    
    <div id="pg-adverts" class="content float-left">
	    <c:if test="${fn: length(advertList) > 0}">
	    	<hr />
				<c:forEach var="advert" items="${advertList}">
					
					<div class="advert-list" >
						<p>
							<a href="/AdPost/adverts?id=${advert.getAdvertId()}" 
								class="advert-details-link">${advert.advertDetail.getAdSubject()}</a>
						</p>
						 <div>
						 	<p>${advert.advertDetail.getAdBody()}</p>
					 	</div>
					 </div>
					 <hr />
				</c:forEach>
				
			</c:if>											
	</div>
	<jsp:include page="/WEB-INF/views/jspinc/rightSidebar.jsp"></jsp:include>
	<jsp:include page="/WEB-INF/views/jspinc/footer.jsp"></jsp:include>							
	