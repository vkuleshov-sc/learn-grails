package testgrails

import grails.transaction.Transactional

import java.text.SimpleDateFormat

@Transactional
class UserService {
    final PAGE_SIZE = 5
    final DATE_FORMAT = new SimpleDateFormat('yyyy-MM-dd')

    def getUserList(String userName, String pokemonName, def dateFrom, def dateTo, Integer page) {
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
            if (dateFrom) {
                ge('birthday', DATE_FORMAT.parse(dateFrom))
            }
            if (dateTo) {
                le('birthday', DATE_FORMAT.parse(dateTo))
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
            if (dateFrom) {
                ge('birthday', DATE_FORMAT.parse(dateFrom))
            }
            if (dateTo) {
                le('birthday', DATE_FORMAT.parse(dateTo))
            }
        }.size() / PAGE_SIZE)
        return [userList: userList, pageAmount: pageAmount]
    }
}