<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Allocate Task</title>
    <link rel="stylesheet" href="../resources/css/style.css">
</head>
<body>
<div class="container">
    <div class="nav">
        <a href="../admin/dashboard">Dashboard</a>
        <a href="../admin/users">Users</a>
        <a href="../logout">Logout</a>
    </div>
    <h2>Allocate Task</h2>
    <form action="../admin/tasks/save" method="post">
        <label>Title</label>
        <input type="text" name="title" required>
        <label>Description</label>
        <textarea name="description" required></textarea>
        <label>Assign To</label>
        <select name="userId">
            <c:forEach var="u" items="${users}">
                <option value="${u.id}">${u.username}</option>
            </c:forEach>
        </select>
        <label>Start Date</label>
        <input type="date" name="startDate" required>
        <label>Due Date</label>
        <input type="date" name="dueDate" required>
        <button type="submit">Save Task</button>
    </form>

    <h3>All Tasks</h3>
    <table class="task-table">
        <tr><th>ID</th><th>Title</th><th>User</th><th>Status</th><th>Due</th><th>Comments</th></tr>
        <c:forEach var="t" items="${tasks}">
            <tr>
                <td>${t.id}</td>
                <td>${t.title}</td>
                <td>${t.assignedUser.username}</td>
                <td>${t.status}</td>
                <td>${t.dueDate}</td>
                <td><a href="../admin/tasks/${t.id}/comments">View</a></td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
