package testgrails

class UserController {

    def index() {
        def tmp = UserService.getUserList(
            params['userName'],
            params['pokemonName'],
            params['page'] ? Integer.parseInt(params['page']) : 1
        )
        render(view: 'index', model: [
            userList   : tmp.userList,
            pageAmount : tmp.pageAmount,
            userName   : params['userName'],
            pokemonName: params['pokemonName'],
            page       : params['page']
        ])
    }
}
