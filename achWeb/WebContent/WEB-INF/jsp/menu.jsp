<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<script type="text/javascript"
	src="<c:url value="/resources/js/jquery-1.12.4.js"/>"></script>

<link rel="stylesheet" media="all" type="text/css" href="<c:url value="resources/css/dfpmenu.css" />" >
<script>	
	var data='<%=request.getContextPath()%>';	
</script>
<!-- js -->
<script type="text/javascript" src="<c:url value="/resources/customjs/drawmenu.js"/>"></script>

<div class="menu-container">
</div>