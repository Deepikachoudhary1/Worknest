<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Login</title>
    <link rel="stylesheet" href="resources/css/style.css">
</head>
<body>
<div class="container small">
    <h2>Login</h2>
    <c:if test="${not empty error}"><div class="alert">${error}</div></c:if>
    <form method="post" action="login">
        <label>Username</label>
        <input type="text" name="username" required>
        <label>Password</label>
        <input type="password" name="password" required>
        <button type="submit">Login</button>
    </form>
    <p>No account? <a href="register">Register</a></p>
</div>
</body>
</html>
