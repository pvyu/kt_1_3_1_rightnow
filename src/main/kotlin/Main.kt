
fun getMinutesTxt(minutes : Int) : String {
    var result : String = ""
    val minutes2dgst =  minutes % 100
    if (minutes2dgst == 11 || minutes2dgst == 12 || minutes2dgst == 13 || minutes2dgst == 14) {
        result = "минут"
    }
    else {
        val rest : Int = minutes % 10;
        result = when (rest) {
                    2, 3, 4, -> "минуты"
                    5, 6, 7, 8, 9, 0 -> "минут"
                    else -> "минуту"
                 }
    }
    return result
}
//--------------------------------------------------------------------------

fun getHoursTxt(hours : Int) : String {
    var result : String = ""
    val hours2dgst =  hours % 100
    if (hours2dgst == 11 || hours2dgst == 12 || hours2dgst == 13 || hours2dgst == 14) {
        result = "часов"
    }
    else {
        val rest : Int = hours % 10;
        result = when (rest) {
            2, 3, 4, -> "часа"
            5, 6, 7, 8, 9, 0 -> "часов"
            else -> "час"
        }
    }
    return result
}
//--------------------------------------------------------------------------

fun agoToText(secondsRest : Int) : String {
    var result : String = "Был(а) "

    val minutes : Int = secondsRest / 60
    val hours : Int = minutes / 60
    val days : Int = hours / 24

    result += when {
                    days > 2 -> "давно"
                    days > 1 -> "позавчера"
                    days > 0 -> "вчера"
                    hours > 0 -> "$hours " + getHoursTxt(hours) + " назад"
                    minutes > 0 -> "$minutes " + getMinutesTxt(minutes) + " назад"
                    else -> " только что"
    }

    return result
}
//--------------------------------------------------------------------------

fun main() {
    for (days in 0 .. 3) {
        for (hours in 0 .. 23) {
            for (minutes in 0 .. 59) {
                for (seconds  in 0 .. 2) {
                    val sec : Int = days*24*60*60 + hours*60*60 + minutes*60 + seconds;
                    println("$sec: " + agoToText(sec))
                }
            }
        }
    }
}