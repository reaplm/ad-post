<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %> 
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

	<jsp:include page="/WEB-INF/views/jspinc/header.jsp"></jsp:include>
	<jsp:include page="/WEB-INF/views/jspinc/logo.jsp"></jsp:include>
	<div id="pg-login">
			<form id = "login-form" action = "/AdPost/login" method = "post" >
				<div class="form-row">
					<input class = "textbox username" type = "text" name = "email" 
								id = "email" placeholder = "email" value="${email}" />
				</div>
				<div class="form-row">
					<input class = "textbox password" type = "password" 
								name = "password" id = "password" placeholder = "password"/>
				</div>
				<div class="form-row">
					<button name = "action" id = "login-button" class="button form-submit"
							onclick="SubmitLogin()" >SUBMIT</button><br />
				</div>
				<div class="form-row align-center">
					<a href = "/AdPost/resetPassword">Forgot Password?</a>&nbsp;&nbsp;&nbsp;
					<a href = "/AdPost/register">Register</a>
				</div>
			</form>
	</div>
	<div class = "pg-submit-err">
			<p class = "error-msg">${errorMsg}</p>
	</div>
			<div class="clear"></div>