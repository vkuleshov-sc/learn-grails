<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>User list</title>
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
    <g:formRemote name="filter" id="filter" url="[controller: 'search', action: 'list']" update="to-update">
        <input name="userNameFilter" placeholder="${message(code: 'user.userName')}" type="text"
               value="${userNameFilter ?: ""}"/>
        <input name="pokemonNameFilter" placeholder="${message(code: 'user.pokemonName')}" type="text"
               value="${pokemonNameFilter ?: ""}"/>
        <input name="dateFromFilter" type="date" value="${dateFromFilter ?: ""}"/>
        <input name="dateToFilter" type="date" value="${dateToFilter ?: ""}"/>
        <input name="page" type="number" value="${pageNum ?: 1}" hidden/>
        <button id="filter-button" type="submit">Filter</button>
    </g:formRemote>
    <div id="to-update"></div>
</main>
<script>
  document.getElementById('filter-button').click()
</script>
<g:applyLayout name="footer"/>
</body>
</html>