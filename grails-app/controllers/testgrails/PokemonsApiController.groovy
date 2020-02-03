package testgrails

import grails.rest.RestfulController

class PokemonsApiController extends RestfulController {
    static responseFormats = ['json', 'xml']
    def pokemonService

    PokemonsApiController() {
        super(Pokemon)
    }

    def index() {
        respond(pokemonService.getList(params))
    }

    def get() {
        respond pokemonService.get(params.id)
    }
}
