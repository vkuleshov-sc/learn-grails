package testgrails

import grails.transaction.Transactional

@Transactional
class PokemonService {

    def getList(Map params) {
        return Pokemon.createCriteria().list {
            if (params.name) {
                ilike("name", params.name.replaceAll(/\*/, "%").trim())
            }
        }
    }

    def get(Serializable id) {
        return Pokemon.get(id)
    }
}
