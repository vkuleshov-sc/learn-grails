package testgrails

class Pokemon {
    String name
    static hasOne = [user: User]
}
