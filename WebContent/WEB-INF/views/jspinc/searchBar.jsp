<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<div class="clear"></div>
<div class="header search-bar ">
	<form action="/search" method="get">
		<input type="text" name="search" class="textbox"/>
		<button id="search-but" class="button"><img src="<%=request.getContextPath()%>
						/resources/images/ic_search_white_48dp_pink.png" />
		</button>
	</form>
</div>