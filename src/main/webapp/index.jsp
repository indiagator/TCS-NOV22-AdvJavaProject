<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
    <title>JSP - Hello World</title>
</head>
<body>
<h1><%= "TCS Cross Border Trade App" %>
</h1>
<br/>

<div>
    <h3>Login Form</h3>
    <form action="login-servlet" method="post">
        <input type="text" name="username"  placeholder="USERNAME">
        <input type="password" name="password"  placeholder="PASSWORD">
        <input type="submit" value="LOGIN">
    </form>
</div>

<div>
    <h3>Signup Form</h3>
    <form action="signup-servlet" method="post">
        <input type="text" name="username"  placeholder="USERNAME">
        <input type="password" name="password"  placeholder="PASSWORD">
        <input type="submit" value="SIGNUP">
    </form>
</div>

</body>
</html>