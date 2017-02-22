<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %> 
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<jsp:include page="/WEB-INF/views/jspinc/header.jsp"></jsp:include>	
<jsp:include page="/WEB-INF/views/jspinc/logo.jsp"></jsp:include>	
	<div id="pg-register">	
		<form id = "register-form" method="post" action="/AdPost/register">
			<div class="form-row">
				<div class="form-col float-left">
					<input class = "textbox txt-small float-left" type = "text" 
						name = "firstName" id = "firstName" placeholder="First Name"/>
				</div>
				<div  class="form-col float-left">
					<input class = "textbox txt-small" type = "text" 
						name = "lastName" id = "lastName" placeholder="Last Name"/>
				</div>
			</div>
			<div class="form-row">
				<input class = "textbox txt-large" type = "text" 
					name = "email" id = "email" placeholder="Email"/>
			</div>
			<div class="form-row">
				<div class="form-col float-left">
					<input class = "textbox txt-small float-left" type = "text" 
						name = "password" id = "password" placeholder="Password"/>
				</div>
				<div class="form-col float-left">
					<input class = "textbox txt-small float-left" type = "text" 
						name = "confirmPass" id = "confirmPass" placeholder="Re-enter password"/>
				</div>
			</div>
			<div class="form-row align-center">
				<button name="register" id = "register-button" class="form-submit button"
						onclick="SubmitRegistration()">SUBMIT</button>
			</div>		
		</form>	
	</div>
	<div class = "pg-submit-err">
			<p class = "error-msg">${errorMsg}</p>
	</div>
	<div class = "clear"></div> 
