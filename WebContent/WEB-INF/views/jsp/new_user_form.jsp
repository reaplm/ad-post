<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

		<form id = "add-user-form" method="post" action="/MovingMuscle/register">
				<table id = "user-details">
					<tr>
						<td>
							<label for = "email">Email: </label>
						</td>
						<td>
							<input type = "text" name = "email"/>
						</td>
					</tr>
					<tr>
						<td>
							<label for = "password">Password: </label>
						</td>
						<td>
							<input type = "text" name = "password" />
						</td>
					</tr>
					<tr>
						<td>
							<label for = "confirmPass">Password: </label>
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
							<label for = "role">Role: </label>
						</td>
						<td>
							<select name="role">
								<option>Administrator</option>
								<option>Customer</option>
								<option>Employee</option>
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
							<select name="state">
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
					<tr>
						<td>
							<label for = "faxNo">Fax No: </label>
						</td>
						<td>
							<input type = "text" name = "faxNo" />
						</td>
					</tr>
				</table>
				<table id="employee-details">
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
							<label for = "tcClass">Truck Class: </label>
						</td>
						<td>
							<select name="tcClass">
									<option>100</option>
									<option>150</option>
									<option>200</option>
							</select>
						</td>
					</tr>
				</table>				
			</form>			
	