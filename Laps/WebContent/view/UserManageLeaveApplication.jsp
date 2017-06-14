<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%! static final String message="Welcome";%>

<html><body>
<form method="post">
<% 
	String readonly = "readonly";
	String btnPending = "hidden";
	String btnApprove = "submit";
	String s1="",s2="",s3="";
	%>
		<c:if test="${ leave.status == 'PENDING'}">
			
		</c:if>
		<c:choose>
    		<c:when  test="${ leave.status == 'PENDING'}">
        		<%
					readonly ="";
					btnPending = "submit";
					btnApprove = "hidden";
			 	%>
    		</c:when>
    		<c:when  test="${ leave.status == 'REJECTED'}">
        		<%
					btnPending = "hidden";
					btnApprove = "hidden";
			 	%>
    		</c:when>
		</c:choose>
		<input type="hidden" name="appnId" value="${leave.appnId}" />
		
		 <label>Application Id:</label>
		 <input type="text" name="ApplicationID" value="${leave.appnId }" readonly>
		 <br/> 
		
		 <label>EmployeeName:</label> 
		 <input type="text" name="EmployeeName" value="${leave.user.name }" readonly>
		 <br/> 
		 
		<label>Leave Type :</label>
		<%if(readonly == "readonly"){%>
		<input type="text" name="LeaveType" value="${leave.leaveType.leaveType }" readonly>
		<%}else{%>
		<c:choose>
    		<c:when test="${leave.leaveType.leaveType.equals('Annual')}">
        		<%s1="Selected";%>
    		</c:when>
    		<c:when test="${leave.leaveType.leaveType.equals('Medical')}">
        		<%s2="Selected";%>
    		</c:when>
    		<c:otherwise>
        		<%s3="Selected";%>
    		</c:otherwise>
		</c:choose>
		<select name="leaveType">
		<option value="1" <%=s1%>>Annual</option>
		<option value="2" <%=s2%>>Medical</option>
		<option value="3" <%=s3%>>Compensation</option> 
		</select>
		<%}%>
		<br/> 
		
		<label>StartDate: </label> 
		<input type="text" name="StartDate" value="<fmt:formatDate type="date" pattern="MM/dd/yyyy" dateStyle="short" value="${leave.startDate }"/>" <%=readonly%>/>
		<br/>
		 
		<label>End Date</label> 
		
		<input type="text" name="EndDate" value="<fmt:formatDate type="date"  pattern="MM/dd/yyyy" dateStyle="short" value="${leave.endDate }"/>" <%=readonly%>/><br />				
		
		<label>Applied Date: </label>
		<input type="text" name="AppliedDate" value="<fmt:formatDate type="date"  pattern="MM/dd/yyyy" dateStyle="short" value="${leave.appnDate }" />" readonly/>
		<br/>
		
		<label>Status:</label>
		<label>${leave.status }</label>
		<br/>
		
		<input type="<%=btnPending%>" name="btnAction" value="UPDATE"  onclick="alert('Updated Successfully!')"/> <br />
		<input type="<%=btnApprove%>" name="btnAction" value="CANCEL" onclick="alert('Leave Cancelled!')" />
		<input type="<%=btnPending%>" name="btnAction" value="DELETE"  onclick="alert('Updated Successfully!')"/>

	</form>
</body>
</html>