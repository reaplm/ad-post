
function SaveActiveTab(){
	var activeTabIndex = $("#menu-tabs").tabs("option", "active");
	var dataStore = window.sessionStorage;
	try{
		dataStore.setItem("activeTabIndex", activeTabIndex);
	}catch(e){alert("Can't store index: \n"+e);}
		
}
function OpenActiveTab(){
	var dataStore = window.sessionStorage;
	var	oldIndex = dataStore.getItem("activeTabIndex");

	$("#menu-tabs").tabs("option", "active", oldIndex);
		
}
function SaveActiveAcc(){
	var activeAccIndex = $(".sidebar-accordion").accordion("option", "active");
	var dataStore = window.sessionStorage;
	try{
		dataStore.setItem("activeAccIndex", activeAccIndex);
	}catch(e){alert("Can't store index: \n"+e);}
		
}
function OpenActiveAcc(){
	var dataStore = window.sessionStorage;
	var	oldIndex = dataStore.getItem("activeAccIndex");

	$(".sidebar-accordion").accordion("option", "active", parseInt(oldIndex));
		
}
function ReseActiveTab(){
	var dataStore = window.sessionStorage;
	dataStore.setItem("activeIndex", 0);

	$("#menu-tabs").tabs("option", "active", oldIndex);
		
}
/*function OpenActiveTab(){
	var activeTabIndex = 0;
	var dataStore = window.sessionStorage;
	var oldIndex = 0;
	try{
		oldIndex = dataStore.getItem(index);
	}catch(e){alert("dataStore  exception"+e);}
	$("#menu-tabs").tabs({
		active: oldIndex,
		activate: function(e,ui){
			var newIdex = $("#menu-tabs").tabs("option", "active");
			try{
				dataStorage.setItem("index", newIndex);
			}catch(e){alert("Can't store index: \n"+e);}
		}
	});
		
}*/
/**
 * Swap the image
 */
var slideIndex = 1;
function SlideNext(){
	ShowSlides(slideIndex += 1);
}
function ShowSlides(index){
	var i;
	var slides = document.getElementsByClassName("img-slide");
	if(index > slides.length){slideIndex = 1;}
	for(i=0; i< slides.length; i++){
		slides[i].style.display = "none";
	}
	slides[slideIndex - 1].style.display = "block";
}
function CurrentSlide(index){
	ShowSlides(index);
}
/**
 * Get Details of subMenu
 * @param id
 * @param callback
 */
function GetSubMenuDetail(id, callback){
	$.ajax({
		type: "get",
		url: url,
		dataType: "json",
		cache: true,
		error: function(jqXHr,textStatus, errorThrown){
			alert("Error Uploading image:\n" + errorThrown);
		},
		success: function(data){
			callback(data);
		}
	});
}
/**
 * Get list of sub-menus belonging to parent
 * @param parentMenuId
 * @param callback
 */
function GetSubMenuList(parentMenuId, callback){
	//get home menus
	var menuList;
	var url = "/AdPost/menus/submenus?parentMenuId=" + parentMenuId
	$.ajax({
			type: "get",
			url: url,
			dataType: "json",
			cache: false,
			error: function(jqXHr,textStatus, errorThrown){
				alert("Error fetching sub-menus:\n" + errorThrown);
			},
			success: function(data){
				callback(data);
			}
		});
}
/**
 * Get menu list by type
 * @param menuType
 * @param callback
 */
function GetMenuList(menuType, callback){
	switch(menuType){
	case "all":
		$.ajax({
			type: "get",
			url: "/AdPost/menu/all",
			dataType: "json",
			cache: false,
			error: function(jqXHr,textStatus, errorThrown){
				alert("Error fetching menu list:\n" + errorThrown);
			},
			success: function(data){
				callback(data);
			}
		});
		break;
	case "category":
		$.ajax({
			type: "get",
			url: "/AdPost/menus/type?menuType=category",
			dataType: "json",
			cache: false,
			error: function(jqXHr,textStatus, errorThrown){
				alert("Error fetching home menu list:\n" + errorThrown);
			},
			success: function(data){
				callback(data);
			}
		});
		break;
	case "admin":
		$.ajax({
			type: "get",
			url: "/AdPost/menus/type?menuType=admin",
			dataType: "json",
			cache: false,
			error: function(jqXHr,textStatus, errorThrown){
				alert("Error fetching admin menu list:\n" + errorThrown);
			},
			success: function(data){
				callback(data);
			}
		});
		break;
	}

	
}
/**
 * Get advert details using the given url
 * @param url
 * @param callback
 */
