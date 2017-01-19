<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %> 
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
			<link href="resources/css/style.css" rel = "stylesheet" type = "text/css" />
		<link href="resources/js/jquery-ui-1.10.3/themes/base/jquery.ui.all.css" rel = "stylesheet" type = "text/css" />
		<script type="text/javascript" src="resources/js/jquery-ui-1.10.3/jquery-1.9.1.js"></script>
				<script type="text/javascript" src="resources/js/jquery.validate.js"></script>
		<script type="text/javascript" src="resources/js/scripts.js"></script>
		<script type="text/javascript" src="resources/js/jquery-ui-1.10.3/ui/jquery-ui.js"></script>
		<script type="text/javascript" src="resources/js/jquery-ui-1.10.3/ui/jquery.ui.tabs.js"></script>
		<script type="text/javascript" src="resources/js/jquery-ui-1.10.3/ui/jquery.ui.core.js"></script>
		<script type="text/javascript" src="resources/js/jquery-ui-1.10.3/ui/jquery.ui.widget.js"></script>
		<script type="text/javascript" src="resources/js/jquery-ui-1.10.3/ui/jquery.ui.dialog.js"></script>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
			<title>${param.title}</title>
	</head>
	<body>
		<div id = "wrapper">
			<form id = "login-form" action = "/MovingMuscle/resetPassword" method = "post" >
					<table>
						<tr>
							<td>Email: </td>
							<td colspan = "2">
								<input class = "login-textbox" type = "text" name = "resetEmail" 
									id = "resetEmail" placeholder = "email" " />
							</td>
						</tr>
						<tr>
							<td>New Password: </td>
							<td colspan = "2">
								<input class = "login-textbox" type = "password" 
									name = "resetPass" id = "resetPass" placeholder = "password"/>
							</td>
						</tr>
						<tr>
							<td>Re-enter Password:</td>
							<td colspan = "2">
								<input class = "login-textbox" type = "password" 
									name = "resetPassRepeat" id = "resetPassRepeat" 
									placeholder = "re-enter password"/>
							</td>
						</tr>
						<tr>
							<td></td>
							<td colspan = "2">
								<button name = "action" id = "reset-button" class="button"
								onclick="SubmitReset()" >SUBMIT</button>
							</td>	
						</tr>
						
					</table>
				</form>
		</div>
	</body>
</html>
