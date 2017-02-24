
function UploadImage(imageType){
	if(imageType == 'adPicture'){
		//dialog popup
		var done= function(){
				var url = $("#photo-upload-form").attr("action");
				var formData = new FormData(this);
				
				UploadAdPicture(url, function(data){
					alert(data.message);
				});
				$("#photo-upload").dialog("close");
			},
		dialogOpts ={
			width: 350,
			height: 450,
			modal: true,
			autoOpen: false,
			resizable: false,
			title: "Upload Pictures",
			open: function(){},
			buttons:{
				"DONE": done
			},
			dialogClass: 'dialog'
		};
		 $("#photo-upload").removeClass("hidden");
		  $("#photo-upload").dialog(dialogOpts);
		  $("#photo-upload").dialog("open");
	}
	if(imageType == 'profilePicture'){
		
	}
	return false;
}
function UploadAdPicture(url, callback){
	$.ajax({
			type: "post",
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
				alert("Error fetching hsub-menus:\n" + errorThrown);
			},
			success: function(data){
				callback(data);
			}
		});
}
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
//==========================VALIDATORS========================
function AddMenu(){
	var validator = $("#add-menu-form").validate({
		errorClass: "error-msg",
		rules:{
			menuName: {
				required: true
			},
			catName: {
				required: true
			}
		},
		messages: {
			menuName: {
				required: "Title cannot be blank"
			},
			catName: {
				required: "Category name cannot be null"
			}
		},
		errorPlacement: function(error, element) {
            error.insertAfter(element);
        },
	});
	
	    
	if(validator.form()){ // submit if no error
		SubmitMenu();
		//close dialog
		$("#add-menu").dialog("close");
		alert("Menu Created.");
		window.location.reload();
		return false;
	}
}
function SubmitEditMenu(){
	var validator = $("#edit-menu-form").validate({
		errorClass: "error-msg",
		rules:{
			menuName: {
				required: true
			},
			menuDesc: {
				required: true
			},
			icon: {
				required: true
			}
		},
		messages: {
			menuName: {
				required: "Title is required"
			},
			menuDesc: {
				required: "Please enter a description"
			},
			icon: {
				required: "Category icon is required"
			}
		},
		errorPlacement: function(error, element) {
            error.insertAfter(element);
        },
	});
	
	    
	if(validator.form()){ // submit if no error
		SubmitEditMenuAjax();
		//close dialog
		$("#edit-menu").dialog("close");
		alert("Menu Saved.");
		window.location.reload();
		return false;
	}
}
function SubmitDeleteMenu(){
	var msgBox = confirm("Deleting this menu deletes all its sub-menus." +
			"\nWould you like to continue?");
	if(msgBox == false){
		alert("you clicked cancel!")
	}
	if(msgBox == true){
		var formData = $("#edit-menu-form").serializeArray();

		$.ajax({
			type: "get",
			url: "/AdPost/menu/delete",
			dataType: "json",
			data: formData,
			error: function(jqXHr,textStatus, errorThrown){
			},
			success: function(data){
				
				if(data.status == 1){
					alert(data.message);
				}
				if(data.status == 0){
					alert("The following errors were encountered:\n" + data.message);
				}
			}
		});//end deleteMenu
	}
}
function SubmitNewUser(){
	var validator = $("#add-user-form").validate({
		errorClass: "error-msg",
		rules:{
			firstName: {
				required: true
			},
			lastName: {
				required: true
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
				required: "Password cannot be empty"
			},
			confirmPass: {
				required: "Re-enter password",
				equalTo: "Passwords do not match"
			}
		},
		errorPlacement: function(error, element) {
            error.insertAfter(element);
        },
	});
	
	    
	if(validator.form()){ // submit if no error
		var formData = $("#add-user-form").serializeArray();
		AddUser(formData);
		alert('adding user!');
		return false;
		 }
}

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
		//errorLabelContainer: ".err-cont"
		
        errorPlacement: function (error, element) {
        	error.insertAfter(element);
        	//error.insertAfter(element.parent('.form-row'));
        }
	});
	if(validator.form()){ // submit if no error
		  $("#register-form").submit(function(){
			  //e.preventDefault();
		  });
	}
}
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
		}
	});
	if(validator.form()){ // validation perform 
		  $("#login-form").submit();
		 }
}
function SubmitEditUser(){
	var validator = $("#register-form").validate({
		errorElement: 'span',
		rules:{
			firstName: {
				required: true
			},
			lastName: {
				required: true
			}
		},
		messages: {
			firstName: {
				required: "First Name is required"
			},
			lastName: {
				required: "Last name is required"
			}
		}
	});
	if(validator.form()){ // submit if no error
		  $("#register-form").submit(function(){
			  e.preventDefault();
		  });
		 }
	
}
function SubmitReset(){
	var validator = $("#reset-form").validate({
		errorClass: "error-msg",
		rules:{
			resetEmail: {
				required: true,
				email: true
			},
			resetPass: {
				required: true
			},
			resetPassRepeat: {
				required: true
				//equalTo: "#password"
			}
		},
		messages: {
			resetEmail: {
				required: "Email is required",
				email: "Please enter valid email"
			},
			resetPass: {
				required: "Password cannot be empty"
			},
			resetPassRepeat: {
				required: "Re-enter password",
				equalTo: "Passwords do not match"
			}
		}
	
	});
	if(validator.form()){ // validation perform 
		  $("#reset-form").submit(function(){
			  e.preventDefault();
		  });
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
function DriverChecked(){
	if($("#drivercheck").attr("checked")){
		$("#license_no").
		prop("disabled", true); 
		$("#tc_class").prop("disabled", true); 
	}
	else {
		$("#license_no").prop("disabled", false); 
	$("#tc_class").removeAttr("disabled"); 
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
			alert("The following errors were encountered:\n" + errorThrown);
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
function SubmitEditMenuAjax(){
	var formData = $("#edit-menu-form").serializeArray();

	$.ajax({
		type: "post",
		url: $("#edit-menu-form").attr("action"),
		dataType: "json",
		data: formData,
		error: function(jqXHr,textStatus, errorThrown){
		},
		success: function(data){
			if(data.status == 1){
				alert(data.message);
			}
			if(data.status == 0){
				alert("The following errors were encountered:\n" + data.message);
			}
		}
	});//end saveUser
		
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
function ShowUserDetails(){
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
	
	
}
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
	$(".sidebar-accordion").accordion();

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
	}
$(document).ready(
		function(){
			//initDom();
			SetupWidgets();
			
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
			$(document).on("click", ".user-details-link",function(e){
				e.preventDefault();
				var linkUrl = $(this).attr("href");
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
						
						$("#view-user").removeClass("hidden");
						$("#view-user-bot").removeClass("hidden");
						$("#view-user").dialog(dialogOpts);
						$("#view-user").dialog("open");
					
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
				var cancel= function(){$("#add-menu").dialog("close");},
				addMenu = function(){
					
					AddMenu();
					
				},
				dialogOpts ={
					width: 500,
					height: 350,
					modal: true,
					autoOpen: false,
					resizable: false,
					title: "Add Category/Sub-Category",
					open: function(){},
					buttons:{
						"cancel": cancel,
						"save": addMenu
					},
					dialogClass: 'dialog'
				};
				GetMenuList(menuType, function(menuList){
					  var select = document.getElementById("menuSelect");
					  var length = select.length;
					  $("#menuSelect").empty()
					  $("#menuSelect").append("<option value='0'> </option>");
					  if(menuList.length > 0){
							for(var i = 0; i < menuList.length; i++){
								
								$("#menuSelect").append("<option value = '" + menuList[i].menuId +"' >" 
									+ menuList[i].menuName + "</option>");
							}	
						}
					  
				  });
				//open dialog
				$("#add-menu").removeClass("hidden");
				$("#add-menu").dialog(dialogOpts);
				$("#add-menu").dialog("open");
				
				return false;
			});
			/**
			 * Edit a menu item
			 */
			$(document).on("click", ".menu-details-link",function(e){
				var cancel= function(){$("#edit-menu").dialog("close");},
				saveMenu = function(){
					
					SubmitEditMenu();
					
				},
				deleteMenu = function(){
					SubmitDeleteMenu();
					alert("Menu deleted.")
					$("#edit-menu").dialog("close");
					window.location.reload();
				},
				dialogOpts ={
					width: 500,
					height: 350,
					modal: true,
					autoOpen: false,
					resizable: false,
					title: "Edit Menu",
					open: function(){},
					buttons:{
						"cancel": cancel,
						"delete": deleteMenu,
						"save": saveMenu
					},
					dialogClass: 'dialog'
				};
				//get menu details through ajax
				$.ajax({
					type: "get",
					url: $(this).attr("href"),
					dataType: "json",
					cache: false,
					error: function(jqXHr,textStatus, errorThrown){
						alert("Error getting menu detail:\n" + errorThrown);
					},
					success: function(data){
						
						//open dialog
						$("#edit-menu").dialog(dialogOpts);
						$("#edit-menu").dialog({title: 'Editing ' + data.menuName});
						$("#edit-menu").dialog("open");
						//select values
						$("#menuType").val(data.menuType);
						$("#menuStatus").val(data.menuStatus);
						//populate input values
						$("#menuId").val(data.menuId);
						$("#menuName").val(data.menuName);
						$("#menuDesc").val(data.menuDesc);
						$("#url").val(data.url);
						$("#icon").val(data.icon);
					}
					
				});//end menu ajax
				return false;
			});
			
			//=======================MENU-LIST STATE===========================
			$(document).on("click", ".menu-list a",function(e){
					  $('.active').removeClass('active');
					  $(this).addClass('active');
			});
			$(document).on("change", "#new-ad-category",function(e){
					var parentMenuId = $(this).val();
				  GetSubMenuList(parentMenuId, function(subMenuList){
					  var select = document.getElementById("subMenuSelect");
					  var length = select.length;
					  $("#subMenuSelect").empty()
					  $("#subMenuSelect").append("<option value='-1'> </option>");
					  if(subMenuList.length > 0){
							for(var i = 0; i < subMenuList.length; i++){
								
								$("#subMenuSelect").append("<option value = '" + subMenuList[i].subMenuId +"' >" 
									+ subMenuList[i].subMenuName + "</option>");
							}	
						}
					  
						$("#subMenuSelect").removeClass("hidden");
				  });
				
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


