package testgrails

import commands.UserCommand
import grails.orm.HibernateCriteriaBuilder
import models.User

class UserService {
    private static final PAGE_SIZE = 5

    def criteriaQuery = { HibernateCriteriaBuilder criteria, UserCommand userCommand ->
        criteria.projections {
            criteria.groupProperty('id')
        }
        if (userCommand.userNameFilter) {
            criteria.ilike("name", userCommand.userNameFilter)
        }
        if (userCommand.dateFromFilter) {
            criteria.ge('birthday', userCommand.dateFromFilter)
        }
        if (userCommand.dateToFilter) {
            criteria.le('birthday', userCommand.dateToFilter)
        }
        if (userCommand.pokemonNameFilter) {
            criteria.createAlias('pokemons', 'pokemons')
            criteria.ilike('pokemons.name', userCommand.pokemonNameFilter)
        }
    }

    def getUserList(UserCommand userCommand) {
        HibernateCriteriaBuilder criteria = User.createCriteria()
        def userList = criteria.list(max: PAGE_SIZE, offset: (userCommand.page - 1) * PAGE_SIZE) {
            criteriaQuery(criteria, userCommand)
        }.collect { id -> User.get(id) }
        return userList.each { user ->
            user.pokemons = user.pokemons.sort({ p1, p2 -> p1.name <=> p2.name })
        }
    }

    def getPageAmount(UserCommand userCommand) {
        HibernateCriteriaBuilder criteria = User.createCriteria()
        int userCount = criteria.list {
            criteriaQuery(criteria, userCommand)
        }.size()
        log.info("User total amount: ${userCount}")
        return Math.ceil(userCount / PAGE_SIZE)
    }
}