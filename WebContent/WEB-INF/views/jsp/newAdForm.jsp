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
				<form:select id="new-ad-category" class="textbox txt-medium" name="menuId" path="menuId">
						<option value="-1"> </option>
					<c:forEach var="menu" items="${menuList}">
						<option value="${menu.getMenuId()}">${menu.getMenuName()}</option>
					</c:forEach>
				</form:select>	
				
				<form:select id="subMenuSelect" class="textbox txt-medium" name="subMenuId" path="subMenuId">
					<option value="-1"> </option>
				</form:select>
			</div>
			<div class="form-row">
			
				<p>LOCATION: </p>
				<form:input type="text" placeholder="location"  class="textbox txt-medium"
								id="adLocation" name="adLocation" path="adLocation"/>
						
			</div>
			<div class="form-row">
				<p>AD DETAILS: </p>
				<form:input type="text" placeholder="subject" class="textbox txt-medium"
								id="adSubject" name="adSubject" path="adSubject"/>
				<form:textarea rows="20" cols="100"	id="adBody" name="adBody" 
				class="txt-area" path="adBody" ></form:textarea>
						
			</div>
			<div class="form-row">
				<p>CONTACT: </p>
				<form:input type="text" placeholder="phone" class="textbox txt-medium"
								id="contactNo" name="contactNo" path="contactNo"/>
				<form:input type="text" placeholder="email" class="textbox txt-medium"
								name="contactEmail" id="contactEmail" path="contactEmail"/>
			</div>
			
			<div class="form-row">
				<p></p>

									<!-- 
							<form:input type="file" 
								id="adPictures" accept="image/*" name="files[]" multiple="multiple" 
								path="files"/>
								-->
						<form:input name="file" type="hidden" 
						role="uploadcare-uploader" path="files" 
						data-images-only="true" data-multiple="true"/> 
				
			</div>
			<br />
			<div class="form-row">
				<p></p>
							<button type="submit" class="button form-submit">Post</button>
							<p></p>
			</div>
			</form:form>	
		</div>		