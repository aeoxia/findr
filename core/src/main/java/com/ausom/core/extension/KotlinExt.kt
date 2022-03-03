package com.ausom.core.extension

import org.threeten.bp.LocalDateTime
import org.threeten.bp.format.DateTimeFormatter
import java.text.DecimalFormat

/**
 * Formats double to currency format using the given [currency]
 * example:
 *    val num: Double = 1126
 *    num.toCurrencyFormat("$)
 *
 *    returns $ 1,126.00
 *
 *  @return formatted currency value in string
 */
fun Double?.toCurrencyFormat(currency: String): String {
    val formatter = DecimalFormat("###,###,##0.00")
    return "$currency ${formatter.format(this)}"
}

/**
 * Formats double to currency format using the given
 *  @return equivalent double value of the currency value using the [toCurrencyFormat]
 */
fun String?.clearCurrencyFormat(): Double {
    if(isNullOrEmpty()) return 0.0
    val numberPart = this.split(" ").lastOrNull()?: return 0.0
    return numberPart.toNumberString().toDouble()
}

/**
 *  Removes all "," and converts blank as "0"
 */
fun CharSequence?.toNumberString() : String {
    if(isNullOrEmpty()) return "0"
    return toString().replace(",", "")
}

/**
 *  Formats [LocalDateTime] to [String] based on given pattern
 *  @param pattern - is the format that will be follow see more here [DateTimeFormatter.ofPattern]
 */
fun LocalDateTime.toFormattedString(pattern: String = "MM-dd-yyyy HH:mm:ss") : String {
    if(this == LocalDateTime.MIN) return "N/A"
    val formatter = DateTimeFormatter.ofPattern(pattern)
    return format(formatter)
}

/**
 *  Formats [String] to [LocalDateTime] based on given pattern
 *  @param pattern - is the format that will be follow see more here [DateTimeFormatter.ofPattern]
 */
fun String.toLocalDateTime(pattern: String = "MM-dd-yyyy HH:mm:ss") : LocalDateTime {
    val formatter = DateTimeFormatter.ofPattern(pattern)
    return try {
        LocalDateTime.parse(this, formatter)
    } catch (e: Exception) {
        LocalDateTime.MIN
    }
}

