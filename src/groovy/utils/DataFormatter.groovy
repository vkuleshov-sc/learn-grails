package utils

class DataFormatter {
    static String getFormatName(String name) {
        name = name.trim()
        if (name.lastIndexOf('*') == name.length() - 1) {
            return name.reverse().replaceFirst(/\*/, '%').reverse()
        }
        return name
    }
}
