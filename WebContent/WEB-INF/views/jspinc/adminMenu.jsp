<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
		<div id = "admin-header">
			<div class="logo">
			</div>
			<div id="admin-menu" class="">
				<ul>						
					<sec:authorize access="hasRole('ADMIN')">
						<li>
							<a href="/AdPost/home">
								<img src="<%=request.getContextPath()%>
									/resources/images/homeIcons/home_yellow.png" 
									width = "20px" alt = "home" title = "home"/>
							</a>
						</li>
					</sec:authorize>
					<sec:authorize access="hasAnyRole('ADMIN','USER')">
						<li>
							<a href="/AdPost/settings">
								<img src="<%=request.getContextPath()%>
									/resources/images/homeIcons/settings_yellow.png" 
									width = "20px" alt = "settings" title = "settings"/>
							</a>
						</li>
						<li>
							<a href="/AdPost/logout">
								<img src="<%=request.getContextPath()%>
									/resources/images/homeIcons/logout_yellow.png" 
									width = "20px" alt = "logout" title = "logout"/>
							</a>
						</li>
					</sec:authorize>
				</ul>				
			</div>
		</div>
			<div class="clear"></div>	