function GetAdvertDetails(url, callback){
	$.ajax({
			type: "get",
			url: url,
			dataType: "json",
			cache: true,
			error: function(jqXHr,textStatus, errorThrown){
				alert("Error fetching advert details:\n" + errorThrown);
			},
			success: function(data){
				callback(data);
			}
		});
}
function GetMenuById(url, callback){
	$.ajax({
		type: "get",
		url: url,
		dataType: "json",
		error: function(jqXHr,textStatus, errorThrown){
			alert("Error fetching menu details for url:\n" + url);
		},
		success: function(data){
			callback(data);
		}
	});
}
function GetSubMenuById(url, callback){
	$.ajax({
		type: "get",
		url: url,
		dataType: "json",
		error: function(jqXHr,textStatus, errorThrown){
			alert("Error fetching home menus:\n" + errorThrown);
		},
		success: function(data){
			callback(data);
		}
	});
}
function MenuRadioClick(radioType){
	if(radioType == "category"){
	//get home menus
		$.ajax({
			type: "get",
			url: "/AdPost/menus/type?menuType=category",
			dataType: "json",
			cache: false,
			error: function(jqXHr,textStatus, errorThrown){
				alert("Error fetching home menus:\n" + errorThrown);
			},
			success: function(data){
				htmlTextMenu = "<select name='menuId'>";
				htmlTextMenu += "<option value=0>" + "</option>";
				if(data.length > 0){
					
					for(var i = 0; i < data.length; i++){
						//span.text(data.email);
						htmlTextMenu += "<option value =" + data[i].menuId +" >" 
							+ data[i].catName + "</option>"
					}	
				}
				htmlTextMenu += "</select>"
			}
			
		});
	}
	else if(radioType == "admin"){
		//get home menus
		$.ajax({
			type: "get",
			url: "/AdPost/menus/type?menuType=admin",
			dataType: "json",
			cache: false,
			error: function(jqXHr,textStatus, errorThrown){
				alert("Error fetching sidebar:\n" + errorThrown);
			},
			success: function(data){
				htmlTextMenu = "<select name='menuId'>";
				htmlTextMenu += "<option value=0>" + "</option>";
				if(data.length > 0){
					
					for(var i = 0; i < data.length; i++){
						//span.text(data.email);
						htmlTextMenu += "<option value =" + data[i].menuId +" >" 
							+ data[i].catName + "</option>"
					}	
				}
				htmlTextMenu += "</select>"
			}
			
		});
	}
}
function GetMenuStatus(callback){
	$.ajax({
		type: "get",
		url: "/AdPost/status",
		dataType: "json",
		error: function(jqXHr, textStatus, errorThrown){
			
		},
		success: function(data){
			callback(data);
		}
	});
}
function DeleteMenu(url, callback){
	$.ajax({
		type: get,
		url: url,
		dataType: "json",
		error: function(jqXHr,textStatus, errorThrown){
			alert("Ajax call failed. Something went wrong");
		},
		success: function(data){
			callback(data);
		}	
	});
}
//==========================VALIDATORS========================
/**
 * Validator for adding a new category or sub-category
 */
function AddMenu(){
	var validator = $("#add-menu-form").validate({
		errorClass: "error-msg",
		rules:{
			title: {
				required: true
			}
		},
		messages: {
			title: {
				required: "Menu title cannot be blank"
			}
		},
		errorLabelContainer: ".err-div"
	});
	
	    
	if(validator.form()){ // submit if no error
		SubmitMenu();
		//close dialog
		$("#add-menu").dialog("close");
		
		return false;
	}
}
/**
 * Validator for registering a new user
 */
