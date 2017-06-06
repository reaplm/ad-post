<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
	<div id="add-menu" class="hidden dialog">
		<form id = "add-menu-form" method="post" action="/AdPost/menu/add">
			<div id="menus-menu-select" class="">
				<div class="form-row">
					<div class="form-col float-left">
						<p>Parent Menu:</p>
					</div>
					
						<select id="parentId" class="textbox txt-medium" name="parentId">
							<option value="-1"> </option>
						<c:forEach var="menu" items="${menuList}">
							<option value="${menu.getMenuId()}">${menu.getMenuName()}</option>
						</c:forEach>
						</select>
					
				</div>
				<div class="clear"></div>
				<div class="form-row">
					<div class="form-col float-left">
						<p>Menu Title: </p>
					</div>
						<input type = "text" name = "title" id = "title"
							class="textbox txt-medium"/>
				</div>
				<div class="clear"></div>
				<div class="form-row">
					<div class="form-col float-left">
						<p>Description: </p>
					</div>
						<input type = "text" id = "description" name = "description" 
							class="textbox txt-medium"/>
				</div>
				<div class="clear"></div>
				<div class="form-row">
					<div class="form-col float-left">
						<p>Icon: </p>
					</div>
						<input type = "text" id = "icon" name = "icon" 
							class="textbox txt-medium"/>
				</div>
				<div class="form-row">
					<input type="hidden" name = "menuType" value="category"/>
				</div>
				<div class="err-div">
					
				</div>
	
			</div>
								
			</form>			
	</div>