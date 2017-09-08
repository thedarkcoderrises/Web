<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<script src='<c:url value="/resources/js/jquery-1.12.4.js"/>'></script>
<script type="text/javascript">
	function callMe() {
		var username = $("#username").val();
		var userRole = $("#userRole").val();
	}
</script>
<form:form action="login" method="post" modelAttribute="smUserDetails"  >
	<table>
		<tr>

			<td colspan="2">
				<div id="message"></div>
			</td>
		</tr>
		<tr>
			<td>User Name</td>
			<td><form:input path="userName" id="userName" /></td>
		</tr>
		<tr>
			<td>Select Role:</td>
			<td><form:select path="userRole" id="userRole"
					cssClass="selectBox">
					<form:option value="-1"> --SELECT--</form:option>
					<form:option value="M"> Maker</form:option>
					<form:option value="C"> Checker</form:option>
					<form:option value="D"> Dual</form:option>
					<form:option value="V"> View</form:option>
				</form:select></td>
		</tr>
		<tr>
			<td colspan="2"><form:button value="Submit" class="button">SUBMIT</form:button></td>

		</tr>
	</table>
</form:form>