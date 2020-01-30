<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>User list</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
          integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
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
    <form id="filter">
        <input name="userNameFilter" placeholder="User name" type="text" value="${userNameFilter ?: ""}"/>
        <input name="pokemonNameFilter" placeholder="Pokemon name" type="text" value="${pokemonNameFilter ?: ""}"/>
        <input name="dateFromFilter" placeholder="Date from" type="date" value="${dateFromFilter ?: ""}"/>
        <input name="dateToFilter" placeholder="Date to" type="date" value="${dateToFilter ?: ""}"/>
        <input name="page" type="number" value="${pageNum ?: 1}" hidden/>
        <button type="submit">Filter</button>
    </form>
    <g:if test="${errors}">
        <ol>
            <g:each var="error" in="${errors}">
                <li>${error}</li>
            </g:each>
        </ol>
    </g:if>
    <g:if test="${userList}">
        <table class="table table-bordered">
            <thead>
            <tr>
                <th>Name</th>
                <th>Birthday</th>
                <th>Pokemons</th>
                <th>Actions</th>
            </tr>
            </thead>
            <tbody>
            <g:each var="user" in="${userList}">
                <tr>
                    <td>${user.name}</td>
                    <td>(${user.birthday.format("dd.MM.yyyy")})</td>
                    <td>
                        <ol class="pokemons-list">
                            <g:each var="pokemon" in="${user.pokemons}">
                                <li>${pokemon.name}</li>
                            </g:each>
                        </ol>
                    </td>
                    <td><g:link controller="user" action="edit" params="${[id: user.id]}">Edit</g:link></td>
                </tr>
            </g:each>
            </tbody>
        </table>
    </g:if>
    <g:if test="${pageAmount > 1}">
        <div id="pagination">
            <g:each var="num" in="${(1..pageAmount)}">
                <button>${num}</button>
            </g:each>
        </div>
    </g:if>
</main>
<g:applyLayout name="footer"/>
<script>
  document.getElementById('pagination').querySelectorAll('button').forEach(btn => {
    btn.addEventListener('click', (e) => {
      document.getElementById('filter').page.value = e.target.innerHTML
      document.getElementById('filter').submit()
    })
  })
</script>
</body>
</html>