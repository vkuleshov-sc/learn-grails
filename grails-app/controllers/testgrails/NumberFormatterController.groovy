package testgrails

import org.grails.databinding.BindUsing

class NumberFormatterController {
    class ExampleToBinding {
        @BindUsing({ obj, source ->
            if (source["lang"] == "de") {
                return Double.parseDouble(source["value"].replaceAll(',', '.'))
            } else {
                return Double.parseDouble(source["value"])
            }
        })
        Double value
    }

    def index() {
        render(view: 'index', model: [
            userName: session.user.name
        ])
    }

    def getValue() {
        def tmp = new ExampleToBinding()
        bindData(tmp, params)
        redirect(url: "/numberFormatter?lang=${params["lang"] ?: "en"}&answer=${tmp.value ?: "Invalid value"}")
    }
}
