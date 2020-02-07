<%--
  Created by IntelliJ IDEA.
  User: kuleshov
  Date: 1/27/2020
  Time: 5:07 PM
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title></title>
</head>
<style>
.login-form {
    margin-top: 12px;
}
</style>

<body>
<g:applyLayout name="header"/>
<form class="login-form" method="post">
    <input type="text" name="name" placeholder="Login"/>
    <input type="password" name="password" placeholder="Password"/>
    <button>
        <g:message code="actions.logIn"/>
    </button>

    <div>
        ${message}
    </div>
</form>
<g:applyLayout name="footer"/>
</body>
</html>