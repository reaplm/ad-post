<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<div id="add-user" class="hidden">
	<form id = "add-user-form" method="post" action="/MovingMuscle/user/add">
		<table>
			<tr>
				<td>
					<label for = "email">Email: </label>
				</td>
				<td>
					<input type = "text" name = "email" id="email"/>
				</td>
			</tr>
			<tr>
				<td>
					<label for = "password">Password: </label>
				</td>
				<td>
					<input type = "text" name = "password" id = "password"/>
				</td>
			</tr>
			<tr>
				<td>
					<label for = "confirmPass">Repeat: </label>
				</td>
				<td>
					<input type = "text" name = "confirmPass" />
				</td>
			</tr>
			<tr>
				<td>
					<label for = "userStatus">Status: </label>
				</td>
				<td>
					<select name="userStatus">
						<option>Active</option>
						<option>Inactive</option>
					</select>
				</td>
			</tr>
			<tr>
				<td>
					<label for = "userType">User Type: </label>
				</td>
				<td>
					<select name="userType" id="userType" onchange="UserTypeChange()">
						<option value="customer">Customer</option>
						<option value="employee">Employee</option>
					</select>
				</td>
			</tr>
			<tr>
				<td>
					<label for = "firstName">First Name: </label>
				</td>
				<td>
					<input type = "text" name = "firstName" />
				</td>
			</tr>
			<tr>
				<td>
					<label for = "lastName">Last Name: </label>
				</td>
				<td>
					<input type = "text" name = "lastName" />
				</td>
			</tr>
			<tr>
				<td>
					<label for = "postAddress1">Address 1: </label>
				</td>
				<td>
					<input type = "text" name = "postAddress1" />
				</td>
			</tr>
			<tr>
				<td>
					<label for = "postAddress2">Address 2: </label>
				</td>
				<td>
					<input type = "text" name = "postAddress2" />
				</td>
			</tr>
			<tr>
				<td>
					<label for = "suburb">Suburb: </label>
				</td>
				<td>
					<input type = "text" name = "suburb" />
				</td>
			</tr>
			<tr>
				<td>
					<label for = "state">State: </label>
				</td>
				<td>
					<select name="state" >
							<option value="vic">VIC</option>
							<option value="act">ACT</option>
							<option value="nsw">NSW</option>
					</select>
				</td>
			</tr>
			<tr>
				<td>
					<label for = "postCode">Post Code: </label>
				</td>
				<td>
					<input type = "text" name = "postCode" />
				</td>
			</tr>
			<tr>
				<td>
					<label for = "officeNo">Office Contact: </label>
				</td>
				<td>
					<input type = "text" name = "officeNo" />
				</td>
			</tr>
			<tr>
				<td>
					<label for = "mobileNo">Mobile Contact: </label>
				</td>
				<td>
					<input type = "text" name = "mobileNo" />
				</td>
			</tr>
		</table>
		<table id="employee-details" class="hidden">
			<tr>
				<td>	
					<label for = "drivercheck">Driver: </label>
				</td>
				<td>
					<input type="checkbox" name = "drivercheck" id = "drivercheck" onchange = "DriverChecked()" />
				</td>
			</tr>
			<tr>
				<td>
					<label for = "licenseNo">License No: </label>
				</td>
				<td>
					<input type = "text" id = "licenseNo" name = "licenseNo" />
				</td>
			</tr>
			<tr>
				<td>
					<label for = "tcClass" >Truck Class: </label>
				</td>
				<td>
					<select name="tcClass" id="tcClass">
							<option value=100>100</option>
							<option value=150>150</option>
							<option value=200>200</option>
					</select>
				</td>
			</tr>
		</table>				
	</form>			
</div>

