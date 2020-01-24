<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>User list</title>
</head>

<body>
<form id="filter">
    <input name="userName" placeholder="User name" type="text" value="${userName ?: ""}" />
    <input name="pokemonName" placeholder="Pokemon name" type="text" value="${pokemonName ?: ""}"/>
    <input name="page" type="number" value="${pageNum ?: 1}" hidden/>
    <button type="submit">Filter</button>
</form>
<ul>
    <g:each var="user" in="${userList}">
        <li>
            <p>${user.name} (${user.birthday})</p>

            <p>Pokemons:</p>
            <ul>
                <g:each var="pokemon" in="${user.pokemons}">
                    <li>
                        <h5>${pokemon.name}</h5>
                    </li>
                </g:each>
            </ul>
        </li>
    </g:each>
</ul>

<div id="pagination">
    <button>1</button>
    <button>2</button>
    <button>3</button>
</div>
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