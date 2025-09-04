<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Task Comments</title>
    <link rel="stylesheet" href="../resources/css/style.css">
</head>
<body>
<div class="container">
    <h2>Comments for Task: ${task.title}</h2>
    <ul class="comments">
        <c:forEach var="c" items="${comments}">
            <li><b>${c.user.username}</b> (${c.createdAt}) : ${c.text}</li>
        </c:forEach>
    </ul>
    <p><a href="../admin/tasks">Back</a></p>
</div>
</body>
</html>
