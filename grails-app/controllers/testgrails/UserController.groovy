package testgrails

import commands.UserCommand

class UserController {
    def userService
    static scaffold = User

    def index() {
        render(view: 'index')
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

    def error() {
        render(view: 'index', model: [errorMessage: params.message])
    }
}
