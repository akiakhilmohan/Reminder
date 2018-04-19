<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="v" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>View</title>
</head>
<body>
<table>
				<thead>
					<tr>
						<th>ID</th>
						<th>Content</th>
						<th>Remind Date</th>
						<th>Remind Time</th>
						<th>Saved Date</th>
					</tr>
				</thead>
				<v:forEach var="v" items="${label}">
					<tr>

						<td>${v.id}</td>
						<td>${v.content1}</td>
						<td>${v.remind_date}</td>
						<td>${v.remind_time}</td>
						<td>${v.current}</td>
						</tr>
						</v:forEach>
						</table>
</body>
</html>