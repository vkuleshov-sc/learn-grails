package testgrails

import grails.transaction.Transactional

@Transactional
class UserService {
    static final PAGE_SIZE = 5

    static def getUserList(String userName, String pokemonName, Integer page) {
        def criteria = User.createCriteria()
        def userList = criteria.list(max: PAGE_SIZE, offset: PAGE_SIZE * (page - 1)) {
            if (userName) {
                like("name", userName.replaceAll(/\*/, "%"))
            }
            if (pokemonName) {
                pokemons {
                    like('name', pokemonName.replaceAll(/\*/, "%"))
                }
            }
        }
        def pageAmount = Math.ceil(User.createCriteria().list {
            if (userName) {
                like("name", userName.replaceAll(/\*/, "%"))
            }
            if (pokemonName) {
                pokemons {
                    like('name', pokemonName.replaceAll(/\*/, "%"))
                }
            }
        }.size() / PAGE_SIZE)
        return [userList: userList, pageAmount: pageAmount]
    }
}