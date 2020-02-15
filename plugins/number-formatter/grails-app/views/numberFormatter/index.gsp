<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Binding Data + i18n</title>
    <style>
    body {
        margin: 0;
    }

    main {
        margin: 12px;
    }
    </style>
</head>

<body>
<g:applyLayout name="header"/>
<main>
    <ul>
        <li><g:message code="numberFormatter.test1.label"/></li>
        <li><g:message code="numberFormatter.test2.label"/></li>
        <li><g:message code="numberFormatter.test3.label"/></li>
        <li><g:message code="numberFormatter.test4.label"/></li>
        <li><g:message code="numberFormatter.test5.label"/></li>
        <li><g:message code="numberFormatter.test6.label"/></li>
    </ul>

    <g:form action="getValue" controller="numberFormatter" id="form1">
        <input name="value" type="text">
        <button type="submit"><g:message code="actions.submit"/></button>
        <g:if test="${answer}">
            <g:textField name="myField" value="${answer}"/>
        </g:if>
    </g:form>
</main>
<g:applyLayout name="footer"/>
</body>
</html>