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
    <g:javascript library="jquery" plugin="jquery"/>
</head>

<body>
<g:applyLayout name="header"/>
<main>
    <g:formRemote name="filter" id="filter" url="[controller: 'user', action: 'list']" update="to-update">
        <input name="userNameFilter" placeholder="User name" type="text" value="${userNameFilter ?: ""}"/>
        <input name="pokemonNameFilter" placeholder="Pokemon name" type="text" value="${pokemonNameFilter ?: ""}"/>
        <input name="dateFromFilter" placeholder="Date from" type="date" value="${dateFromFilter ?: ""}"/>
        <input name="dateToFilter" placeholder="Date to" type="date" value="${dateToFilter ?: ""}"/>
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