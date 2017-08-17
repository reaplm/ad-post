<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1" import = "com.adpost.domain.model.AppUser"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
	 
	<div id="view-user" class="hidden dialog" >
			<div id="view-user-top">
				<table>
					<tr>
						<td rowspan="4">
							<img src="<%=request.getContextPath()%>/resources/images/account_pic.png" 
							 height="100px" width ="100px" />
							 <br />
							 <span id="user-detail-name"></span>
						</td>
						<td rowspan="4"></td>
						<td>
							<img src="<%=request.getContextPath()%>/resources/images/ic_mail_outline_black_48dp.png" 
							 height="20px" width ="20px" title="email"/>
						</td>
						<td>
							<span id="user-detail-email"></span>
						</td>
					</tr>
					<tr>
						<td>
							<img src="<%=request.getContextPath()%>/resources/images/ic_call_black_48dp.png" 
							 height="20px" width ="20px" title="Mobile No"/>
						</td>
						<td>
							<span id="user-detail-mobile"></span>
						</td>
					</tr>
					<tr>
						<td>
							<img src="<%=request.getContextPath()%>/resources/images/ic_laptop_black_48dp.png" 
							 height="20px" width ="20px" title="Last Login"/>
						</td>
						<td>
							<span id="user-detail-last-login"></span>
						</td>
					</tr>
				</table>
				
			</div>
			<div id="edit-user" class="button">
				<img src="<%=request.getContextPath()%>/resources/images/ic_border_color_black_48dp.png" 
							 height="20px" width ="20px" title="edit" />
			</div>
			
			 <div class="clear"></div>
			<div id="view-user-bot" class="hidden">
				<form>
				<table>
					<tr>
						<td>
							<label for = "status">Status: </label>
						</td>
						<td>
							<select name="status" id="edit-user-status">
								<option>Active</option>
								<option>Inactive</option>
							</select>
						</td>
					</tr>
					<tr>
						<td>
							<label for = "firstName">First Name: </label>
						</td>
						<td>
							<input type = "text" name = "firstName" id="edit-user-fname"/>
						</td>
					</tr>
					<tr>
						<td>
							<label for = "lastName">Last Name: </label>
						</td>
						<td>
							<input type = "text" name = "lastName" id="edit-user-lname"/>
						</td>
					</tr>
					<tr>
						<td>
							<label for = "postAddress1">Address 1: </label>
						</td>
						<td>
							<input type = "text" name = "postAddress1" id="edit-user-postAddress1"/>
						</td>
					</tr>
					<tr>
						<td>
							<label for = "postAddress2">Address 2: </label>
						</td>
						<td>
							<input type = "text" name = "postAddress2" id="edit-user-postAddress2"/>
						</td>
					</tr>
					<tr>
						<td>
							<label for = "suburb">Suburb: </label>
						</td>
						<td>
							<input type = "text" name = "suburb" id="edit-user-suburb"/>
						</td>
					</tr>
					<tr>
						<td>
							<label for = "state">State: </label>
						</td>
						<td>
							<select name="state" id="edit-user-state">
									<option>VIC</option>
									<option>ACT</option>
									<option>NSW</option>
							</select>
						</td>
					</tr>
					<tr>
						<td>
							<label for = "postCode">Post Code: </label>
						</td>
						<td>
							<input type = "text" name = "postCode" id="edit-user-postcode"/>
						</td>
					</tr>
					<tr>
						<td>
							<label for = "officeNo">Office Contact: </label>
						</td>
						<td>
							<input type = "text" name = "officeNo" id="edit-user-office"/>
						</td>
					</tr>
					<tr>
						<td>
							<label for = "mobileNo">Mobile Contact: </label>
						</td>
						<td>
							<input type = "text" name = "mobileNo" id="edit-user-mobile"/>
						</td>
					</tr>
				</table>
				</form>
			</div>	
			</div>	


