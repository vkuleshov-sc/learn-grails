import testgrails.Pokemon
import testgrails.User

import java.text.SimpleDateFormat

class BootStrap {

    def init = { servletContext ->
        print "Hello World"
        def userList = [
            new User(name: "Vasya", birthday: new SimpleDateFormat("dd.MM.yyyy").parse("03.03.2000")),
            new User(name: "Kolya", birthday: new SimpleDateFormat("dd.MM.yyyy").parse("12.12.2012")),
            new User(name: "Sanya", birthday: new SimpleDateFormat("dd.MM.yyyy").parse("3.09.2002")),
            new User(name: "Lexa", birthday: new SimpleDateFormat("dd.MM.yyyy").parse("15.07.1992")),
            new User(name: "Alex", birthday: new SimpleDateFormat("dd.MM.yyyy").parse("27.04.1982")),
            new User(name: "Vanya", birthday: new SimpleDateFormat("dd.MM.yyyy").parse("13.03.2005")),
            new User(name: "Vasya", birthday: new SimpleDateFormat("dd.MM.yyyy").parse("04.04.1999")),
            new User(name: "Kolya", birthday: new SimpleDateFormat("dd.MM.yyyy").parse("07.12.2014")),
            new User(name: "Sanya", birthday: new SimpleDateFormat("dd.MM.yyyy").parse("03.09.2001")),
            new User(name: "Lexa", birthday: new SimpleDateFormat("dd.MM.yyyy").parse("16.08.1996")),
            new User(name: "Alex", birthday: new SimpleDateFormat("dd.MM.yyyy").parse("25.11.1987")),
            new User(name: "Vanya", birthday: new SimpleDateFormat("dd.MM.yyyy").parse("10.10.2003")),
            new User(name: "Vasya", birthday: new SimpleDateFormat("dd.MM.yyyy").parse("02.02.2002")),
            new User(name: "Dovakin", birthday: new SimpleDateFormat("dd.MM.yyyy").parse("11.11.2011")),
            new User(name: "Sanya", birthday: new SimpleDateFormat("dd.MM.yyyy").parse("08.06.2006")),
            new User(name: "Lexa", birthday: new SimpleDateFormat("dd.MM.yyyy").parse("15.07.1992")),
            new User(name: "Alex", birthday: new SimpleDateFormat("dd.MM.yyyy").parse("27.04.1982")),
            new User(name: "Vanya", birthday: new SimpleDateFormat("dd.MM.yyyy").parse("13.03.2005")),
            new User(name: "Vasya", birthday: new SimpleDateFormat("dd.MM.yyyy").parse("03.03.2000")),
            new User(name: "Kolya", birthday: new SimpleDateFormat("dd.MM.yyyy").parse("12.12.2012")),
            new User(name: "Sanya", birthday: new SimpleDateFormat("dd.MM.yyyy").parse("3.09.2002")),
            new User(name: "Lexa", birthday: new SimpleDateFormat("dd.MM.yyyy").parse("15.07.1992")),
            new User(name: "Alex", birthday: new SimpleDateFormat("dd.MM.yyyy").parse("27.04.1982")),
            new User(name: "Vanya", birthday: new SimpleDateFormat("dd.MM.yyyy").parse("13.03.2005")),
            new User(name: "Vasya", birthday: new SimpleDateFormat("dd.MM.yyyy").parse("03.03.2000")),
            new User(name: "Kolya", birthday: new SimpleDateFormat("dd.MM.yyyy").parse("12.12.2012")),
            new User(name: "Sanya", birthday: new SimpleDateFormat("dd.MM.yyyy").parse("3.09.2002")),
            new User(name: "Lexa", birthday: new SimpleDateFormat("dd.MM.yyyy").parse("15.07.1992")),
            new User(name: "Alex", birthday: new SimpleDateFormat("dd.MM.yyyy").parse("27.04.1982")),
            new User(name: "Vanya", birthday: new SimpleDateFormat("dd.MM.yyyy").parse("13.03.2005")),
            new User(name: "Vasya", birthday: new SimpleDateFormat("dd.MM.yyyy").parse("03.03.2000")),
            new User(name: "Kolya", birthday: new SimpleDateFormat("dd.MM.yyyy").parse("12.12.2012")),
            new User(name: "Sanya", birthday: new SimpleDateFormat("dd.MM.yyyy").parse("3.09.2002")),
            new User(name: "Lexa", birthday: new SimpleDateFormat("dd.MM.yyyy").parse("15.07.1992")),
            new User(name: "Alex", birthday: new SimpleDateFormat("dd.MM.yyyy").parse("27.04.1982")),
            new User(name: "Vanya", birthday: new SimpleDateFormat("dd.MM.yyyy").parse("13.03.2005")),
            new User(name: "Vasya", birthday: new SimpleDateFormat("dd.MM.yyyy").parse("03.03.2000")),
            new User(name: "Kolya", birthday: new SimpleDateFormat("dd.MM.yyyy").parse("12.12.2012")),
            new User(name: "Sanya", birthday: new SimpleDateFormat("dd.MM.yyyy").parse("3.09.2002")),
            new User(name: "Lexa", birthday: new SimpleDateFormat("dd.MM.yyyy").parse("15.07.1992")),
            new User(name: "Alex", birthday: new SimpleDateFormat("dd.MM.yyyy").parse("27.04.1982")),
            new User(name: "Vanya", birthday: new SimpleDateFormat("dd.MM.yyyy").parse("13.03.2005")),
            new User(name: "Vasya", birthday: new SimpleDateFormat("dd.MM.yyyy").parse("03.03.2000")),
            new User(name: "Kolya", birthday: new SimpleDateFormat("dd.MM.yyyy").parse("12.12.2012")),
            new User(name: "Sanya", birthday: new SimpleDateFormat("dd.MM.yyyy").parse("3.09.2002")),
            new User(name: "Lexa", birthday: new SimpleDateFormat("dd.MM.yyyy").parse("15.07.1992")),
            new User(name: "Alex", birthday: new SimpleDateFormat("dd.MM.yyyy").parse("27.04.1982")),
            new User(name: "Vanya", birthday: new SimpleDateFormat("dd.MM.yyyy").parse("13.03.2005")),
        ]
        def pokemonsList = [
            "Pikachu",
            "Sashka pokemon",
            "Ninja turtle",
            "Picaso",
            "Vasilisk",
            "Shrek",
            "Bumble",
            "Stiff",
            "Pudge",
            "Loli4eski",
            "Mirt",
            "Fallen",
            "Mixy",
            "Pixy",
            "React",
            "Atom",
            "HTML Warrior"
        ]
        userList.forEach { user ->
            for (int i = 0; i < Math.random() * pokemonsList.size(); i++) {
                def tmpPokemon = new Pokemon(name: pokemonsList[(Integer) Math.floor(Math.random() * pokemonsList.size())])
                tmpPokemon.save()
                user.addToPokemons(tmpPokemon)
            }
            user.save()
        }
    }
    def destroy = {
        User.deleteAll()
        Pokemon.deleteAll()
    }
}
