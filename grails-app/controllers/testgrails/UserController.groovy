package testgrails

import commands.UserCommand

class UserController {
    def userService
    static scaffold = User

    def index() {
        render(view: 'index', model: [
            userName: session.user.name
        ])
    }

    def show() {
        User.get(params.id)
    }

    def list() {
        UserCommand userCommand = new UserCommand()
        bindData(userCommand, params)
        if (userCommand.validate()) {
            render(
                template: 'userTable',
                model: [
                    pageAmount: userService.getPageAmount(userCommand),
                    userList  : userService.getUserList(userCommand)
                ])
        } else {
            def errors = userCommand.errors.getAllErrors().collect({ error ->
                def msg = message(code: "${error.getObjectName()}.${error.field}.${error.getCode()}")
                msg ?: "${error.field} ${error.getCode()}"
            })
            render(template: 'errors', model: [errors: errors,])
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
                redirect(action: "index")
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
