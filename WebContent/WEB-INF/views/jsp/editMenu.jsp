<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

		<form:form id = "edit-menu-form" method="post" 
			action="/AdPost/menu/edit" modelAttribute="menu">
			<div>
				<table>
					<tr>
						<td>
							<form:label for = "menuType" path="menuType">menuType: </form:label>
						</td>
						<td>
							<form:select id="menuType" path="menuType">
								<option value="SIDEBAR">SideBar</option>
								<option value="UNCLASSIFIED">Unclassified</option>
								<option value="CATEGORY">Category</option>
							</form:select>
						</td>
					</tr>
					<tr>
						<td>
							<form:label for = "menuStatus" path="menuStatus">menuStatus: </form:label>
						</td>
						<td>
							<form:select id="menuStatus" path="menuStatus">
								<option value="INACTIVE">Inactive</option>
								<option value="ACTIVE">Active</option>
							</form:select>
						</td>
					</tr>
					<tr>
						<td>
							<form:label for = "title" path="menuName">Title: </form:label>
						</td>
						<td>
							<form:input type = "text" name = "title" 
								id="menuName" path="menuName"/>
						</td>
					</tr>
					<tr>
						<td>
							<form:label for = "description" path="menuDesc">Description: </form:label>
						</td>
						<td>
							<form:input type = "text" name = "description" 
								id="menuDesc" path="menuDesc"/>
						</td>
					</tr>
					<tr>
						<td>
							<form:label for = "menuUrl" path="url">URL: </form:label>
						</td>
						<td>
							<form:input type = "text" name = "menuUrl" 
								id="url" path="url"/>
						</td>
					</tr>
					<tr>
						<td>
							<form:label for = "icon" path="icon">Icon: </form:label>
						</td>
						<td>
							<form:input type = "text" name = "icon" 
								id="icon" path="icon"/>
						</td>
					</tr>
					<form:input type = "hidden"	id="menuId" path="menuId"/>
				</table>
			</div>				
	</form:form>
		
	