<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1" import = "com.adpost.domain.model.AppUser, 
	com.adpost.domain.model.Advert, com.adpost.domain.model.AdvertDetail"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>	
 
	<jsp:include page="/WEB-INF/views/jspinc/header.jsp"></jsp:include>
    <jsp:include page="/WEB-INF/views/jspinc/topMenu.jsp"></jsp:include>
    <jsp:include page="/WEB-INF/views/jspinc/bottomMenu.jsp"></jsp:include>
    
	<div id="ad-dtl" class="content float-left">
		<div class="ad-dtl-top-header">
			<div class= "user-pic-text float-right">
				<img src="<%=request.getContextPath()%>/resources/images/account_pic.png" />
				<div class="img-text">
					<p>Posted By ${advert.appUser.userDetail.getFirstName()} ${advert.appUser.userDetail.getLastName() }</p>
				</div>
				
			</div>
			<div class="clear"></div>
				<h1>${advert.advertDetail.getAdSubject()}</h1>
		</div >
		<div class="ad-dtl-bot-header">
				<h3>Published ${advert.getSubmittedDate()}, ${advert.getAdvertDetail().getAdLocation()}</h3>
		</div>
		<div class="clear"></div>
		<div class="ad-dtl-body">
			<div class="ad-dtl-body-txt">
				${advert.getAdvertDetail().getAdBody()}	
			</div>
			<div class="ad-dtl-contact">
				<h3>CONTACT DETAILS</h3>
				<p>Phone: ${advert.advertDetail.getContactNo()}&nbsp;&nbsp;&nbsp;Email: ${advert.advertDetail.getContactEmail()}</p>
			</div>
		</div>
		<div class="ad-dtl-pictures">
			<c:forEach var="picture" items="${adPictures}" varStatus="loop">
				<div class="ad-dtl-pictures-thb" >
					<img src="${picture.groupCdnUrl}nth/${loop.index}/" 
						width = 80px height = 80px 
						onClick="OpenImageDialog('${picture.groupCdnUrl}nth/${loop.index}/','${advert.advertDetail.getAdSubject()}');"
						class="button"/>
				</div>
			</c:forEach>
			
		</div>
		<div class="ad-dtl-comments">
		comments
		</div>
		

	</div>
	<div id="open-image" class="hidden dialog"></div>
	<jsp:include page="/WEB-INF/views/jspinc/rightSidebar.jsp"></jsp:include>
	   <jsp:include page="/WEB-INF/views/jspinc/footer.jsp"></jsp:include>
	


