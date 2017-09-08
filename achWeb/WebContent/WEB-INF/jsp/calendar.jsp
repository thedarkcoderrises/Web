<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>

<script src='<c:url value="/resources/js/holiday.js"/>'></script>
<link href='<c:url value="/resources/css/fullcalendar.min.css"/>'
	rel='stylesheet' />
<link href='<c:url value="/resources/css/fullcalendar.print.min.css"/>'
	rel='stylesheet' media='print' />

<script src='<c:url value="/resources/js/moment.min.js"/>'></script>
<script src='<c:url value="/resources/js/jquery.min.js"/>'></script>
<script src='<c:url value="/resources/js/jquery-1.12.4.js"/>'></script>
<script src='<c:url value="/resources/js/jquery-ui.js"/>'></script>
<script src='<c:url value="/resources/js/fullcalendar.min.js"/>'></script>

<script src='<c:url value="/resources/customjs/popup.js"/>'></script>
<script src='<c:url value="/resources/customjs/backspace.js"/>'></script>
<script
	src='<c:url value="/resources/customjs/restrictspecialchar.js"/>'></script>
<script>
	/*
	 * this swallows backspace keys on any non-input element.
	 * stops backspace -> back
	 */
	/* $(function() {
			
		var rx = /INPUT|SELECT|TEXTAREA/i;
		
		$(document).bind(
				"keydown keypress",
				function(e) {
					if (e.which == 8) { // 8 == backspace
						if (!rx.test(e.target.tagName) || e.target.disabled
								|| e.target.readOnly) {
							alert('Not Allowed');
							e.preventDefault();
						}
					}
				});
	});
	 */
	function parseJSON(data) {
		return window.JSON && window.JSON.parse ? window.JSON.parse(data)
				: (new Function("return " + data))();
	}
	$(document).on('click', '.fc-next-button', function() {
		console.log("Clicked on next button.....");
	});
	$(document).on('click', '.fc-prev-button', function() {
		console.log("Clicked on previous button.....");
	});
	$(document).ready(
			function() {
				//put this method in common js file
				Date.prototype.yyyymmdd = function() {
					var yyyy = this.getFullYear().toString();
					var mm = (this.getMonth() + 1).toString(); // getMonth() is zero-based         
					var dd = this.getDate().toString();
					return yyyy + '-' + (mm[1] ? mm : "0" + mm[0]) + '-'
							+ (dd[1] ? dd : "0" + dd[0]);
				};
				var holidayList = parseJSON('${allHolidayDetails}');
				var holidayDataList = new Array();
				$.each(holidayList, function(index, value) {
					var holidayDataObj = new Object();
					holidayDataObj.title = value.description;
					holidayDataObj.start = new Date(value.holidayDate)
							.yyyymmdd();
					holidayDataList.push(holidayDataObj);
				});

				$('#calendar').fullCalendar({
					defaultDate : new Date(),
					editable : false,
					eventLimit : true, // allow "more" link when too many events
					disableDragging : true,
					events : holidayDataList
				});

				/* $("#addcalendar").click(function(e) {
					var holidayId = $("#holidayId").val();
					var productCode = $("#productCode").val();
					alert('Hi ...');
					var holidays = $("#addHolidayForm").serialize();
					alert('holidays '+holidays);
					//$.post('addHoliday', holidays);
					//$("#addHolidayForm").submit();
				});	 */

				/*  $('#addHolidayForm').on('submit', function(e){
				      e.preventDefault();
				      //$("#popupDialog").popup('open');
				    }); */

				$("#datepicker").datepicker({
					minDate : 1,
					onSelect: function() { $('#adddialog-form').focus(); }
				});
				// Delete the IDs
				/* $("#deletecalendar").click(function(e) {
					var someObj = {};
					someObj.fruitsGranted = [];
					someObj.fruitsDenied = [];
					$('#deletedialog-form input:checkbox').each(function() {
						var sThisVal;
						if (this.checked) {
							sThisVal = $(this).val();
							someObj.fruitsGranted.push(sThisVal);
						}
					});
					$("#deleteIds").val(someObj.fruitsGranted);
					var str1 = $("#deleteHolidayForm").serialize();
					//$.post('deleteHoliday.htm', str1);
				}); */

				//Approve holiday code start
				$("#approvecalendar").click(function(e) {
					//alert('Hi');
					var someObj = {};
					someObj.fruitsGranted = [];
					someObj.fruitsDenied = [];
					$('#approvedialog-form input:checkbox').each(function() {
						var sThisVal;
						if (this.checked) {
							sThisVal = $(this).val();
							//alert('Hi ' + sThisVal);
							someObj.fruitsGranted.push(sThisVal);
						}
					});
					//alert(someObj.fruitsGranted);
					$("#approvedeleteIds").val(someObj.fruitsGranted);
					//alert($("#approvedeleteIds").val());
					$("#status").val("approve");
					str1 = $("#approveHolidayForm").serialize();
					//$.post('deleteHoliday.htm', str1);
				});
				//Approve holiday code end

				//Reject holiday code start
				$("#rejectcalendar").click(function(e) {
					var someObj = {};
					someObj.fruitsGranted = [];
					someObj.fruitsDenied = [];
					$('#approvedialog-form input:checkbox').each(function() {
						var sThisVal;
						if (this.checked) {
							sThisVal = $(this).val();
							someObj.fruitsGranted.push(sThisVal);
						}
					});
					//alert(someObj.fruitsGranted);
					$("#approvedeleteIds").val(someObj.fruitsGranted);
					$("#status").val("reject");
					str1 = $("#approveHolidayForm").serialize();
					//$.post('deleteHoliday.htm', str1);
				});
				//Reject holiday code end

				/* $("#addholidaycalendar").button().on("click", function() {
					str1 = $("#addHolidayForm").serialize();
					$("#addHolidayForm").submit();
				}); */

			});
