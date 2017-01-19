<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %> 
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<jsp:include page="/WEB-INF/views/jspinc/header.jsp"></jsp:include>	
<jsp:include page="/WEB-INF/views/jspinc/logo.jsp"></jsp:include>		
				<form id = "register-form" method="post" action="/AdPost/register">
					<table>
						<tr>
							<td>
								<input type = "text" name = "firstName" id = "firstName" 
								placeholder="First Name"/>
							</td>
							<td>
								<input type = "text" name = "lastName" id = "lastName" 
								placeholder = "Last Name"/>
							</td>
						</tr>
						<tr>
							<td colspan="2">
								<input type = "text" id = "email" name = "email" 
								placeholder = "Email"  />
							</td>
						</tr>
						<tr>
							<td>
								<input type = "password" name = "password" id = "password"  
								path = "password" placeholder = "Password"/>
							</td>
							<td>
								<input type = "password" name = "confirmPass" id="confirmPass" 
									placeholder = "Re-enter password"/>
							</td>
						</tr>
						<tr>
							<td colspan="2">
								<button name="register" id = "register-button" class="button"
								onclick="SubmitRegistration()">SUBMIT</button>
							</td>
						</tr>
					</table>				
				</form>	
				<div class = "form-bottom">
					<table>
						<tr>
							<td colspan="2">
								<!-- <form:errors path="email" element="error-msg"/> -->
								<label class = "error-msg">${errorMsg}</label>
							</td>
						</tr>
					</table>
				</div>		
		<div class = "clear"></div> 
