<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Employee Management App</title>


<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css" 
integrity="sha384-HSMxcRTRxnN+Bdg0JdbxYKrThecOKuH5zCYotlSAcp1+c8xmyTe9GYg1l9a69psu" 
crossorigin="anonymous">



</head>
<body>
<h1 align="center">Welcome to Employee Management System</h1>
<br><br>


<br><br>

<div class="container">
<a href="addEmployee" class="btn btn-primary btn-sm mb-3">Add Employee</a>


<table border="1" class="table table-striped table-responsive-md">

<tr>
	<th>EmployeeId</th>
	<th>EmployeeName</th>
	<th>EmployeeAddress</th>
	<th>EmployeeEmail</th>
	<th>Salary</th>
	<th>Action</th>
</tr>

<c:forEach items="${employees }" var="emp">
<tr>
	<td>${emp.empId}</td>
	<td>${emp.name}</td>
	<td>${emp.address}</td>
	<td>${emp.email}</td>
	<td>${emp.salary}</td>
	<td>
	
		<a href="showUpdateEmployeePage/${emp.empId}" class="btn btn-warning">UPDATE</a>
		<a href="deleteEmployee/${emp.empId}" class="btn btn-danger">DELETE</a>
	
	</td>
	
</tr>

</c:forEach>

</table>


</div>


<div>



<c:choose>

<c:when test="${msg eq 'added' }">
<h2 style="color: green">Added Sucessfully !</h2>
</c:when>

<c:when test="${msg eq 'updated' }">
<h2 style="color: orange">Updated Sucessfully !</h2>
</c:when>

<c:when test="${msg eq 'deleted' }">
<h2 style="color:red">Deleted Sucessfully !</h2>
</c:when>


<c:otherwise>
<h2></h2>
</c:otherwise>

</c:choose>


</div>



</body>
</html>