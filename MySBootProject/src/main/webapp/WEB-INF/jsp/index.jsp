<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <title>Employee Info</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
</head>
<body>

<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
  <!-- Brand/logo -->
  <a class="navbar-brand" href="#">
    <img src="bird.jpg" alt="logo" style="width:40px;">
  </a>
  
  <!-- Links -->
  <ul class="navbar-nav">
    <li class="nav-item">
      <a class="nav-link" href="#">Home</a>
    </li>
    <li class="nav-item">
      <a class="nav-link" href="/">All DATA</a>
    </li>
    <li class="nav-item">
      <a class="nav-link" href="newdata">ADD DATA</a>
    </li>
  </ul>
</nav>

<div class="container-fluid">
<c:choose>
 <c:when test="${mode == 'DATA_VIEW' }">
 
  <table class="table table-bordered">
    <thead>
      <tr>
        <th>ID</th>
        <th>FirstName</th>
        <th>LastName</th>
        <th>DOB</th>
        <th>EDIT</th>
        <th>DELETE</th>
      </tr>
    </thead>
    <tbody>
    <c:forEach var = "emp" items = "${emps}">
      <tr>
        <td>${emp.id}</td>
        <td>${emp.firstname}</td>
        <td>${emp.lastname}</td>
        <td>${emp.dob}</td>
        <td><a href="updateEmp?id=${emp.id}"><span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>edit</a></td>
        <td><a href="deletedata?id=${emp.id}"><span class="glyphicon glyphicon-trash" aria-hidden="true"></span>Delete</a></td>
       
      </tr>
     </c:forEach> 
    </tbody>
  </table>
  </c:when>
  <c:when test="${mode == 'DATA_EDIT' || mode == 'DATA_NEW'}">
  <form action="save" method="post">
  
  <input type="hidden" class="form-control" value="${emp.id}" name="id" id="id"/>
  <div class="form-group">
    <label for="firstname">First Name:</label>
    <input type="text" class="form-control" value="${emp.firstname}" name="firstname" id="firstname">
  </div>
  <div class="form-group">
    <label for="lastname">Last Name:</label>
    <input type="text" class="form-control" value="${emp.lastname}" name="lastname" id="lastname">
  </div>
  <div class="form-group">
    <label for="dob">DOB:</label>
    <input type="date" class="form-control" value="${emp.dob}"name="dob" id="dob">
  </div>
  
  <button type="submit" class="btn btn-primary">Submit</button>
</form>

  
  </c:when>
</c:choose>
</div>

</body>
</html>
