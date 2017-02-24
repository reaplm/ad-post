<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="com.adpost.domain.model.FileUpload" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
	<div id="add-menu" class="float-left content">
		<form:form id = "add-advert-form" method="post" action="/AdPost/advert/add" 
		enctype="multipart/form-data" modelAttribute="fileUpload">
			<div class="form-row">
				<p>CATEGORY: </p>
				<select id="new-ad-category" class="textbox txt-medium" name="menuId">
						<option value="-1"> </option>
					<c:forEach var="menu" items="${menuList}">
						<option value="${menu.getMenuId()}">${menu.getMenuName()}</option>
					</c:forEach>
				</select>	
				
				<select id="subMenuSelect" class="textbox txt-medium" name="subMenuId">
					<option value="-1"> </option>
				</select>
			</div>
			<div class="form-row">
			
				<p>LOCATION: </p>
				<input type="text" placeholder="location"  class="textbox txt-medium"
								id="adLocation" name="adLocation"/>
						
			</div>
			<div class="form-row">
				<p>AD DETAILS: </p>
				<input type="text" placeholder="subject" class="textbox txt-medium"
								id="adSubject" class="txt-medium" name="adSubject"/>
				<textarea rows="20" cols="100" 
							id="adBody" name="adBody" class="txt-area" ></textarea>
						
			</div>
			<div class="form-row">
				<p>CONTACT: </p>
				<input type="text" placeholder="phone" class="textbox txt-medium"
								id="contactNo" name="contactNo" />
				<input type="text" placeholder="email" class="textbox txt-medium"
								name="contactEmail" id="contactEmail" />
			</div>
			
			<div class="form-row">
				<p></p>
				<img src="<%=request.getContextPath()%>
								/resources/images/ic_add_a_photo_black_48dp.png" 
									height="20px" width ="20px" />
							<input type="file" 
								id="adPictures" accept="image/*" name="file" />
				
			</div>
			<div class="form-row">
				<p></p>
							<button type="submit" class="button form-submit">Post</button>
							<p></p>
			</div>
			</form:form>	
		</div>		