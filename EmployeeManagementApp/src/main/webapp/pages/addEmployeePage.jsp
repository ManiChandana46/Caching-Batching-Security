<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>


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
<h1 align="center">Welcome to Add Employee Screen</h1>
<br><br>

<div class="container">

<form:form action="registerEmployee" method="post" modelAttribute="emp" >

<div class="form-group">
<label for="name">Name</label>
<form:input path="name" class="form-control" id="name" required="required"/><form:errors path="name" style="color:red"/>
</div>

<div class="form-group">
<label for="address">Address</label>
<form:input path="address" class="form-control" id="address" required="required"/><form:errors path="address" style="color:red"/>
</div>

<div class="form-group">
<label for="email">email</label>
<form:input path="email" class="form-control" id="email" required="required"/><form:errors path="email" style="color:red"/>
</div>

<div class="form-group">
<label for="salary">Salary</label>
<form:input path="salary" class="form-control" id="salary" required="required"/><form:errors path="salary" style="color:red"/>
</div>

<input type="submit" value="Add" class="btn btn-primary btn-sm mb-3">

</form:form>






</div>




</body>
</html>