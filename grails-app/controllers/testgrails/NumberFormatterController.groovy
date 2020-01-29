package testgrails

import utils.NumberFormatter

class NumberFormatterController {
    def index() {
        render(view: 'index', model: [
            userName: session.user.name
        ])
    }

    def getValue() {
        def tmp = new NumberFormatter()
        bindData(tmp, params)
        redirect(url: "/numberFormatter?lang=${params["lang"] ?: "en"}&answer=${tmp.value ?: "Invalid value"}")
    }
}