</script>
<style>

/* body {
		margin: 40px 10px;
		padding: 0;
		font-family: "Lucida Grande",Helvetica,Arial,Verdana,sans-serif;
		font-size: 14px;
	} */
#calendar {
	max-width: 600px;
	margin: 0 auto;
}
</style>
</head>
<body>
	<table style="width: 100%; border: 1px black solid;" id="calendarTable">
		<tr>
			<td style="vertical-align: top;">
				<fieldset>
					<legend>Holiday Maintenance Screen</legend>
					<div id='calendar'></div>
				</fieldset>
			</td>
			<td style="vertical-align: top;">
				<fieldset>
					<legend>Holiday List View</legend>
					<div style="width: 550px; height: 485px; overflow: scroll;">
					<table class="innerTable">
						<tr>
							<th nowrap>Product Code</th>
							<th nowrap>Branch Name</th>
							<th nowrap>Date</th>
							<th nowrap>Description</th>
							<th nowrap>Status</th>
						</tr>

						<c:choose>
							<c:when test="${empty holidayDetails}">
								<tr>
									<td colspan="2" class="error">No Holiday Maintain</td>
								</tr>

							</c:when>
							<c:otherwise>
								<c:forEach items="${holidayDetails}" var="holiday">
									<tr>
										<td nowrap style="padding: 3px;">${holiday.productCode}</td>
										<td nowrap style="padding: 3px;">${holiday.branchName}</td>
										<td nowrap="nowrap" style="padding: 3px;">${holiday.holidayDate}</td>
										<td nowrap style="padding: 3px;">${holiday.description}</td>
										<td nowrap style="padding: 3px;">${holiday.lastStatus}</td>
									</tr>
								</c:forEach>
							</c:otherwise>
						</c:choose>
					</table>
					</div>
				</fieldset>
			</td>
		</tr>
		<tr>
			<td align="center" style="padding-left: 15px;">
				<table style="width: 50%;">
					<tr>
						<c:if test="${roleMaker || roleDual}">
							<td><input type="button" id="addholiday" value="Add"
								class="button" /></td>
						</c:if>
						<c:if test="${roleMaker || roleDual}">
							<td><input type="button" id="deleteholiday" value="Delete"
								class="button" /></td>
						</c:if>
						<c:if test="${roleChecker || roleDual}">
							<td><input type="button" value="Approve/Reject"
								id="approveHoliday" class="button" style="width:110px; "/></td>
						</c:if>
					</tr>
				</table>
			</td>
		</tr>
	</table>
