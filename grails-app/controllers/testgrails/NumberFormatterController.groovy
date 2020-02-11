package testgrails

import utils.NumberFormatter

class NumberFormatterController {
    def index() {
        render(view: 'index')
    }

    def getValue() {
        Locale locale = new Locale(session.lang ?: 'en')
        double value = NumberFormatter.convert(params.value, locale)
        render(view: 'index', model: [answer: NumberFormatter.format(value, locale) ?: 'Invalid value'])
    }
}
