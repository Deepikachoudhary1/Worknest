<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Admin Dashboard</title>
    <link rel="stylesheet" href="../resources/css/style.css">
</head>
<body>
<div class="container">
    <div class="nav">
        <a href="../admin/users">Manage Users</a>
        <a href="../admin/tasks">Tasks</a>
        <a href="../logout">Logout</a>
    </div>
    <h2>Admin Dashboard</h2>
    <div class="dashboard">
        <div class="card"><h3>Pending</h3><p>${pendingCount}</p></div>
        <div class="card"><h3>In Progress</h3><p>${inProgressCount}</p></div>
        <div class="card"><h3>Completed</h3><p>${completedCount}</p></div>
        <div class="card delayed"><h3>Delayed</h3><p>${delayedCount}</p></div>
    </div>
</div>
</body>
</html>
