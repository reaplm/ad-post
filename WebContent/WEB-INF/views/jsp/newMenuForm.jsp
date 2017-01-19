<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

		<form id = "add-menu-form" method="post" action="/AdPost/menu/add">
			<div>
				Home Menu<input type="radio" name="menuType" value="category" 
					checked="checked" onclick="MenuRadioClick('category')">
					SideBar Menu<input type="radio" name="menuType" value="sidebar" 
						onclick="MenuRadioClick('sidebar')">	
					<hr /><br />
			</div>
			<div id="menus-menu-select" class="hidden, dialog-table">
				<table>
					<tr>
						<td>
							<label for = "parentMenu">Parent Menu: </label>
						</td>
						<td>
							<div id="menuSelect" class="capitalize"></div>	
						</td>
					</tr>
				</table>
			</div>
			<div id="menus-menu-input">
				<table>
					<tr>
						<td>
							<label for = "title">Title: </label>
						</td>
						<td>
							<input type = "text" name = "title" />
						</td>
					</tr>
					<tr>
						<td>
							<label for = "description">Description: </label>
						</td>
						<td>
							<input type = "text" name = "description" />
						</td>
					</tr>
					<tr>
						<td>
							<label for = "menuUrl">URL: </label>
						</td>
						<td>
							<input type = "text" name = "menuUrl" />
						</td>
					</tr>
					<tr>
						<td>
							<label for = "icon">Icon: </label>
						</td>
						<td>
							<input type = "text" name = "icon" />
						</td>
					</tr>
				</table>
			</div>
								
			</form>			
	