</body>
</html>
<div id="deletedialog-form" title="Delete Holiday">

	<form:form action="deleteHoliday" name="deleteHolidayForm"
		id="deleteHolidayForm" method="post" commandName="mkrchkrHoliday">
		<form:hidden path="deleteIds" id="deleteIds" />
		<table class="innerTable">
			<tr>
				<td>
					<table class="innerTable borderLine">
						<tr>
							<td></td>
							<th>Product Code</th>
							<th>Branch Name</th>
							<th>Date</th>
							<th>Description</th>
						</tr>
						<c:choose>
							<c:when test="${empty approveHolidayDetails}">
								<tr>
									<td colspan="3" class="error">No Data Found</td>
								</tr>

							</c:when>
							<c:otherwise>
								<c:forEach items="${approveHolidayDetails}" var="holiday">
									<tr>
										<td><input type="checkbox" name="holidayIdsAll"
											value="${holiday.holidayId}"></td>
										<td nowrap style="padding: 3px;">${holiday.productCode}</td>
										<td nowrap style="padding: 3px;">${holiday.branchName}</td>
										<td nowrap style="padding: 3px;">${holiday.holidayDate}</td>
										<td >${holiday.description}</td>

									</tr>
								</c:forEach>
							</c:otherwise>
						</c:choose>
					</table>
				</td>
			</tr>

			<!-- <tr>
				<td colspan="2" style="text-align: center"><input type="Submit"
					value="Delete" id="deletecalendar" class="button">&nbsp; <input
					type="Reset" value="Reset" class="button"></td>
			</tr> -->
		</table>
	</form:form>
</div>

<div id="approvedialog-form" title="Approve/Reject Holiday">

	<form:form action="approveHoliday" name="approveHolidayForm"
		id="approveHolidayForm" method="post" commandName="mkrchkrHoliday">
		<form:hidden path="deleteIds" id="approvedeleteIds" />
		<form:hidden path="status" id="status" />
		<div class="form_resultApprove error" id="removeApproveMessage"></div>
		<table class="innerTable">
			<tr>
				<td>
					<table class="innerTable borderLine">
						<tr>
							<td></td>
							<th>Product Code</th>
							<th>Branch Name</th>
							<th>Date</th>
							<th>Description</th>
							<th>Status Code</th>
						</tr>
						<c:choose>
							<c:when test="${empty allMkrChkrHolidayDetails}">
								<tr>
									<td colspan="3" class="error">No Data Found</td>
								</tr>
							</c:when>
							<c:otherwise>
								<c:forEach items="${allMkrChkrHolidayDetails}"
									var="makercheckHoliday">
									<tr>
										<td><input type="checkbox" name="holidayIdsAll"
											value="${makercheckHoliday.holidayId}"></td>
										<td nowrap style="padding: 3px;">${makercheckHoliday.productCode}</td>
										<td nowrap style="padding: 3px;">${makercheckHoliday.branchName}</td>
										<td nowrap style="padding: 3px;">${makercheckHoliday.holidayDate}</td>
										<td style="padding: 3px;">${makercheckHoliday.description}</td>
										<td nowrap style="padding: 3px;">${makercheckHoliday.lastStatus}</td>
									</tr>
								</c:forEach>
							</c:otherwise>
						</c:choose>
					</table>
				</td>
			</tr>
			<!-- <tr>
				<td colspan="2" style="text-align: center"><input type="submit"
					value="Approve" id="approvecalendar" class="button">&nbsp;
					<input type="submit" value="Reject" id="rejectcalendar"
					class="button"></td>
			</tr> -->
		</table>
	</form:form>
</div>

<div id="adddialog-form" title="Add Holiday">

	<form:form action="addHoliday" name="addHolidayForm"
		id="addHolidayForm" method="post" commandName="mkrchkrHoliday">
		<div class="form_result error" id="removeMessage"></div>
		<table class="innerTable" id="addHolidayTable">
			<tr>
				<td>Product Code*:</td>
				<td class="styled-select"><form:select path="productCode"
						id="productCode">
						<form:option value="-1"> --SELECT--</form:option>
						<form:option value="all">ALL</form:option>
						<form:options items="${productList}" itemValue="productCode"
							itemLabel="productCode"></form:options>
					</form:select></td>
			</tr>
			<tr>
				<td>Branch Code*:</td>
				<td class="styled-select"><form:select path="branchCode"
						id="branchCode">
						<form:option value="-1"> --SELECT--</form:option>
						<form:option value="all">ALL</form:option>
						<form:options items="${branchList}" itemValue="branchCode"
							itemLabel="branchName"></form:options>
					</form:select></td>
			</tr>
			<tr>
				<td>Description*:</td>
				<td><form:input path="description" id="description" onkeypress="return alphanumeric_only(event);"/></td>
			</tr>
			<tr>
				<td>Holiday Date*:</td>
				<td><form:input path="holidayDate" id="datepicker" /></td>
			</tr>

			<!-- <tr>
				<td colspan="2" style="text-align: center"><input type="submit"
					value="Add" id="addholidaycalendar" class="button">&nbsp; <input
					type="reset" value="Reset" class="button"></td>
			</tr> -->
		</table>
	</form:form>
</div>