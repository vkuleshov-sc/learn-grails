package testgrails

class UserController {

    def index() {
        render(view: 'index', model: [
            userList  : UserService.getUserList(params['userName'], params['pokemonName']),
            userName: params['userName'],
            pokemonName: params['pokemonName'],
            page: params['page']
        ])
    }
}
