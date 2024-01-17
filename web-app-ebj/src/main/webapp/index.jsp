<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Hola mundo EJB</title>
</head>
<body>
    <h1>Hola mundo desde EJB</h1>
    <h3>${message}</h3>
    <h3>${message2}</h3>

    <ul>
        <c:forEach items="${listado}" var="item">
            <li>${item}</li>
        </c:forEach>
    </ul>

</body>
</html>