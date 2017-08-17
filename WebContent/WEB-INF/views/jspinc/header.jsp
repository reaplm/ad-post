<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
			<link href="<%=request.getContextPath()%>/resources/js/jquery-ui-1.10.3/themes/base/jquery.ui.all.css" rel = "stylesheet" type = "text/css" />
	
		<link href="<%=request.getContextPath()%>/resources/css/style.css" rel = "stylesheet" type = "text/css" />
		<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
		<link rel="shortcut icon" type="image/png" href="/logo.png"/>
		<script type="text/javascript" src="<%=request.getContextPath()%>/resources/js/jquery-ui-1.10.3/jquery-1.9.1.js"></script>
				<script type="text/javascript" src="<%=request.getContextPath()%>/resources/js/jquery.validate.js"></script>
		<script type="text/javascript" src="<%=request.getContextPath()%>/resources/js/jquery-ui-1.10.3/ui/jquery-ui.js"></script>
		<script type="text/javascript" src="<%=request.getContextPath()%>/resources/js/jquery-ui-1.10.3/ui/jquery.ui.tabs.js"></script>
		<script type="text/javascript" src="<%=request.getContextPath()%>/resources/js/jquery-ui-1.10.3/ui/jquery.ui.core.js"></script>
		<script type="text/javascript" src="<%=request.getContextPath()%>/resources/js/jquery-ui-1.10.3/ui/jquery.ui.widget.js"></script>
		<script type="text/javascript" src="<%=request.getContextPath()%>/resources/js/jquery-ui-1.10.3/ui/jquery.ui.dialog.js"></script>
				<script type="text/javascript" src="<%=request.getContextPath()%>/resources/js/scripts.js"></script>
		
		<script>
			UPLOADCARE_LOCALE = "en";
			UPLOADCARE_PUBLIC_KEY = '402840513ca8fdd44f3b';
		    UPLOADCARE_TABS = 'file camera dropbox';
		    UPLOADCARE_IMAGES_ONLY = true;
		</script>
		<script charset="utf-8" src="//ucarecdn.com/widget/3.0.0/uploadcare/uploadcare.full.min.js"></script>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>${param.title}</title>
	</head>
	<body>
		<div id="jqDialog" class="dialog"></div>
		<div id="wrapper">
	
			
		