function SubmitRegistration(){
	var validator = $("#register-form").validate({
		errorClass: "error-msg",
		rules:{
			firstName: {
				required: true
			},
			lastName: {
				required: true
			},
			email: {
				required: true,
				email: true
			},
			password: {
				required: true
			},
			confirmPass: {
				required: true,
				equalTo: "#password"
			}
		},
		messages: {
			firstName: {
				required: "First Name is required"
			},
			lastName: {
				required: "Last name is required"
			},
			email: {
				required: "Email is required",
				email: "Please enter valid email",
			},
			password: {
				required: "Password is required"
			},
			confirmPass: {
				required: "Re-enter password",
				equalTo: "Passwords do not match" 
			}
		},		
        errorPlacement: function (error, element) {
        	error.insertAfter(element);
        	//error.insertAfter(element.parent('.form-row'));
        }
	});
	if(validator.form()){ // submit if no error
		  $("#register-form").submit();
	}
}
/**
 * Validator for login page
 */
function SubmitLogin(){
	var validator = $("#login-form").validate({
		errorClass: "error-msg",
		rules:{
			email: {
				required: true,
				email: true
			},
			password: {
				required: true
			}
		},
		messages: {
			email: {
				required: "Email is required",
				email: "Please enter valid email"
			},
			password: {
				required: "Password cannot be empty"
			}
		},
		errorPlacement: function (error, element) {
        	error.insertAfter(element);
        }
	});
	if(validator.form()){ // validation performed
		  $("#login-form").submit();
	}
}
/**
 * Edit Menu Validator
 */
function SubmitEditMenu(){
	var validator = $("#edit-menu-form").validate({
		errorClass: "error-msg",
		rules:{
			editTitle: {
				required: true
			},
			editIcon:{
				required: true
			}
		},
		messages:{
			editTitle:{
				required: "*Required"
			},
			editIcon:{
				required: "*Required"
			}
		}
	});
	if(validator.form()){
		SubmitEditMenuAjax("menu");
		return true;
	}
}
/**
 * Edit Menu Validator
 */
function SubmitEditSubMenu(){
	var validator = $("#edit-menu-form").validate({
		errorClass: "error-msg",
		rules:{
			editTitle: {
				required: true
			},
			editUrl:{
				required: true
			}
		},
		messages:{
			editTitle:{
				required: "*Required"
			},
			editUrl:{
				required: "*Required"
			}
		}
	});
	if(validator.form()){
		SubmitEditMenuAjax("submenu");
		return true;
	}
}
function SubmitAdvert(){
	var validator = $("#add-advert-form").validate({
		errorClass: 'error-msg',
		rules:{
			menuId:{
				required: true
			},
			subMenuId:{
				required: true
			},
			adLocation:{
				required: true
			},
			adSubject:{
				required: true
			},
			adLocation:{
				required: true
			}
		},
		messages:{
			menuId:{
				required: "Select menu"
			},
			subMenuId:{
				required: "Select sub menu"
			},
			adLocation:{
				required: "Location is required"
			},
			adSubject:{
				required: "Subject cannot be blank"
			}
		}
	});
	if(validator.form()){
		$("#add-advert-form").submit();
		return true;
	}
}

//===================================RADIO-BUTTONS================


function ShowEditUser(){
	$("#view-user-bot").removeClass("hidden");
	
}
function UserTypeChange(){
	if($("#userType").val() == "employee"){
		$("#employee-details").removeClass("hidden");
	}
	else{
		$("#employee-details").addClass("hidden");
	}
}

