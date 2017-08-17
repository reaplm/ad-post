<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
	<div id="edit-menu" class="hidden" >
		<form:form id = "edit-menu-form" method="post" 
			action="/AdPost/menu/edit" modelAttribute="menu">
			<div>
				<table>
					<tr>
						<td>
							<form:label for = "edit-menu-menuType" path="menuType">menuType: </form:label>
						</td>
						<td>
							<form:select id="edit-menu-menuType" path="menuType">
								<option value="SIDEBAR">SideBar</option>
								<option value="UNCLASSIFIED">Unclassified</option>
								<option value="CATEGORY">Category</option>
							</form:select>
						</td>
					</tr>
					<tr>
						<td>
							<form:label for = "edit-menu-menuStatus" path="menuStatus">menuStatus: </form:label>
						</td>
						<td>
							<form:select id="edit-menu-menuStatus" path="menuStatus">
								<option value="INACTIVE">Inactive</option>
								<option value="ACTIVE">Active</option>
							</form:select>
						</td>
					</tr>
					<tr>
						<td>
							<form:label for = "edit-menu-title" path="menuName">Title: </form:label>
						</td>
						<td>
							<form:input type = "text" name = "title" 
								id="edit-menu-title" path="menuName"/>
						</td>
					</tr>
					<tr>
						<td>
							<form:label for = "edit-menu-description" path="menuDesc">Description: </form:label>
						</td>
						<td>
							<form:input type = "text" name = "edit-menu-description" 
								id="edit-menu-description" path="menuDesc"/>
						</td>
					</tr>
					<tr>
						<td>
							<form:label for = "edit-menu-url" path="url">URL: </form:label>
						</td>
						<td>
							<form:input type = "text" name = "edit-menu-url" 
								id="edit-menu-url" path="url"/>
						</td>
					</tr>
					<tr>
						<td>
							<form:label for = "edit-menu-icon" path="icon">Icon: </form:label>
						</td>
						<td>
							<form:input type = "text" name = "edit-menu-icon" 
								id="edit-menu-icon" path="icon"/>
						</td>
					</tr>
					<form:input type = "hidden"	id="edit-menu-menuId" path="menuId"/>
				</table>
			</div>				
	</form:form>
</div>	
	