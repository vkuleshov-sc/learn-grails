package number.formatter

import nf.utils.NumberFormatter

class NumberFormatterController {
    def index() {
        render(view: 'index')
    }

    def getValue() {
        Locale locale = new Locale(session.lang ?: 'en')
        def validateRes = NumberFormatter.validate(params.value, locale)
        if (validateRes.result) {
            double value = NumberFormatter.convert(params.value, locale)
            render(view: 'index', model: [answer: NumberFormatter.format(value, locale)])
        } else {
            flash.error = validateRes.message
            render(view: 'index')
        }
    }
}

