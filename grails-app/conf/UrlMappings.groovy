class UrlMappings {

    static mappings = {
        "/pokemons/v1"(resources: 'pokemon')
        "/pokemons/v2"(controller: 'pokemonsApi')
        "/pokemons/v2/${id}"(controller: 'pokemonsApi', action: 'get')
        "/$controller/$action?/$id?(.$format)?" {
            constraints {
                // apply constraints here
            }
        }
        "/"(controller: "user", action: "login")
        "500"(view: "/error")
    }
}