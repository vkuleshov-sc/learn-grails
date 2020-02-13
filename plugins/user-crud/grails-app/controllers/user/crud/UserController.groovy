package user.crud

import models.User

class UserController {

    static scaffold = User

    def index() {
        render(view: 'index')
    }

    def show() {
        User.get(params.id)
    }
}
