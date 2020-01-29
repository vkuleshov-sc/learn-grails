package utils

import org.grails.databinding.BindUsing

class NumberFormatter {
    @BindUsing({ obj, source ->
        if (source["lang"] == "de") {
            return Double.parseDouble(source["value"].replaceAll(',', '.'))
        } else {
            return Double.parseDouble(source["value"])
        }
    })
    Double value
}
