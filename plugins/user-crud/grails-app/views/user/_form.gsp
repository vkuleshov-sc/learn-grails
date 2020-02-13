<%@ page import="models.User" %>



<div class="fieldcontain ${hasErrors(bean: userInstance, field: 'birthday', 'error')} required">
	<label for="birthday">
		<g:message code="user.birthday.label" default="Birthday" />
		<span class="required-indicator">*</span>
	</label>
	<g:datePicker name="birthday" precision="day"  value="${userInstance?.birthday}"  />

</div>

<div class="fieldcontain ${hasErrors(bean: userInstance, field: 'name', 'error')} required">
	<label for="name">
		<g:message code="user.name.label" default="Name" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="name" required="" value="${userInstance?.name}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: userInstance, field: 'password', 'error')} required">
	<label for="password">
		<g:message code="user.password.label" default="Password" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="password" required="" value="${userInstance?.password}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: userInstance, field: 'pokemons', 'error')} ">
	<label for="pokemons">
		<g:message code="user.pokemons.label" default="Pokemons" />
		
	</label>
	
<ul class="one-to-many">
<g:each in="${userInstance?.pokemons?}" var="p">
    <li><g:link controller="pokemon" action="show" id="${p.id}">${p?.encodeAsHTML()}</g:link></li>
</g:each>
<li class="add">
<g:link controller="pokemon" action="create" params="['search.id': userInstance?.id]">${message(code: 'default.add.label', args: [message(code: 'pokemon.label', default: 'Pokemon')])}</g:link>
</li>
</ul>


</div>

