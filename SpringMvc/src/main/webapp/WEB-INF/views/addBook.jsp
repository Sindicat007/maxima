<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Добавление книги</title>
</head>
<body>

<h1>Добавить книгу ${book}!</h1>
<br>
   <form action="${pageContext.request.contextPath}/add" method="post">
       <label for="name">Название книги</label>
       <input type="text" id="name" name="name" required>
       <input type="submit" value="Add Book">
   </form>
   <br>
   <a href="${pageContext.request.contextPath}/showBooks">Back to Books List</a>
</body>
</html>
