package models

class Pokemon {
    String name
    static hasOne = [user: User]
}
