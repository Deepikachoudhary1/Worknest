<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Register</title>
    <link rel="stylesheet" href="resources/css/style.css">
</head>
<body>
<div class="container small">
    <h2>Register</h2>
    <c:if test="${not empty success}"><div class="success">${success}</div></c:if>
    <form method="post" action="register">
        <label>Username</label>
        <input type="text" name="username" required>
        <label>Password</label>
        <input type="password" name="password" required>
        <label>Role</label>
        <select name="role">
            <option value="USER">USER</option>
            <option value="ADMIN">ADMIN</option>
        </select>
        <button type="submit">Register</button>
    </form>
    <p>Already registered? <a href="login">Login</a></p>
</div>
</body>
</html>
