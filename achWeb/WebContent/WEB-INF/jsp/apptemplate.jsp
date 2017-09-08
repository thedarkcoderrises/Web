<%@page import="com.citi.dde.achweb.pojo.LogInUserDetails"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"  
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="X-UA-Compatible" content="IE=Edge">

<link rel="stylesheet" type="text/css"
	href="<c:url value='/resources/css/jquery.dataTables.min.css'/>">
<link rel="stylesheet"
	href="<c:url value='/resources/css/jquery-ui.css'/>">
<link rel="stylesheet" type="text/css"
	href="<c:url value='/resources/css/style.css'/>">

<script src="<c:url value='/resources/js/jquery-1.12.4.js'/>"></script>
<script src="<c:url value='/resources/js/jquery-ui.js'/>"></script>
<script src="<c:url value='/resources/js/bootstrap.min.js'/>"></script>
<script src="<c:url value='/resources/js/jquery.dataTables.min.js'/>"></script>
<!-- <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1"> -->
<script>
	$(document).ready(function() {
		startTime();
	});
	function startTime() {
		var today = new Date();
		var h = today.getHours();
		var m = today.getMinutes();
		var s = today.getSeconds();
		m = checkTime(m);
		s = checkTime(s);
		document.getElementById('clock').innerHTML = today.toDateString() + " "
				+ h + ":" + m + ":" + s;
		var t = setTimeout(function() {
			startTime()
		}, 500);
	}

	function checkTime(i) {
		if (i < 10) {
			i = "0" + i
		}
		; // add zero in front of numbers < 10
		return i;
	}
	window.location.hash = "#";
	window.location.hash = "##";//again because google chrome don't insert first hash into history
	window.onhashchange = function() {
		window.location.hash = "#";
	}
</script>

<title><tiles:insertAttribute name="title" ignore="true" /></title>

</head>
<%
    LogInUserDetails usr;
	if (session.getAttribute("userDetails") != null) {
		usr = (LogInUserDetails) session.getAttribute("userDetails");
	}else{
		usr = new LogInUserDetails();
	}
%>
<c:set var="roleMaker" value="<%=usr.isMakerRole()%>" scope="session" />
<c:set var="roleChecker" value="<%=usr.isCheckerRole()%>"
	scope="session" />
<c:set var="roleViewer" value="<%=usr.isViewRole()%>" scope="session" />
<c:set var="roleDual" value="<%=usr.isDualRole()%>" scope="session" />
<c:set var="username" value="<%=usr.getUserName()%>" scope="session" />
<body>
	<table cellpadding="0" cellspacing="0" align="center" class="headerbox">
		<tr>
		<td>
			
			<tr class="topMenu" >
			<td class="paddingRight" id="clock" style="float: left;"></td>
			<c:if test="${not empty username}">
				<td class="paddingRight" style="float:right;" >Hello, <c:out value="${username}"></c:out>
				<a class="paddingLeft" href="logout" style="color: white;">Logout</a>
				</td>
			</c:if>
		   </tr>
		</tr>
		<tiles:insertAttribute name="header" />
		<tiles:insertAttribute name="menu" />
		<!-- </table> -->
		</td>
		</tr>
		<tr class="bodyPart">
			<td><tiles:insertAttribute name="body" /></td>
		</tr>
	</table>
</body>
</html>