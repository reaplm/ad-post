<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1" import = "com.adpost.domain.model.AppUser, 
	com.adpost.domain.model.Advert, com.adpost.domain.model.AdvertDetail"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>	
    
	<div id="ad-dtl" class="content float-left">
		<div class="ad-dtl-top-header">
			<div class= "user-pic-text float-right">
				<img src="<%=request.getContextPath()%>/resources/images/account_pic.png" />
				<div class="img-text">
					<h3>Posted By ${advert.appUser.userDetail.getFirstName()} ${advert.appUser.userDetail.getLastName() }</h3>
				</div>
				
			</div>
			<div class="clear"></div>
				<h1>${advert.advertDetail.getAdSubject()}</h1>
		</div >
		<div class="ad-dtl-bot-header">
				<p>Published ${advert.getSubmittedDate()}, ${advert.getAdvertDetail().getAdLocation()}</p>
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
				<div class="img-slide fade">
					<img src="${picture.groupCdnUrl}nth/${loop.index}/" 
						onClick="SlideNext();"
						class="button" style="max-width: 100%; height: auto;"/>
				</div>
			</c:forEach>
			
		</div>
		

	</div>

	


