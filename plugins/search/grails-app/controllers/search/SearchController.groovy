package search

import commands.UserCommand

class SearchController {

    def searchService

    def index() {
        render(view: 'index')
    }

    def list() {
        UserCommand userCommand = new UserCommand()
        bindData(userCommand, params)
        if (userCommand.validate()) {
            render(
                template: 'userTable',
                model: [
                    pageAmount: searchService.getPageAmount(userCommand),
                    userList  : searchService.getUserList(userCommand)
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
