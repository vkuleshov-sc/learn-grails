package testgrails

class User {
    String name
    Date birthday
    static hasMany = [pokemons: Pokemon]
}
