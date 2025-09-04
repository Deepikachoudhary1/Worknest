<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Manage Users</title>
    <link rel="stylesheet" href="../resources/css/style.css">
</head>
<body>
<div class="container">
    <div class="nav">
        <a href="../admin/dashboard">Dashboard</a>
        <a href="../admin/tasks">Tasks</a>
        <a href="../logout">Logout</a>
    </div>
    <h2>Users</h2>
    <p><a class="btn" href="../admin/users/add">Add New User</a></p>
    <table class="task-table">
        <tr><th>ID</th><th>Username</th><th>Role</th><th>Actions</th></tr>
        <c:forEach var="u" items="${users}">
            <tr>
                <td>${u.id}</td>
                <td>${u.username}</td>
                <td>${u.role}</td>
                <td>
                    <a href="../admin/users/edit/${u.id}">Edit</a> |
                    <a href="../admin/users/delete/${u.id}">Delete</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
