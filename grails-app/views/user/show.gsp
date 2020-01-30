<%@ page import="testgrails.User" %>
<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main">
    <g:set var="entityName" value="${message(code: 'user.label', default: 'User')}"/>
    <link rel="stylesheet" href="<g:createLinkTo dir="css" file="main.css"/>"/>
    <link rel="stylesheet" href="<g:createLinkTo dir="css" file="errors.css"/>"/>
    <link rel="stylesheet" href="<g:createLinkTo dir="css" file="mobile.css"/>"/>
    <title><g:message code="default.show.label" args="[entityName]"/></title>
</head>

<body>
<a href="#show-user" class="skip" tabindex="-1"><g:message code="default.link.skip.label"
                                                           default="Skip to content&hellip;"/></a>

<div class="nav" role="navigation">
    <ul>
        <li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
        <li><g:link class="list" action="index"><g:message code="default.list.label" args="[entityName]"/></g:link></li>
        <li><g:link class="create" action="create"><g:message code="default.new.label"
                                                              args="[entityName]"/></g:link></li>
    </ul>
</div>

<div id="show-user" class="content scaffold-show" role="main">
    <h1><g:message code="default.show.label" args="[entityName]"/></h1>
    <g:if test="${flash.message}">
        <div class="message" role="status">${flash.message}</div>
    </g:if>
    <ol class="property-list user">

        <g:if test="${userInstance?.birthday}">
            <li class="fieldcontain">
                <span id="birthday-label" class="property-label"><g:message code="user.birthday.label"
                                                                            default="Birthday"/></span>

                <span class="property-value" aria-labelledby="birthday-label"><g:formatDate
                        date="${userInstance?.birthday}"/></span>

            </li>
        </g:if>

        <g:if test="${userInstance?.name}">
            <li class="fieldcontain">
                <span id="name-label" class="property-label"><g:message code="user.name.label" default="Name"/></span>

                <span class="property-value" aria-labelledby="name-label"><g:fieldValue bean="${userInstance}"
                                                                                        field="name"/></span>

            </li>
        </g:if>

        <g:if test="${userInstance?.password}">
            <li class="fieldcontain">
                <span id="password-label" class="property-label"><g:message code="user.password.label"
                                                                            default="Password"/></span>

                <span class="property-value" aria-labelledby="password-label"><g:fieldValue bean="${userInstance}"
                                                                                            field="password"/></span>

            </li>
        </g:if>

        <g:if test="${userInstance?.pokemons}">
            <li class="fieldcontain">
                <span id="pokemons-label" class="property-label"><g:message code="user.pokemons.label"
                                                                            default="Pokemons"/></span>

                <g:each in="${userInstance.pokemons}" var="p">
                    <span class="property-value" aria-labelledby="pokemons-label"><g:link controller="pokemon"
                                                                                          action="show"
                                                                                          id="${p.id}">${p?.encodeAsHTML()}</g:link></span>
                </g:each>

            </li>
        </g:if>

    </ol>
    <g:form url="[resource: userInstance, action: 'delete']" method="DELETE">
        <fieldset class="buttons">
            <g:link class="edit" action="edit" resource="${userInstance}"><g:message code="default.button.edit.label"
                                                                                     default="Edit"/></g:link>
            <g:actionSubmit class="delete" action="delete"
                            value="${message(code: 'default.button.delete.label', default: 'Delete')}"
                            onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');"/>
        </fieldset>
    </g:form>
</div>
</body>
</html>
