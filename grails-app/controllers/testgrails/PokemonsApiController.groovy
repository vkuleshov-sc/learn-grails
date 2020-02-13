package testgrails

import grails.converters.JSON
import grails.rest.RestfulController
import models.Pokemon

class PokemonsApiController extends RestfulController {
    def pokemonService

    PokemonsApiController() {
        super(Pokemon)
    }

    def index() {
        render pokemonService.getList(params.name) as JSON
    }

    def get() {
        render pokemonService.get(Integer.parseInt(params.id)) as JSON
    }
}
