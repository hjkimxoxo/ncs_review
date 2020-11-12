<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>사원 목록</title>
<link rel="stylesheet" type="text/css" href="css/style.css">
<script src="http://code.jquery.com/jquery-3.5.1.js"></script>
<script type="text/javascript">
$(function(){
	var contextPath = "<%=request.getContextPath()%>";
	
	$.get(contextPath+"/api/employees", function(json){
		var datalength = json.length; 
		console.log(datalength)
		if(datalength >= 1){
			var sCont = "";
			for(i=0; i<datalength; i++){
				sCont += "<tr>";
				sCont += "<td>" + json[i].empNo + "</td>";
				sCont += "<td>" + json[i].empName + "</td>";
				sCont += "<td>" + json[i].title + "</td>";
				if(json[i].manager == null) {
					sCont += "<td></td>";
				} else {
					sCont += "<td>" + json[i].manager.empNo + "</td>";
				}
				
				var salary = json[i].salary;
				var res = salary.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ",");
				
 				sCont += "<td>" + res + "</td>";
 				console.log(json[i].salary)
				sCont += "<td>" + json[i].dept.deptNo + "</td>";
				sCont += "</tr>";
				
			}
			$("#load:last-child").append(sCont);
			
		} 
	});
})

</script>
</head>
<body>
<h2><spring:message code="employee"/><spring:message code="list"/></h2>
<table border="1">
	<thead>
		<td><spring:message code="eno"/></td>
		<td><spring:message code="ename"/></td>
		<td><spring:message code="title"/></td>
		<td><spring:message code="manager"/></td>
		<td><spring:message code="salary"/></td>
		<td><spring:message code="dept"/></td>
	</thead>
	<tbody id="load">
	</tbody>
</table>

</body>
</html>