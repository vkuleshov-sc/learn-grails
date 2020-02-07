package testgrails

import commands.UserCommand
import grails.transaction.Transactional

@Transactional
class UserService {
    static final PAGE_SIZE = 5

    def criteriaClosure = { ilike, ge, le, userName, dateFrom, dateTo ->
        if (userName) {
            ilike("name", userName)
        }
        if (dateFrom) {
            ge('birthday', dateFrom)
        }
        if (dateTo) {
            le('birthday', dateTo)
        }
    }

    def getUserList(UserCommand params) {
        def criteria = User.createCriteria()
        def userList = criteria.list {
            projections {
                groupProperty('id')
            }
            criteriaClosure(criteria.&ilike, criteria.&ge, criteria.&le,
                params.userNameFilter, params.dateFromFilter, params.dateToFilter)
            if (params.pokemonNameFilter) {
                pokemons {
                    ilike('name', params.pokemonNameFilter)
                }
            }
            firstResult(params.page ? (params.page - 1) * PAGE_SIZE : 0)
            maxResults(PAGE_SIZE)
        }.collect { id -> User.get(id) }
        criteria = User.createCriteria()
        def userCount = criteria.list {
            projections {
                countDistinct('id')
            }
            criteriaClosure(criteria.&ilike, criteria.&ge, criteria.&le,
                params.userNameFilter, params.dateFromFilter, params.dateToFilter)
            if (params.pokemonNameFilter) {
                pokemons {
                    ilike('name', params.pokemonNameFilter)
                }
            }
        }[0]
        log.info("User total amount: ${userCount}")
        return [userList: userList.each({ user ->
            user.pokemons = user.pokemons.sort({ p1, p2 -> p1.name <=> p2.name })
        }), pageAmount  : Math.ceil(userCount / PAGE_SIZE)]
    }
}