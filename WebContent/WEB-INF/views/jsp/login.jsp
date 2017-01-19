<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %> 
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<jsp:include page="/WEB-INF/views/jspinc/header.jsp"></jsp:include>
<jsp:include page="/WEB-INF/views/jspinc/logo.jsp"></jsp:include>
<div id="login">
			<form id = "login-form" action = "/AdPost/login" method = "post" >
				<table>
					<tr>
						<td><img src="resources/images/person_outline.png"/></td>
						<td colspan = "2">
							<input class = "login-textbox textbox" type = "text" name = "email" 
								id = "email" placeholder = "email" value="${email}" />
						</td>
					</tr>
					<tr>
						<td><img src="resources/images/lock_outline.png"/></td>
						<td colspan = "2">
							<input class = "login-textbox textbox" type = "password" 
								name = "password" id = "password" placeholder = "password"/>
						</td>
					</tr>
					<tr>
						<td></td>
						<td colspan = "2">
							<button name = "action" id = "login-button" class="button"
							onclick="SubmitLogin()" >SUBMIT</button>
						</td>	
					</tr>
					<tr>
						<td></td>
						<td>
							<a href = "/AdPost/resetPassword">Forgot Password?</a>
						</td>	
						<td>
							<a href = "/AdPost/register">Register</a>
						</td>	
					</tr>
				</table>
			</form>
			<div class = "form-bottom">
				<table>
					<tr>
						<td colspan = "2">
							<!-- <form:errors path="email" element="error-msg"/> -->
							<label class = "error-msg">${msg}</label>
							<label class = "success-msg">${successMsg}</label>
						</td>	
					</tr>
				</table>
			</div>
	</div>
			<div class="clear"></div>
</div>