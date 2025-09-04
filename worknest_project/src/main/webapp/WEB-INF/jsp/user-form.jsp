<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>User Form</title>
    <link rel="stylesheet" href="../resources/css/style.css">
</head>
<body>
<div class="container small">
    <h2>User</h2>
    <form method="post" action="../users/save">
        <input type="hidden" name="id" value="${u.id}"/>
        <label>Username</label>
        <input type="text" name="username" value="${u.username}" required>
        <label>Password</label>
        <input type="text" name="password" value="${u.password}" required>
        <label>Role</label>
        <select name="role">
            <option ${u.role == 'USER' ? 'selected' : ''}>USER</option>
            <option ${u.role == 'ADMIN' ? 'selected' : ''}>ADMIN</option>
        </select>
        <button type="submit">Save</button>
        <a class="btn" href="../users">Cancel</a>
    </form>
</div>
</body>
</html>
