package testgrails

import org.grails.databinding.BindUsing

class Task3Controller {
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

    def index() {}

    def getValue() {
        def tmp = new ExampleToBinding()
        bindData(tmp, params)
        redirect(url: "/task3?lang=${params["lang"] ?: "en"}&answer=${tmp.value ?: "Invalid value"}")
    }
}
