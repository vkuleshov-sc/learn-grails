package testgrails

import grails.transaction.Transactional
import org.apache.commons.logging.Log
import org.apache.commons.logging.LogFactory

import java.text.SimpleDateFormat

@Transactional
class UserService {
    final PAGE_SIZE = 5
    final DATE_FORMAT = new SimpleDateFormat('yyyy-MM-dd')
    static final Log log = LogFactory.getLog(this)

    def getUserList(String userName, String pokemonName, def dateFrom, def dateTo, Integer page) {
        def criteria = User.createCriteria()
        def userList = criteria.list(max: PAGE_SIZE, offset: PAGE_SIZE * (page - 1)) {
            if (userName) {
                ilike("name", userName.replaceAll(/\*/, "%").trim())
            }
            if (pokemonName) {
                pokemons {
                    ilike('name', pokemonName.replaceAll(/\*/, "%").trim())
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
                ilike("name", userName.replaceAll(/\*/, "%").trim())
            }
            if (pokemonName) {
                pokemons {
                    ilike('name', pokemonName.replaceAll(/\*/, "%").trim())
                }
            }
            if (dateFrom) {
                ge('birthday', DATE_FORMAT.parse(dateFrom))
            }
            if (dateTo) {
                le('birthday', DATE_FORMAT.parse(dateTo))
            }
        }.size() / PAGE_SIZE)
        log.info("Users amount: ${userList.size()}")
        return [userList: userList.each({ user ->
            user.pokemons = user.pokemons.sort({ p1, p2 -> p1.name <=> p2.name })
        }), pageAmount  : pageAmount]
    }
}