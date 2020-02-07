<g:if test="${userList}">
    <table class="table table-bordered">
        <thead>
        <tr>
            <th><g:message code="user.name"/></th>
            <th><g:message code="user.birthday"/></th>
            <th><g:message code="user.pokemons"/></th>
            <th><g:message code="user.actions"/></th>
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
                <td>
                    <g:link controller="user" action="edit" params="${[id: user.id]}">
                        <g:message code="user.actions.edit"/>
                    </g:link>
                </td>
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
<script>
  document.getElementById('pagination').querySelectorAll('button').forEach(btn => {
    btn.addEventListener('click', (e) => {
      document.getElementById('filter').page.value = e.target.innerHTML;
      document.getElementById('filter-button').click();
      document.getElementById('filter').page.value = 1;
    })
  })
</script>
