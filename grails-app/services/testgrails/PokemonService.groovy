package testgrails

import utils.DataFormatter

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
