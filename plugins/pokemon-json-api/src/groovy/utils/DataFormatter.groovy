package utils

class DataFormatter {
    static String getFormatName(String name) {
        return name.trim().replaceFirst(/\*$/, '%')
    }
}
