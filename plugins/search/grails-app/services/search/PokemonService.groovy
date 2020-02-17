package search

import utils.DataFormatter
import models.Pokemon

class PokemonService {

    def getList(String name) {
        return Pokemon.createCriteria().list {
            if (name) {
                ilike("name", DataFormatter.getFormatName(name))
            }
        }
    }

    def get(int id) {
        return Pokemon.get(id)
    }
}
