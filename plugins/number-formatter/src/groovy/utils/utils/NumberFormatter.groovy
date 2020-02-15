package utils.utils

import java.text.NumberFormat

class NumberFormatter {
    static double convert(String value, Locale locale) {
        def nf = NumberFormat.getInstance(locale)
        return nf.parse(value).doubleValue()
    }

    static String format(double value, Locale locale) {
        def nf = NumberFormat.getInstance(locale)
        nf.setMaximumFractionDigits(value.toString().length())
        return nf.format(value)
    }
}