function AddUser(formData){
	$.ajax({
		type: "post",
		url: $("#add-user-form").attr("action"),
		dataType: "json",
		data: formData,
		error: function(jqXHr,textStatus, errorThrown){
		},
		success: function(data){
			$("#add-user").dialog("close");
			if(data.status == 1){
				alert(data.message);
			}
			//alert("status: "+data.status+"  message: "+data.message);
			if(data.status == 0){
				alert("The following errors were encountered:\n" + data.message);
			}
			window.location.reload();
		}
	});//end saveUser
	
}
function SubmitMenu(){
	var formData = $("#add-menu-form").serializeArray();
	$.ajax({
		type: "post",
		url: $("#add-menu-form").attr("action"),
		dataType: "json",
		data: formData,
		error: function(jqXHr,textStatus, errorThrown){
			alert("SubmitMenu error thrown by application:\n" + errorThrown);
		},
		success: function(data){
			if(data.status == 0){
				alert("The following errors were encountered:\n" + data.message);
			}
			else{
				$("#add-menu-form").dialog("close");
			}
			window.location.reload();
			
		}
	});//end save menu
	
}
function SubmitEditMenuAjax(menuType){
	var formData = $("#edit-menu-form").serializeArray();
	if(menuType.toLowerCase() == "menu"){
		$.ajax({
			type: "post",
			url: $("#edit-menu-form").attr("action"),
			dataType: "json",
			data: formData,
			error: function(jqXHr,textStatus, errorThrown){
			},
			success: function(data){
				if(data == true){
					alert("Menu saved successfully!");
				}
				if(data == false){
					alert("The following errors were encountered:\n" + errorThrown);
				}
			}
		});//end save menu
	}
	if(menuType.toLowerCase() == "submenu"){
		$.ajax({
			type: "post",
			url: $("#edit-menu-form").attr("action"),
			dataType: "json",
			data: formData,
			error: function(jqXHr,textStatus, errorThrown){
			},
			success: function(data){
				if(data == true){
					alert("Menu saved successfully!");
				}
				if(data == false){
					alert("The following errors were encountered:\n" + errorThrown);
				}
			}
		});//end sub menu
		
	}
}
function GetUserDetails(){
	var linkUrl = $(this).attr("href");
	
	var cancel= function(){$("#add-user").dialog("close");},
	saveUser = function(){
		SubmitNewUser();
		//var formData = $("#add-user-form").serializeArray();
		//AddUser(formData);
		
	},
	dialogOpts ={
		width: 500,
		height: 450,
		modal: true,
		autoOpen: false,
		resizable: false,
		title: "View User",
		open: function(){},
		buttons:{
			"cancel": cancel,
			"save": saveUser
		},
		dialogClass: 'dialog'
	};
	$("#view-user").css("visibility", "visible");
	$("#view-user").dialog(dialogOpts);
	$("#email").focus();
	
	$.ajax({
		type: "get",
		url: linkUrl,
		dataType: "json",
		contentType: "application/x-www-form-urlencoded;charset=utf-8",
		error: function(jqXHr,textStatus, errorThrown){
		},
		success: function(data){
			if(data.status == 1){
				alert(data.message);
				//$("#view-user").dialog("open");
			}
			//alert("status: "+data.status+"  message: "+data.message);
			if(data.status == 0){
				alert("Error opening dialog:\n" + data.message);
			}
		}
		
	});//end saveUser
	
}
/*function ShowUserDetails(){
	var linkUrl = $("user-details-link").attr("href");
	var cancel= function(){$("#view-user").dialog("close");},
	saveUser = function(){
		//SubmitNewUser();
		//var formData = $("#add-user-form").serializeArray();
		//AddUser(formData);
		
	},
	dialogOpts ={
		width: 500,
		height: 450,
		modal: true,
		autoOpen: false,
		resizable: false,
		title: "View User",
		open: function(){},
		buttons:{
			"cancel": cancel,
			"save": saveUser
		},
		dialogClass: 'dialog'
	};
	//send data using ajax and open dialog on success
	$.ajax({
		type: "get",
		url: linkUrl,
		dataType: "json",
		contentType: "application/x-www-form-urlencoded;charset=utf-8",
		error: function(jqXHr,textStatus, errorThrown){
		},
		success: function(data){
			$("#view-user").removeClass("hidden");
			$("#view-user-bot").removeClass("hidden");
			$("#view-user").dialog(dialogOpts);
			$("#view-user").dialog("open");
			//alert("status: "+data.status+"  message: "+data.message);
			if(data.status == 0){
				alert("Error opening dialog:\n" + data.message);
			}
		}
		
	});//end ajax
	
	
	alert("clicked!");
	
	
}*/
/**
 * Clears all inputs in a form
 * @param formId : the id of the form to clear
 */
