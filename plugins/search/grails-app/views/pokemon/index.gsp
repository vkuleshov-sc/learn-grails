<%@ page import="models.Pokemon" %>
<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main">
    <g:set var="entityName" value="${message(code: 'pokemon.label', default: 'Pokemon')}"/>
    <title><g:message code="default.list.label" args="[entityName]"/></title>
    <link rel="stylesheet" href="<g:createLinkTo dir="css" file="main.css"/>"/>
    <link rel="stylesheet" href="<g:createLinkTo dir="css" file="errors.css"/>"/>
    <link rel="stylesheet" href="<g:createLinkTo dir="css" file="mobile.css"/>"/>
</head>

<body>
<a href="#list-pokemon" class="skip" tabindex="-1"><g:message code="default.link.skip.label"
                                                              default="Skip to content&hellip;"/></a>

<div class="nav" role="navigation">
    <ul>
        <li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
        <li><g:link class="create" action="create"><g:message code="default.new.label"
                                                              args="[entityName]"/></g:link></li>
    </ul>
</div>

<div id="list-pokemon" class="content scaffold-list" role="main">
    <h1><g:message code="default.list.label" args="[entityName]"/></h1>
    <g:if test="${flash.message}">
        <div class="message" role="status">${flash.message}</div>
    </g:if>
    <table>
        <thead>
        <tr>

            <g:sortableColumn property="name" title="${message(code: 'pokemon.name.label', default: 'Name')}"/>

            <th><g:message code="pokemon.user.label" default="User"/></th>

        </tr>
        </thead>
        <tbody>
        <g:each in="${pokemonInstanceList}" status="i" var="pokemonInstance">
            <tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
                <td><g:link action="show"
                            id="${pokemonInstance.id}">${fieldValue(bean: pokemonInstance, field: "name")}</g:link></td>

            </tr>
        </g:each>
        </tbody>
    </table>

    <div class="pagination">
        <g:paginate total="${pokemonInstanceCount ?: 0}"/>
    </div>
</div>
</body>
</html>
