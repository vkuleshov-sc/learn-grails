<g:if test="${errors}">
    <ol>
        <g:each var="error" in="${errors}">
            <li>${error}</li>
        </g:each>
    </ol>
</g:if>