function ClearInputs(formId){
	$("#" + formId + " :input" ).each(function(){
		$(this).val('');
	});
}
function SetupWidgets(){

	//Tab Pages
	$("#menu-tabs").tabs();
	
	//accordion sidebar 
	$(".sidebar-accordion").accordion({
		collapsible: true,
		active: false,
		heightStyle: "content"
	});

}
function InitDom(){
	//-----------------------RADIOBUTTONS-----------------------------
	/**
	 * Create New Menu/Category Radiobutton Group
	 */
	var radios = document.getElementsByName("option");
    for (var i = 0; i < radios.length; i++) {
        if (radios[i].checked) {
        		if(radios[i].val == "category"){
        			$("#menus-cat-radio").removeClass("hidden");
        			$("#menus-menu-radio").addClass("hidden");
        		}
        		else if(radios[i].val == "menu"){
        			$("#menus-cat-radio").addClass("hidden");
        			$("#menus-menu-radio").removeClass("hidden");
        		}
        }
    }
}

 window.onload = function() {
	  //var input = document.getElementById("password").focus();
	 OpenActiveTab();
	 OpenActiveAcc();
	 CurrentSlide(1);
}
 function InitDialog(){
	 var dialogOpts ={
				width: 550,
				height: "auto",
				modal: true,
				autoOpen: false,
				resizable: false,
				position: "auto",
				title: "",
				dialogClass: 'dialog'
			};
			return $("#jqDialog").dialog(dialogOpts);
 }
 window.unload = function(){
	 ReseActiveTab();
 }
