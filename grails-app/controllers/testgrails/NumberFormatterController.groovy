package testgrails

import utils.NumberFormatter

class NumberFormatterController {
    def index() {
        render(view: 'index', model: [
            userName: session.user.name
        ])
    }

    def getValue() {
        def numberFormatter = new NumberFormatter()
        params.lang = session.lang
        bindData(numberFormatter, params)
        render(view: 'index', model: [answer: numberFormatter.value?: 'Invalid value', userName: session.user.name])
    }
}
