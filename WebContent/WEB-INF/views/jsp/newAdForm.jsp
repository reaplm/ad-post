<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

		<form:form id = "add-advert-form" method="post" action="/AdPost/advert/add" 
		modelAttribute="adDetails" enctype="multipart/form-data">
				<table>
					<tr>
						<td>
							<label>CATEGORY:</label>	
						</td>
					</tr>
					<tr>
						<td>
							<select id="new-ad-category" class="select" name="menu">
								<option value="-1"> </option>
							<c:forEach var="menu" items="${menuList}">
								<option value="${menu.getMenuId()}">${menu.getMenuName()}</option>
							</c:forEach>
							</select>	 
						</td>
					</tr>
					<tr>
						<td>
							<div id="subMenuSelect"></div>		
						</td>
					</tr>
					<tr>
						<td><hr /></td>
					</tr>
					<tr>
						<td>
							<label >LOCATION: </label>	
						</td>
					</tr>
					<tr>
						<td>
							<form:input type="text" placeholder="location"  
								name="adLocation" id="adLocation" path="adLocation"/>
						</td>
					</tr>
					<tr>
						<td><hr /></td>
					</tr>
					<tr>
						<td>
							<label>AD DETAILS: </label>	
						</td>
					</tr>
					<tr>
						<td>
							<form:input type="text" placeholder="subject" 
								name="adSubject" id="adSubject" path="adSubject"/>
						</td>
					</tr>
					<tr>
						<td>
							<form:textarea rows="10" cols="30" name="adBody" 
							id="adBody" path="adBody"></form:textarea>
						</td>
					</tr>
					<tr>
						<td><hr /></td>
					</tr>
					<tr>
						<td>
							CONTACT: 
						</td>
					</tr>
					<tr>
						<td>
							<form:input type="text" placeholder="phone" 
								name="contactNo" id="contactNo" path="contactNo"/>
						</td>
					</tr>
					<tr>
						<td>
							<form:input type="text" placeholder="email" 
								name="contactEmail" id="contactEmail" path="contactEmail"/>
						</td>
					</tr>
					<tr>
						<td><hr /></td>
					</tr>
					<tr>
						<td>
							
								<img src="<%=request.getContextPath()%>
								/resources/images/ic_add_a_photo_black_48dp.png" 
									height="20px" width ="20px" />
							
						</td>
					</tr>
					<tr>
					
						<td>
							<form:input type="file" name="pictures[]" 
								path="adPictures" id="adPictures" accept="image/*" multiple="multiple"/>
						</td>
					</tr>
					<tr>
						<td><hr /></td>
					</tr>
					<tr>
						<td>
							<button type="submit">Post</button>
						</td>
						
					</tr>
				</table>								
			</form:form>			