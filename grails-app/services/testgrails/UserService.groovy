package testgrails

import grails.transaction.Transactional

@Transactional
class UserService {
    static final PAGE_SIZE = 5

    static def getUserList(String userName, String pokemonName) {
        User.withCriteria {
            if (userName) {
                like("name", userName.replaceAll(/\*/, "%"))
            }
        }
    }
}