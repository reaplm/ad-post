<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
	<div id="add-menu" class="hidden dg-menu">
		<form id = "add-menu-form" method="post" action="/AdPost/menu/add">
				<div class="form-row">
					<div class="left-col">
						<label>Parent Menu:</label>
					</div>
					<div class="right-col">
						<select id="parentId" class="textbox txt-medium" name="parentId">
							<option value="-1"> </option>
						<c:forEach var="menu" items="${menuList}">
							<option value="${menu.getMenuId()}">${menu.getMenuName()}</option>
						</c:forEach>
						</select>
					</div>
				</div>
				<div class="form-row">
					<div class="left-col">
						<label>Menu Title: </label>
					</div>
					<div class="right-col">
						<input type = "text" name = "title" id = "title"
							class="textbox txt-medium"/>
					</div>
				</div>
				<div class="form-row">
					<div class="left-col">
						<label>Description: </label>
					</div>
					<div class="right-col">
						<input type = "text" id = "description" name = "description" 
							class="textbox txt-medium"/>
					</div>
				</div>
				<div class="form-row">
					<div class="left-col">
						<label>Icon: </label>
					</div>
					<div class="right-col">
						<input type = "text" id = "icon" name = "icon" 
							class="textbox txt-medium"/>
					</div>
				</div>
				<div class="form-row">
					<input type="hidden" name = "menuType" value="category"/>
				</div>
				<div class="err-div">
					
				</div>

								
			</form>			
	</div>