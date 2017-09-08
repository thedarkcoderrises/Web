
<%
	Cookie cookie = new Cookie("user", null); // Not necessary, but saves bandwidth.

	cookie.setPath("/achWeb");

	//cookie.setHttpOnly(true);

	cookie.setMaxAge(0); // Don't set to -1 or it will become a session cookie!

	response.addCookie(cookie);
%>



<script type="text/javascript">
if (confirm("Do you want to Exit?")) {
open(location, '_self').close();
}
</script>