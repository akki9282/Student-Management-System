<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%-- <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home</title>

<style type="text/css">


.button-31 {
  background-color: #222;
  border-radius: 4px;
  border-style: none;
  box-sizing: border-box;
  color: #fff;
  cursor: pointer;
  display: inline-block;
  font-family: "Farfetch Basis","Helvetica Neue",Arial,sans-serif;
  font-size: 16px;
  font-weight: 50;
  line-height: 1.5;
  margin: 0;
  max-width: none;
  min-height: 40px;
  min-width: 40px;
  outline: none;
  overflow: hidden;
/*   padding: 9px 20px 8px; */
  position: absolute;
  text-align: center;
  text-transform: none;
  user-select: none;
  -webkit-user-select: none;
  touch-action: manipulation;
  width: 10%;
  top: 2%;
  right: 2%;
}

.button-31:hover {
  opacity: .75;
}

.button:hover,
.button:focus {
  opacity: .90;
  cursor: pointer;
}
#upd{

margin-top: 5%;

}
#del{
margin-top: 10%;
}

#logOut{
margin-top: 15%}
html,
body {
	height: 100%;
}

body {
	margin: 0;
	background: linear-gradient(45deg, #49a09d, #5f2c82);
	font-family: sans-serif;
	font-weight: 100;
}

.container {
	position: absolute;
	height:450px;
	top: 50%;
	left: 50%;
	transform: translate(-50%, -50%);
}

table {
	width: 800px;
	border-collapse: collapse;
	overflow: hidden;
	box-shadow: 0 0 20px rgba(0,0,0,0.1);
}

th,
td {
	padding: 15px;
	background-color: rgba(255,255,255,0.2);
	color: #fff;
}

th {
	text-align: left;
}

thead {
	th {
		background-color: #55608f;
	}
}

tbody {
	tr {
		&:hover {
			background-color: rgba(255,255,255,0.3);
		}
	}
	td {
		position: relative;
		&:hover {
			&:before {
				content: "";
				position: absolute;
				left: 0;
				right: 0;
				top: -9999px;
				bottom: -9999px;
				background-color: rgba(255,255,255,0.2);
				z-index: -1;
			}
		}
	}
}
</style>
</head>
<body>
	<%
	List<Object[]> list = (List<Object[]>) request.getAttribute("list");
	%>

	<div class="container" style="overflow-x:auto;" >
		<table>
		<thead>
		<tr>
			<th>Student ID</th>
			<th>Student Name</th>
			<th>Department</th>
			<th>Admin ID</th>
			</tr>
			</thead>
			<tbody>
			<%
			for (Object[] obj : list) {
			%>
			<tr>
			<td><% out.print(obj[0]); %> </td>
			<td><% out.print(obj[1]); %> </td>	
			<td><% out.print(obj[2]); %> </td>	
			<td><% out.print(obj[3]); %> </td>
			</tr>
			<%} %>
			</tbody>
		</table>
	</div>
	
	<div>
	<a href="callAddStudent"><button class="button-31" role="button">Add Student</button>
	</a>
	<a href="updateStudent"><button class="button-31" role="button" id="upd">Update Student</button>
	</a>
	<a href="deleteStudent"><button class="button-31" role="button" id="del">Delete Student</button>
	</a>
	<a href="login"><button class="button-31" role="button" id="logOut">Log Out</button>
	</a>
	</div>
</body>
</html>