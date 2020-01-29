<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Binding Data + i18n</title>
</head>

<body>
<h3>
    Binding Data + i18n
</h3>
<button><a href="?lang=en">EN</a></button>
<button><a href="?lang=de">DE</a></button>
<ul>
    <li><g:message code="task3.test1.label"/></li>
    <li><g:message code="task3.test2.label"/></li>
    <li><g:message code="task3.test3.label"/></li>
    <li><g:message code="task3.test4.label"/></li>
    <li><g:message code="task3.test5.label"/></li>
    <li><g:message code="task3.test6.label"/></li>
</ul>

<form action="task3/getValue" id="form1">
    <input name="value" type="text">
    <button type="submit">Submit</button>
    <input name="lang" hidden type="text"/>
    <g:if test="${params.answer}">
        <g:textField name="myField" value="${params.answer}"/>
    </g:if>
</form>
<script>
  document.getElementById('form1').addEventListener('submit', (e) => {
    e.target.children.lang.value = new URL(location.href).searchParams.get('lang')
  })
</script>
</body>
</html>