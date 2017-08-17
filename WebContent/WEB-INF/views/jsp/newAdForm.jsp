<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="com.adpost.domain.model.FileUpload" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
	<div id="pg-add-advert" class="float-left content">
		<form:form id = "add-advert-form" method="post" action="/AdPost/advert/add"
			modelAttribute="fileUpload">
			<div class="form-row">
				<p>CATEGORY: </p>
				<form:select id="menuId" class="text" 
				name="menuId" path="menuId">
						<option value="-1"> </option>
					<c:forEach var="menu" items="${menuList}">
						<option value="${menu.getMenuId()}">${menu.getMenuName()}</option>
					</c:forEach>
				</form:select>	
				
				<form:select id="subMenuId" class="text" 
					name="subMenuId" path="subMenuId">
					<option value="-1"> </option>
				</form:select>
			</div>
			<div class="form-row">
			
				<p>LOCATION: </p>
				<form:input type="text" placeholder="location" class="text" 
							id="adLocation" name="adLocation" path="adLocation"/>
						
			</div>
			<div class="form-row">
				<p>AD DETAILS: </p>
				<form:input type="text" class="text" placeholder="subject"
								id="adSubject" name="adSubject" path="adSubject"/>
				<form:textarea rows="20" cols="100"	id="adBody" name="adBody"
				path="adBody" class="text" ></form:textarea>
						
			</div>
			<div class="form-row">
				<p>CONTACT: </p>
				<form:input type="text" placeholder="phone" class="text" 
								id="contactNo" name="contactNo" path="contactNo"/>
				<form:input type="text" placeholder="email" class="text" 
								name="contactEmail" id="contactEmail" path="contactEmail"/>
			</div>
			<br />
			<div class="form-row">
				<form:input name="uploadCareUrl" type="hidden" id="uploadcareWidget"
						role="uploadcare-uploader" data-images-only="true" 
						data-multiple="true" data-multiple-max="4" path="uploadCareUrl"/> 
						<button class="img-button button" type="button"
					onclick="SubmitAdvert(); return false;"></button>
				
			</div>
			<br />
			<!-- 
						<div class="form-row">
				<p></p>
				<button class="img-button" type="button"
					onclick="SubmitAdvert(); return false;"></button>
				<p></p>
			</div>
			-->
		</form:form>	
	</div>		