package testgrails

import commands.UserCommand

class UserController {
    def userService
    static scaffold = true

    def index() {
        redirect(action: 'list')
    }

    def show() {
        User.get(params.id)
    }

    def list() {
        def uc = new UserCommand(
            dateToFilter: params.dateToFilter && params.dateToFilter != '' ?
                userService.DATE_FORMAT.parse(params.dateToFilter) : false,
            dateFromFilter: params.dateFromFilter && params.dateFromFilter != '' ?
                userService.DATE_FORMAT.parse(params.dateFromFilter) : false
        )
        if (uc.validate()) {
            def tmp = userService.getUserList(
                params.userNameFilter,
                params.pokemonNameFilter,
                params.dateFromFilter,
                params.dateToFilter,
                params.page ? Integer.parseInt(params.page) : 1,
            )
            render(view: 'index', model: [
                userList         : tmp.userList,
                pageAmount       : tmp.pageAmount,
                userNameFilter   : params.userNameFilter,
                pokemonNameFilter: params.pokemonNameFilter,
                dateFromFilter   : params.dateFromFilter,
                dateToFilter     : params.dateToFilter,
                page             : params.page,
                userName         : session.user.name
            ])
        } else {
            def errors = uc.errors.getAllErrors().collect({ error ->
                def msg = message(code: "${error.getObjectName()}.${error.field}.${error.getCode()}")
                msg && msg != "" ? msg : "${error.field} ${error.getCode()}"
            })
            render(view: 'index', model: [
                errors           : errors,
                userNameFilter   : params.userNameFilter,
                pokemonNameFilter: params.pokemonNameFilter,
                dateFromFilter   : params.dateFromFilter,
                dateToFilter     : params.dateToFilter,
                page             : params.page,
                userName         : session.user.name
            ])
        }
    }

    def login() {
        if (request.get) {
            return
        }
        def tmpUser = User.findByName(params.name)
        if (tmpUser) {
            if (tmpUser.password == params.password) {
                session.user = tmpUser
                redirect(action: "list")
            } else {
                render(view: "login", model: [message: "Password incorrect"])
            }
        } else {
            render(view: "login", model: [message: "User not found"])
        }
    }

    def logout() {
        session.invalidate()
        redirect(action: 'login')
    }

    def error() {
        render(view: 'index', model: [errorMessage: params.message])
    }
}
