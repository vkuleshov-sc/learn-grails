<%@ page import="testgrails.Pokemon" %>



<div class="fieldcontain ${hasErrors(bean: pokemonInstance, field: 'name', 'error')} required">
	<label for="name">
		<g:message code="pokemon.name.label" default="Name" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="name" required="" value="${pokemonInstance?.name}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: pokemonInstance, field: 'user', 'error')} required">
	<label for="user">
		<g:message code="pokemon.user.label" default="User" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="user" name="user.id" from="${testgrails.User.list()}" optionKey="id" required="" value="${pokemonInstance?.user?.id}" class="many-to-one"/>

</div>

