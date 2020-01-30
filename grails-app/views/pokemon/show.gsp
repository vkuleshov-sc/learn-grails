<%@ page import="testgrails.Pokemon" %>
<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main">
    <g:set var="entityName" value="${message(code: 'pokemon.label', default: 'Pokemon')}"/>
    <title><g:message code="default.show.label" args="[entityName]"/></title>
    <link rel="stylesheet" href="<g:createLinkTo dir="css" file="main.css"/>"/>
    <link rel="stylesheet" href="<g:createLinkTo dir="css" file="errors.css"/>"/>
    <link rel="stylesheet" href="<g:createLinkTo dir="css" file="mobile.css"/>"/>
</head>

<body>
<a href="#show-pokemon" class="skip" tabindex="-1"><g:message code="default.link.skip.label"
                                                              default="Skip to content&hellip;"/></a>

<div class="nav" role="navigation">
    <ul>
        <li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
        <li><g:link class="list" action="index"><g:message code="default.list.label" args="[entityName]"/></g:link></li>
        <li><g:link class="create" action="create"><g:message code="default.new.label"
                                                              args="[entityName]"/></g:link></li>
    </ul>
</div>

<div id="show-pokemon" class="content scaffold-show" role="main">
    <h1><g:message code="default.show.label" args="[entityName]"/></h1>
    <g:if test="${flash.message}">
        <div class="message" role="status">${flash.message}</div>
    </g:if>
    <ol class="property-list pokemon">

        <g:if test="${pokemonInstance?.name}">
            <li class="fieldcontain">
                <span id="name-label" class="property-label"><g:message code="pokemon.name.label"
                                                                        default="Name"/></span>

                <span class="property-value" aria-labelledby="name-label"><g:fieldValue bean="${pokemonInstance}"
                                                                                        field="name"/></span>

            </li>
        </g:if>

        <g:if test="${pokemonInstance?.user}">
            <li class="fieldcontain">
                <span id="user-label" class="property-label"><g:message code="pokemon.user.label"
                                                                        default="User"/></span>

                <span class="property-value" aria-labelledby="user-label"><g:link controller="user" action="show"
                                                                                  id="${pokemonInstance?.user?.id}">${pokemonInstance?.user?.encodeAsHTML()}</g:link></span>

            </li>
        </g:if>

    </ol>
    <g:form url="[resource: pokemonInstance, action: 'delete']" method="DELETE">
        <fieldset class="buttons">
            <g:link class="edit" action="edit" resource="${pokemonInstance}"><g:message code="default.button.edit.label"
                                                                                        default="Edit"/></g:link>
            <g:actionSubmit class="delete" action="delete"
                            value="${message(code: 'default.button.delete.label', default: 'Delete')}"
                            onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');"/>
        </fieldset>
    </g:form>
</div>
</body>
</html>
