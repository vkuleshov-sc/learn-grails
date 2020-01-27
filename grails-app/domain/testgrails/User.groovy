package testgrails

class User {
    String name
    String password
    Date birthday
    static hasMany = [pokemons: Pokemon]
}
