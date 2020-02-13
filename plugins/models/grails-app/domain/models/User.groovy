package models

class User {
    String name
    String password
    Date birthday
    static hasMany = [pokemons: Pokemon]
    static constraints = {
        birthday max: new Date()
    }
}
