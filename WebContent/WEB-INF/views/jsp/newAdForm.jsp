<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="com.adpost.domain.model.FileUpload" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
	<div class="float-left content">
		<form:form id = "add-advert-form" method="post" action="/AdPost/advert/add" 
		enctype="multipart/form-data" modelAttribute="fileUpload">
				<table>
					<tr>
						<td colspan="2">
							CATEGORY:	
						</td>
					</tr>
					<tr>
						<td>
							<select id="new-ad-category" class="txt-medium" name="menuId">
								<option value="-1"> </option>
							<c:forEach var="menu" items="${menuList}">
								<option value="${menu.getMenuId()}">${menu.getMenuName()}</option>
							</c:forEach>
							</select>	 
						</td>
						<td>
							<select id="subMenuSelect" class="txt-medium" name="subMenuId">
								<option value="-1"> </option>
							</select>
						<!-- 
								<span id="subMenuSelect"></span>	
								-->	
						</td>
					</tr>
					<tr>
						<td colspan="2"><hr /></td>
					</tr>
					<tr >
						<td colspan="2">
							LOCATION: 
						</td>
					</tr>
					<tr >
						<td colspan="2">
							<input type="text" placeholder="location"  
								id="adLocation" class="txt-medium" name="adLocation"/>
						</td>
					</tr>
					<tr>
						<td colspan="2"><hr /></td>
					</tr>
					<tr>
						<td colspan="2">
							AD DETAILS: 
						</td>
					</tr>
					<tr>
						<td colspan="2">
							<input type="text" placeholder="subject" 
								id="adSubject" class="txt-medium" name="adSubject"/>
						</td>
					</tr>
					<tr>
						<td colspan="2">
							<textarea rows="30" cols="120" 
							id="adBody" name="adBody" ></textarea>
						</td>
					</tr>
					<tr >
						<td colspan="2"><hr /></td>
					</tr>
					<tr>
						<td colspan="2">
							CONTACT: 
						</td>
					</tr>
					<tr>
						<td>
							<input type="text" placeholder="phone" 
								id="contactNo" name="contactNo" class="txt-medium"/>
						</td>
						<td>
							<input type="text" placeholder="email" class="txt-medium"
								name="contactEmail" id="contactEmail" />
						</td>
					</tr>
					<tr>
						<td colspan="2"><hr /></td>
					</tr>
					<tr>
						<td>
							
								<img src="<%=request.getContextPath()%>
								/resources/images/ic_add_a_photo_black_48dp.png" 
									height="20px" width ="20px" />
							
						</td>
					</tr>
					<tr>
					
						<td colspan="2">
							<input type="file" 
								id="adPictures" accept="image/*" name="file" />
						</td>
					</tr>
					<tr>
						<td colspan="2"><hr /></td>
					</tr>
					<tr>
						<td colspan="2">
							<button type="submit">Post</button>
						</td>
						
					</tr>
				</table>								
			</form:form>	
		</div>		