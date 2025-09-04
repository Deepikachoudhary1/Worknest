<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>My Tasks</title>
    <link rel="stylesheet" href="../resources/css/style.css">
    <script src="../resources/js/app.js"></script>
</head>
<body>
<div class="container">
    <div class="nav">
        <a href="../logout">Logout</a>
    </div>
    <h2>My Tasks</h2>
    <table class="task-table">
        <tr><th>Title</th><th>Description</th><th>Status</th><th>Due</th><th>Actions</th></tr>
        <c:forEach var="task" items="${tasks}">
            <tr>
                <td>${task.title}</td>
                <td>${task.description}</td>
                <td>${task.status}</td>
                <td>${task.dueDate}</td>
                <td>
                    <form method="post" action="../user/tasks/updateStatus" class="inline">
                        <input type="hidden" name="taskId" value="${task.id}" />
                        <select name="status">
                            <option value="IN_PROGRESS">In Progress</option>
                            <option value="COMPLETED">Completed</option>
                        </select>
                        <button type="submit">Update</button>
                    </form>
                    <form method="post" action="../user/tasks/addComment" class="inline">
                        <input type="hidden" name="taskId" value="${task.id}" />
                        <input type="text" name="commentText" placeholder="Add comment..." required />
                        <button type="submit">Add</button>
                    </form>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
