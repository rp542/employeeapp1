<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<title>Employee Details</title>
</head>
<body bgcolor="pink">
	<h1>Employee Details</h1>
	<hr>
	<h3>
		<table border="1" cellspacing="5" cellpadding="5">
			<thead>
				<tr>
					<th>Employee Id</th>
					<th>Employee Name</th>
					<th>Employee Department</th>
					<th>Employee Salary</th>
					<th>Edit</th>
					<th>Delete</th>
				</tr>
			</thead>
			<tbody>
				
					<tr>
						<td>${employee.employeeId}</td>
						<td>${employee.employeeName}</td>
						<td>${employee.employeeDepartment}</td>
						<td>${employee.employeeSalary}</td>
						<td><a href="editEmployeePage/${employee.employeeId}">Edit</a></td>
						<td><a href="deleteEmployee/${employee.employeeId}">Delete</a></td>
					</tr>
				
			</tbody>
		</table>
	</h3>
</body>
</html>