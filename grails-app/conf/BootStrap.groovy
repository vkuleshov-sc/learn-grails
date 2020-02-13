import models.Pokemon
import models.User

import java.text.SimpleDateFormat

class BootStrap {

    def init = { servletContext ->
        print "Hello World"
        def userList = [
            new User(name: "Vasya", birthday: new SimpleDateFormat("dd.MM.yyyy").parse("03.03.2000"), password: '1234'),
            new User(name: "Kolya", birthday: new SimpleDateFormat("dd.MM.yyyy").parse("12.12.2012"), password: '1234'),
            new User(name: "Sanya", birthday: new SimpleDateFormat("dd.MM.yyyy").parse("3.09.2002"), password: '1234'),
            new User(name: "Lexa", birthday: new SimpleDateFormat("dd.MM.yyyy").parse("15.07.1992"), password: '1234'),
            new User(name: "AlexRepublic", birthday: new SimpleDateFormat("dd.MM.yyyy").parse("27.04.1982"), password: '1234'),
            new User(name: "Vanya", birthday: new SimpleDateFormat("dd.MM.yyyy").parse("13.03.2005"), password: '1234'),
            new User(name: "Sonya", birthday: new SimpleDateFormat("dd.MM.yyyy").parse("04.04.1999"), password: '1234'),
            new User(name: "MAZ", birthday: new SimpleDateFormat("dd.MM.yyyy").parse("07.12.2014"), password: '1234'),
            new User(name: "Monika", birthday: new SimpleDateFormat("dd.MM.yyyy").parse("03.09.2001"), password: '1234'),
            new User(name: "Alexey", birthday: new SimpleDateFormat("dd.MM.yyyy").parse("16.08.1996"), password: '1234'),
            new User(name: "AlexHero", birthday: new SimpleDateFormat("dd.MM.yyyy").parse("25.11.1987"), password: '1234'),
            new User(name: "KOL", birthday: new SimpleDateFormat("dd.MM.yyyy").parse("10.10.2003"), password: '1234'),
            new User(name: "Anya", birthday: new SimpleDateFormat("dd.MM.yyyy").parse("02.02.2002"), password: '1234'),
            new User(name: "Durakin", birthday: new SimpleDateFormat("dd.MM.yyyy").parse("11.11.2011"), password: '1234'),
            new User(name: "Dovakin", birthday: new SimpleDateFormat("dd.MM.yyyy").parse("11.11.2011"), password: '1234'),
            new User(name: "Mike", birthday: new SimpleDateFormat("dd.MM.yyyy").parse("08.06.2006"), password: '1234'),
            new User(name: "BIG_DADY", birthday: new SimpleDateFormat("dd.MM.yyyy").parse("15.07.1992"), password: '1234'),
            new User(name: "AlexGrails", birthday: new SimpleDateFormat("dd.MM.yyyy").parse("27.04.1982"), password: '1234'),
            new User(name: "QWERTY", birthday: new SimpleDateFormat("dd.MM.yyyy").parse("13.03.2005"), password: '1234'),
            new User(name: "Vika", birthday: new SimpleDateFormat("dd.MM.yyyy").parse("03.03.2000"), password: '1234'),
            new User(name: "DIKIY", birthday: new SimpleDateFormat("dd.MM.yyyy").parse("12.12.2012"), password: '1234'),
            new User(name: "Kolya_OMEGA", birthday: new SimpleDateFormat("dd.MM.yyyy").parse("3.09.2002"), password: '1234'),
            new User(name: "KON", birthday: new SimpleDateFormat("dd.MM.yyyy").parse("15.07.1992"), password: '1234'),
            new User(name: "Alex_GHOST", birthday: new SimpleDateFormat("dd.MM.yyyy").parse("27.04.1982"), password: '1234'),
            new User(name: "123", birthday: new SimpleDateFormat("dd.MM.yyyy").parse("13.03.2005"), password: '1234'),
            new User(name: "Veronika", birthday: new SimpleDateFormat("dd.MM.yyyy").parse("03.03.2000"), password: '1234'),
            new User(name: "RAMIRES", birthday: new SimpleDateFormat("dd.MM.yyyy").parse("12.12.2012"), password: '1234'),
            new User(name: "Valik", birthday: new SimpleDateFormat("dd.MM.yyyy").parse("3.09.2002"), password: '1234'),
            new User(name: "VALIOXA", birthday: new SimpleDateFormat("dd.MM.yyyy").parse("15.07.1992"), password: '1234'),
            new User(name: "Alex_KInDer", birthday: new SimpleDateFormat("dd.MM.yyyy").parse("27.04.1982"), password: '1234'),
            new User(name: "140B", birthday: new SimpleDateFormat("dd.MM.yyyy").parse("13.03.2005"), password: '1234'),
            new User(name: "Angelina", birthday: new SimpleDateFormat("dd.MM.yyyy").parse("03.03.2000"), password: '1234'),
            new User(name: "RAMZES", birthday: new SimpleDateFormat("dd.MM.yyyy").parse("12.12.2012"), password: '1234'),
            new User(name: "MAxiM777", birthday: new SimpleDateFormat("dd.MM.yyyy").parse("3.09.2002"), password: '1234'),
            new User(name: "KROT", birthday: new SimpleDateFormat("dd.MM.yyyy").parse("15.07.1992"), password: '1234'),
            new User(name: "Alex_FROG", birthday: new SimpleDateFormat("dd.MM.yyyy").parse("27.04.1982"), password: '1234'),
            new User(name: "Vanya_Grozniy", birthday: new SimpleDateFormat("dd.MM.yyyy").parse("13.03.2005"), password: '1234'),
            new User(name: "Natasha", birthday: new SimpleDateFormat("dd.MM.yyyy").parse("03.03.2000"), password: '1234'),
            new User(name: "Kolya123", birthday: new SimpleDateFormat("dd.MM.yyyy").parse("12.12.2012"), password: '1234'),
            new User(name: "Valodka", birthday: new SimpleDateFormat("dd.MM.yyyy").parse("3.09.2002"), password: '1234'),
            new User(name: "MOX", birthday: new SimpleDateFormat("dd.MM.yyyy").parse("15.07.1992"), password: '1234'),
            new User(name: "Alex_KOP", birthday: new SimpleDateFormat("dd.MM.yyyy").parse("27.04.1982"), password: '1234'),
            new User(name: "MAG", birthday: new SimpleDateFormat("dd.MM.yyyy").parse("13.03.2005"), password: '1234'),
            new User(name: "Masha", birthday: new SimpleDateFormat("dd.MM.yyyy").parse("03.03.2000"), password: '1234'),
            new User(name: "Kolya_FIFER", birthday: new SimpleDateFormat("dd.MM.yyyy").parse("12.12.2012"), password: '1234'),
            new User(name: "Vov4ik", birthday: new SimpleDateFormat("dd.MM.yyyy").parse("3.09.2002"), password: '1234'),
            new User(name: "LOB", birthday: new SimpleDateFormat("dd.MM.yyyy").parse("15.07.1992"), password: '1234'),
            new User(name: "Alex_MARK", birthday: new SimpleDateFormat("dd.MM.yyyy").parse("27.04.1982"), password: '1234'),
            new User(name: "DoVaKiN", birthday: new SimpleDateFormat("dd.MM.yyyy").parse("13.03.2005"), password: '1234'),
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
