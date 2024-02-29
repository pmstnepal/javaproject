<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home Page</title>
<style>
h2 {
	color: red;
	font-weight: bold;
}

h3 {
	background-color: yellow;
	width: 65%;
}
</style>
</head>
<body>
	<h1 align="center">Welcome ${meg}</h1>
	<hr />
	<h2 align="center">This is Home Page</h2>

	<hr />
	<div align="center">

		<h3>SignUp List:</h3>

		<h2 class="text-center">${message}</h2>



       <form action="search">

		<table class="table table-striped table-dark">
			<thead style="background-color: pink;">
				${cmtopen}<tr>
					<th colspan="3" align="left"><a href="signup">
							<button type="button" class="btn btn-success">ADD NEW
								USER</button>
					</a></th>


					<th colspan="3"></th>
					
					

					<th width="200"><input type="text" name="username"
						class="form-control"></th>
					<th colspan="2"><button type="submit" class="btn btn-primary">SEARCH</button></th>
					
					

				</tr>${cmtclose}
				<tr>
					<th width="150">Full Name &nbsp;&nbsp;&nbsp; 
					${cmtopen}
					<a
						href="sortByName?sortbyN=${sortbyN}">
						
						<svg
								xmlns="http://www.w3.org/2000/svg" width="16" height="16"
								fill="currentColor" class="bi bi-arrow-down-up"
								viewBox="0 0 16 16">
  <path fill-rule="evenodd"
									d="M11.5 15a.5.5 0 0 0 .5-.5V2.707l3.146 3.147a.5.5 0 0 0 .708-.708l-4-4a.5.5 0 0 0-.708 0l-4 4a.5.5 0 1 0 .708.708L11 2.707V14.5a.5.5 0 0 0 .5.5m-7-14a.5.5 0 0 1 .5.5v11.793l3.146-3.147a.5.5 0 0 1 .708.708l-4 4a.5.5 0 0 1-.708 0l-4-4a.5.5 0 0 1 .708-.708L4 13.293V1.5a.5.5 0 0 1 .5-.5" />
</svg></a>
						${cmtclose}
						</th>
					<th width="200">Date of Birth</th>
					<th width="200">Usename &nbsp;&nbsp;&nbsp; ${cmtopen}
					
					<a	href="sortByUsername?sortbyU=${sortbyU}"><svg
								xmlns="http://www.w3.org/2000/svg" width="16" height="16"
								fill="currentColor" class="bi bi-arrow-down-up"
								viewBox="0 0 16 16">
  <path fill-rule="evenodd"
									d="M11.5 15a.5.5 0 0 0 .5-.5V2.707l3.146 3.147a.5.5 0 0 0 .708-.708l-4-4a.5.5 0 0 0-.708 0l-4 4a.5.5 0 1 0 .708.708L11 2.707V14.5a.5.5 0 0 0 .5.5m-7-14a.5.5 0 0 1 .5.5v11.793l3.146-3.147a.5.5 0 0 1 .708.708l-4 4a.5.5 0 0 1-.708 0l-4-4a.5.5 0 0 1 .708-.708L4 13.293V1.5a.5.5 0 0 1 .5-.5" />
</svg></a>

${cmtclose}
</th>
					<th width="150">Password</th>
					<th width="200">Email</th>
					<th width="80">Gender</th>
					<th width="200">Recorded</th>
					
					<th width="100">Action</th>
					${cmtopen}<th width="100">Role</th>${cmtclose}
				</tr>
			</thead>
			<tbody>
				<c:forEach var="item" items="${crosscheck}">

					<tr>
						<td align="left">${item.first_name} ${item.last_name}</td>
						<td align="center">${item.DOB_month}${item.DOB_day},
							${item.DOB_year}</td>
						<td align="center">${item.username}</td>
						<td align="center">${item.password}</td>
						<td align="center">${item.email}</td>
						<td align="center">${item.gender}</td>
						<td align="center">${item.timestamp}</td>
						
						<td>
						${cmtopen}
						<a href="deleteSignup?uname=${item.username}">
								<button type="button" class="btn btn-danger">Delete</button>
						</a> 
						${cmtclose}
						${ucmtopen}
						<a href="ueditSignup?xname=${item.username}">
								<button type="button" class="btn btn-primary">Edit</button>
						</a>
						${ucmtclose}
						${cmtopen}
						<a href="editSignup?xname=${item.username}">
								<button type="button" class="btn btn-primary">Edit</button>
						</a>
						${cmtclose}
						
						</td>
						${cmtopen}<th align="center">${item.role}</th>${cmtclose}
					</tr>
				</c:forEach>

			</tbody>
		</table>
		</form>
		<p></p>
		<div align="center">
			<a href="login">
				<button type="button" class="btn btn-warning">LOGOUT</button>
			</a>
			
				
		</div>
	</div>
</body>
</html>
