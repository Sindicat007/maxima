<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Список книг</title>
</head>
<body>

<h1>Books list</h1>
<table>
<tr>
<th>ID</th>
<th>Name</th>
</tr>
<c:forEach var="book" items="${books}">
<tr>
<td>${book.id}}</td>
<td>${book.name}</td>
</tr>
</c:forEach>
</table>
<br>
<a href="${pageContext.request.contextPath}/book/getFormForAddingBooks">Add new book</a>

</body>
</html>