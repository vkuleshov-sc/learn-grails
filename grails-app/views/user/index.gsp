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
    <form id="filter">
        <input name="userNameFilter" placeholder="User name" type="text" value="${userNameFilter ?: ""}"/>
        <input name="pokemonNameFilter" placeholder="Pokemon name" type="text" value="${pokemonNameFilter ?: ""}"/>
        <input name="page" type="number" value="${pageNum ?: 1}" hidden/>
        <button type="submit">Filter</button>
    </form>
    <ul>
        <g:each var="user" in="${userList}">
            <li>
                <p>${user.name} (${user.birthday.format("dd.MM.yyyy")})</p>

                <p>Pokemons:</p>
                <ol class="pokemons-list">
                    <g:each var="pokemon" in="${user.pokemons}">
                        <li>
                            <h5>${pokemon.name}</h5>
                        </li>
                    </g:each>
                </ol>
            </li>
        </g:each>
    </ul>

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