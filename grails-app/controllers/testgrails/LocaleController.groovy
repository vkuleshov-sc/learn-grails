package testgrails

class LocaleController {

    def setLang() {
        session.lang = params.lang ?: 'en'
        render 'Locale changed'
    }
}
