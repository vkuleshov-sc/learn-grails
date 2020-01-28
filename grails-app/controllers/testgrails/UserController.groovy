package testgrails

class UserController {
    static scaffold = true

    def index() {
        redirect(action: 'list')
    }

    def show() {
        User.get(params.id)
    }

    def list() {
        def tmp = UserService.getUserList(
            params['userNameFilter'],
            params['pokemonNameFilter'],
            params['page'] ? Integer.parseInt(params['page']) : 1
        )
        render(view: 'index', model: [
            userList         : tmp.userList,
            pageAmount       : tmp.pageAmount,
            userNameFilter   : params['userNameFilter'],
            pokemonNameFilter: params['pokemonNameFilter'],
            page             : params['page'],
            userName         : session.user.name
        ])
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
}
