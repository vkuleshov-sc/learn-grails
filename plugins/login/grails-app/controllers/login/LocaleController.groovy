package login

class LocaleController {

    def setLang() {
        session.lang = params.lang ?: 'en'
        render 'Locale changed'
    }
}