$(document).ready(
		function(){
			//initDom();
			SetupWidgets();
			var jqDialog = InitDialog();
			/**
			 * Dialogs
			 */
	
			/**
			 * Adding a new user through dialog
			 */
			$(document).on("click", "#new-user",function(e){
				
				var cancel= function(){$("#add-user").dialog("close");},
				saveUser = function(){
					
					SubmitNewUser();
					
					//var formData = $("#add-user-form").serializeArray();
					//AddUser(formData);
					
				},
				dialogOpts ={
					width: 500,
					height: 450,
					modal: true,
					autoOpen: false,
					resizable: false,
					title: "New User",
					open: function(){},
					buttons:{
						"cancel": cancel,
						"save": saveUser
					},
					dialogClass: 'dialog'
				};
				$("#add-user").css("visibility", "visible");
				$("#add-user").dialog(dialogOpts);
				$("#add-user").dialog("open");
				$("#email").focus();
				return false;
			});
			$(document).on("click", "#drivercheck",function(e){
				if($("#drivercheck").checked){
		    		$("#license_no").attr("disabled", "disabled"); 
		    		$("#tc_class").prop("disabled", true); 
		    	}
		    	else {
		    		$("#license_no").prop("disabled", false); 
				$("#tc_class").removeAttr("disabled"); 
			}
				
			});
			$(document).on("click", "#login-button",function(e){
				$("#login-form").validate({
					
					rules:{
						email: {
							required: true,
							email: true
						},
						password: {
							required: true
						}
					},
					messages: {
						email: {
							required: "Email is required",
							email: "Please enter valid email"
						},
						password: {
							required: "Password cannot be empty"
						}
					}
				
				})
				return false;
			});
			/**
			 * Dialog for editing a user
			 */
			$(document).on("click", ".lnk-user-details",function(e){
				e.preventDefault();
				var linkUrl = $(this).attr("href");
				saveUser = function(){
					//SubmitNewUser();
					//var formData = $("#add-user-form").serializeArray();
					//AddUser(formData);
					
				},
				close = function(){
					
					$("#view-user").addClass("hidden");
				};
				//send data using ajax and open dialog on success
				$.ajax({
					type: "get",
					url: linkUrl,
					dataType: "json",
					cache: true,
					error: function(jqXHr,textStatus, errorThrown){
						alert("Error opening dialog:\n" + errorThrown);
					},
					success: function(data){
						//Dates
						var createDate = new Date(data.userCreateDate);
						var lastLogin = new Date(data.lastLoginDate);
						var passExpiry = new Date(data.passExpiryDate);
						
						//details display
						$("#user-detail-email").text(data.email);	
						$("#user-detail-name").text(data.userDetail.firstName + " " + data.userDetail.lastName);	
						$("#user-detail-last-login").text((createDate.getMonth() + 1) + "/" + 
								createDate.getDate() + "/"+ createDate.getFullYear());		
						//edit details
						$('#edit-user-fname').innerHTML = data.userDetail.firstName;
						$("#edit-user-lname").value = data.userDetail.lastName;
						if(data.userStatus.toLowerCase() == 'active'){
							$("#edit-user-status").value='Active';
						}
						else {$("#edit-user-status").value='Inctive';}
						$("#view-user").appendTo("#jqDialog");
						$("#view-user").removeClass("hidden");
						$("#view-user-bot").removeClass("hidden");
						jqDialog.dialog("option",({title: data.userDetail.firstName + "Details",
							buttons:{"save": saveUser},close: close}));
						jqDialog.dialog("open");
					
					}
					
				});//end ajax
		});
			/**
			 * Edit user button on click
			 */
			$(document).on("click", "#edit-user img",function(e){
				$("#view-user-bot").removeClass("hidden");
			});
			/**
			 * Add a new menu
			 */
			$(document).on("click", "#new-menu",function(e){
				var htmlText;
				var menuType = "category";
				var addMenu = function(){
					AddMenu();
					alert("Menu Created.");
					window.location.reload();
					
				},
				close = function(){$("#add-menu").addClass("hidden");};
				
				GetMenuList(menuType, function(menuList){
					  var select = document.getElementById("parentId");
					  var length = select.length;
					  $("#parentId").empty()
					  $("#parentId").append("<option value='0'> </option>");
					  if(menuList.length > 0){
							for(var i = 0; i < menuList.length; i++){
								
								$("#parentId").append("<option value = '" + menuList[i].menuId +"' >" 
									+ menuList[i].menuName + "</option>");
							}	
						}
					  
				  });
				//open dialog
				$("#add-menu").removeClass("hidden");
				$("#add-menu").appendTo("#jqDialog");
				$("#jqDialog").dialog("option",({title: "Add Category/Sub-Category",
					buttons: {"save": addMenu}, close: close}) );
				$("#jqDialog").dialog("open");
				return false;
			});
			/**
			 * Edit a menu item
			 */
			$(document).on("click", ".menu-details-link",function(e){
				e.preventDefault();
				var status = "", open = true;
				var cancel= function(){$("#jqDialog").dialog("close");},
				saveMenu = function(){
					SaveActiveTab();
					var result = SubmitEditMenu();
					if(result){
						$("#jqDialog").dialog("close");
						window.location.reload();
					}
				},
				close = function(){$(".dg-menu-dtl").addClass("hidden");};
				$(".dg-menu-dtl").appendTo("#jqDialog");
				
				//get menu details through ajax
				GetMenuById($(this).attr("href"), function(menu){
					var textbox;
					if(menu != null){
						$(".dg-menu-dtl").removeClass("hidden");
						
					}else{open = false;}
					//set image attributes
					$(".dg-menu-dtl img").attr("src", "/AdPost/" +
							"resources/images/homeIcons/" + menu.icon);
					//$("#menu-dtl img").attr("title", "menu.icon") 
					//spans
					//$("#spn-dtlId").text(menu.menuId + ". ");
					$("#dtlName").text(" " + menu.menuName);
					$("#dtlDesc").text(" - " + menu.menuDesc);
					$("#dtlIcon").text(menu.icon);
					$("#dtlType").text(menu.menuType);
					$("#dtlStatus").text(menu.menuStatus);
					//inputs
					document.getElementById("editTitle").value = menu.menuName;
					document.getElementById("editDescription").value = menu.menuDesc;
					document.getElementById("editIcon").value = menu.icon;
					document.getElementById("editUrl").value = menu.url;
					document.getElementById("menuType").value = "menu";
					$(".dg-menu-dtl img").removeClass("hidden");

					//status = menu.menuStatus;
					if(menu.menuStatus == "ACTIVE"){
						document.getElementById("menuActive").checked = true;
					}
					if(menu.menuStatus == "INACTIVE"){
						document.getElementById("menuInactive").checked = true;
					}
					document.getElementById("hiddenId").value = menu.menuId;
					//open dialog
					
					$("#jqDialog").dialog({title: 'Editing ' + menu.menuName});					
				});
				if(open == true){
					$('.dg-menu-dtl').removeClass("ui-widget-content");
					jqDialog.dialog({buttons:{"save": saveMenu}, close:close});
					$("#jqDialog").dialog("open");
				}
				else{alert("Failed to open dialog!");}
			});

			//==============================SUBMENU ONCLICK===========================
			/**
			 * Edit SubMenu Item
			 */
			$(document).on("click", ".sub-menu-dtl", function(e){
				e.preventDefault();
				var status = "";
				var cancel= function(){$("#jqDialog").dialog("close");},
				saveMenu = function(){
					var result = SubmitEditSubMenu();
					if(result){
						$("#jqDialog").dialog("close");
						
						window.location.reload();
					}
				}
				close = function(){$(".dg-menu-dtl").addClass("hidden");};
				
				$(".dg-menu-dtl").appendTo("#jqDialog");
				
				//get menu details through ajax
				GetSubMenuById($(this).attr("href"), function(subMenu){
					var textbox;
					if(subMenu != null){
						$(".dg-menu-dtl").removeClass("hidden");
					}
					
					
					//set attributes
					$("#dtlName").text(" " + subMenu.subMenuName);
					$("#dtlDesc").text(" - " + subMenu.subMenuDesc);
					$("#dtlIcon").text(subMenu.icon);
					$("#dtlType").text(subMenu.subMenuType);
					$("#dtlStatus").text(subMenu.menuStatus);
					$(".dg-menu-dtl img").addClass("hidden");

					//inputs
					document.getElementById("editTitle").value = subMenu.subMenuName;
					document.getElementById("editDescription").value = subMenu.subMenuDesc;
					document.getElementById("editIcon").value = subMenu.icon;
					document.getElementById("editUrl").value = subMenu.url;
					document.getElementById("menuType").value = "subMenu";
					//status = menu.menuStatus;
					if(subMenu.menuStatus == "ACTIVE"){
						document.getElementById("menuActive").checked = "checked";
					}else{
						document.getElementById("menuInactive").checked = "checked";
					}
					document.getElementById("hiddenId").value = subMenu.subMenuId;
					//open dialog
					
					jqDialog.dialog({title: 'Editing ' + subMenu.subMenuName});	
				});
				//Dialog Options
				jqDialog.dialog({buttons:{"save": saveMenu}, close:close});
				$("#jqDialog").dialog("open");
			});
			$(document).on("click", ".dtl-link", function(e){
				e.preventDefault();
				var linkAction = $(this).text().toLowerCase();
				//get menu details through ajax
				if(linkAction == "delete"){
					var action = confirm("This will delete the menu as well as it's sub-menus.\n " +
							"Would you like to continue?");
					if(action == true){
						DeleteMenu(url, function(){
							if(data.success == true){
								alert("Menu successfully deleted.");
							}
							if(success == false){
								alert("Delete failed. Something went wrong");
							}
						});
					}else{
						alert("Aborting....");
					}
				}
				if(linkAction == "edit"){
					$(".edit-menu").removeClass("hidden");
				}
			});
			//=======================MENU-LIST STATE===========================
			$(document).on("click", ".menu-list a",function(e){
					  $('.active').removeClass('active');
					  $(this).addClass('active');
			});
			$(document).on("change", "#menuId",function(e){
					var parentMenuId = $(this).val();
				  GetSubMenuList(parentMenuId, function(subMenuList){
					  var select = document.getElementById("subMenuId");
					  var length = select.length;
					  $("#subMenuSelect").empty()
					  $("#subMenuSelect").append("<option value='-1'> </option>");
					  if(subMenuList.length > 0){
							for(var i = 0; i < subMenuList.length; i++){
								
								$("#subMenuId").append("<option value = '" + subMenuList[i].subMenuId +"' >" 
									+ subMenuList[i].subMenuName + "</option>");
							}	
						}
					  
						$("#subMenuId").removeClass("hidden");
				  });
				
		});
			//=========================JQUERY ACCORDION MENU=========================
			$(document).on("click", ".sidebar-accordion li a", function(e){
				SaveActiveAcc();
			});
			//navigation highlight
			var url = window.location.href;
			url = url.split("?",1);
			url = decodeURIComponent(url);
			$(".list-menu a").each(function(){
				if(this.href == url){
					//$(this).closest('li').addClass("active");
					$(this).addClass("active");
				}
			});
			$(".sidebar-accordion a").each(function(){
				if(this.href == url){
					$(this).closest('li').addClass("active");
					var liParent = $(this).parent('ul');
					liParent.closest('h3').addClass("ui-accordion-header-active");
					liParent.closest('h3').addClass("ui-state-active");
					//$(this).closest('.sidebar-accordion h3').addClass("ui-accordion-header-active");
					//$(this).parent('ui-accordion-header').addClass("ui-accordion-header-active");
					//$(this).parent('ui-accordion-header').addClass("ui-state-active");
				}
			});
			$("#menu-tabs a").on("click",function(){
				SaveActiveTab();
			});
		//==========================UPLOADCARE WIDGET ONCHANGE========================
			var multiWidget = uploadcare.MultipleWidget('[role=uploadcare-uploader][data-multiple]');
			multiWidget.onUploadComplete(function(group){
				if(group){
					group;
					//group.files();
					
					$("#add-advert-form").append(
							"<input type='hidden' name='groupCdnUrl'" +
							"value='" + group.cdnUrl + "'/>"
					);
					$("#add-advert-form").append(
							"<input type='hidden' name='groupUuid'" +
							"value='" + group.uuid + "'/>"
					);
					$("#add-advert-form").append(
							"<input type='hidden' name='groupCount'" +
							"value='" + group.count + "'/>"
					);
					$("#add-advert-form").append(
							"<input type='hidden' name='groupSize'" +
							"value='" + group.size + "'/>"
					);
				}
			});
			multiWidget.onChange(function(group){
				if(group){
					group;
					group.files();
					$.when.apply(null, group.files()).then(
							function(){
								var filesInfo = arguments;
								for(i=0; i< filesInfo.length; i++){
									$("#add-advert-form").append(
											"<input type='hidden' name='uuid[" + i + "]'" +
											"value='"+filesInfo[i].uuid+"'/>"
									);
									$("#add-advert-form").append(
											"<input type='hidden' name='cdnUrl[" + i + "]'" +
											"value='"+filesInfo[i].cdnUrl+"'/>"
									);
									$("#add-advert-form").append(
											"<input type='hidden' name='size[" + i + "]'" +
											"value='"+filesInfo[i].size+"'/>"
									);
									$("#add-advert-form").append(
											"<input type='hidden' name='name[" + i + "]'" +
											"value='"+filesInfo[i].name+"'/>"
									);
								
									//document.getElementById("#fileId").setAttribute("value", filesInfo[i].uuid);
									//document.getElementById("#cdnUrl").setAttribute("value", filesInfo[i].cdnUrl);
									var cdnUrl = filesInfo[i].cdnUrl;
									var uuid = filesInfo[i].uuid;
								}
					});
				}
			});
			
			//=======================ADVERT DETAILS ONCLICK===========================
			/*$(document).on("click", ".advert-details-link",function(e){
				var url = $(this).attr("href");
				var ok = function(){$("#advert-details").dialog("close");},
				dialogOpts ={
					width: 500,
					height: 350,
					modal: true,
					autoOpen: false,
					resizable: true,
					title: "Advert Details",
					open: function(){},
					buttons:{
						"OK": ok
					},
					dialogClass: 'dialog'
				};
				  GetAdvertDetails(url, function(advert){
					//open dialog
					  var submittedDate = new Date(advert.submittedDate);
					  $("#advert-details").removeClass("hidden");
					  $("#advert-details").dialog(dialogOpts);
					  $("#advert-details").dialog({title: advert.advertDetail.adSubject});
					  $("#advert-details").dialog("open");
					  
					  
					  $("#userName").text(advert.appUser.userDetail.firstName + " " +
							  advert.appUser.userDetail.lastName);
					  $("#adSubmittedDatetime").text("Submitted " + submittedDate);
					  $("#adSubmittedLocation").text("Posted in " + advert.advertDetail.adLocation);
					  $("#adSubject").text(advert.advertDetail.adSubject);
					  $("#adBody").text(advert.advertDetail.adBody);
					  $("#adContactNo").text("Contact No: " + advert.advertDetail.contactNo);
					  $("#adContactEmail").text("Contact Email: " + advert.advertDetail.contactEmail);
				  });
				  e.preventDefault(); 
			});	*/
			
			
	}
);


