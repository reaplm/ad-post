<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1" import = "com.adpost.domain.model.Menu" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>	
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

	<div id="dg-menu-dtl" class="dialog hidden">
		<div class="details">
			<div class="dtl-img">
				<img src=""
						/>
				<h3><span id=""></span></h3>
			</div>
			<div class="dtl-info">
				<h2><span id="dtlId"></span><span id="dtlName"></span><span id="dtlDesc"></span></h2>
				<h3>Menu Type: <span id="dtlType"></span> Status: <span id="dtlStatus"></span></h3>
			</div>
			<div class="clear"></div>
			<div>
				<a class="dtl-link" href="">Edit</a>&nbsp;&nbsp;
				<a class="dtl-link" href="">Delete</a>
			</div>
		</div>
		
		<div class="edit-menu hidden">
		<hr />
			<form id = "edit-menu-form" method="post" action="/AdPost/menu/edit">
				<div class="form-row">
					<div class="left-col"></div>
					<div class="right-col">
						<input type="radio" name="status" value="active" 
						id="menuActive" />Active
						<input type="radio" name="status" value="inactive" 
							checked="checked" id="menuInactive"  />Inactive
					</div>
				</div>
				<div class="form-row">
						<div class="left-col">
							<label>menu Title:</label>
						</div>
						<div class="right-col">
							<input type = "text" id = "editTitle" name = "editTitle" 
							class="textbox txt-medium"/>
						</div>
				</div>
				<div class="clear"></div>
				<div class="form-row">
						<div class="left-col">
							<label >Menu Desc:</label>
						</div>
						<div class="right-col">
							<input type = "text" id = "editDescription" name = "editDescription" 
								class="textbox txt-medium" />
						</div>
				</div>
				<div class="clear"></div>
				<div class="form-row">
						<div class="left-col">
							<label>Icon:</label>
						</div>
						<div class="right-col">
							<input type = "text" id = "editIcon" name = "editIcon" 
								class="textbox txt-medium" />
						</div>
				</div>
				<div class="clear"></div>
				<div class="form-row">
						<div class="left-col">
							<label>Url:</label>
						</div>
						<div class="right-col">
							<input type = "text" id = "editUrl" name = "editUrl" 
								class="textbox txt-medium"/>
						</div>
				</div>
				<input type="hidden" id="hiddenId" name="menuId"/>
				<input type="hidden" id="menuType" name="menuType"/>
			</form>
		</div>
	</div>
	