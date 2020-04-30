package ru.skillbranch.devintensive.extensions

//import java.lang.IllegalStateException
import android.os.Build
import androidx.annotation.RequiresApi
import java.text.SimpleDateFormat
import java.time.LocalDate
import java.time.LocalTime
import java.time.Month
import java.time.Period
import java.util.*
import java.util.Calendar.JANUARY

//import kotlin.IllegalStateException

const val SECOND =1000L
const val MINUTE = 60*SECOND
const val HOUR = 60*MINUTE
const val DAY = 24* HOUR
fun Date.format(pattern:String="HH:mm:ss dd:MM:yy"):String{
    val dateFormat=SimpleDateFormat(pattern, Locale("ru"))
    return dateFormat.format(this)

}
fun Date.add(value:Int, units: TimeUnits= TimeUnits.SECOND): Date{
    var time = this.time

    time += when(units){
        TimeUnits.SECOND-> value*SECOND
        TimeUnits.MINUTE-> value*MINUTE
        TimeUnits.HOUR-> value*HOUR
        TimeUnits.DAY-> value*DAY
    }
    this.time=time

    return this
}
@RequiresApi(Build.VERSION_CODES.O)
fun Date.humanizeDiff(date:Date=Date()): String {
//   var time = this.time
    var dat1=date.format()
    var dat2=Date().format()
var stat1="Никогда не был   "


    var h=((dat2.take(2)).toInt())-((dat1.take(2)).toInt())
    dat1=dat1.drop(3)
    dat2=dat2.drop(3)
    var min=((dat2.take(2)).toInt())-((dat1.take(2)).toInt())
    dat1=dat1.drop(3)
    dat2=dat2.drop(3)
    var sec=((dat2.take(2)).toInt())-((dat1.take(2)).toInt())
    dat1=dat1.drop(3)
    dat2=dat2.drop(3)
    var d=((dat2.take(2)).toInt())-((dat1.take(2)).toInt())
    dat1=dat1.drop(3)
    dat2=dat2.drop(3)
    var m=((dat2.take(2)).toInt())-((dat1.take(2)).toInt())
    dat1=dat1.drop(3)
    dat2=dat2.drop(3)
    var y=(dat2.toInt())-(dat1.toInt())


    var loc1=dat2.toString()


//    var date1 = LocalDate.parse(loc)
//    var date2 = LocalDate.parse(loc1)

    stat1=stat1+h+"     "+loc1+dat1
//    var time1 = LocalTime.parse(loc)
//    var time2 = LocalTime.parse(loc1)
//    var y= date2.year-date1.year
//   // var m = (date2.dayOfYear-date1.dayOfYear)/30
//    var m1 = when (date2.month){
//        Month.JANUARY -> 1
//        Month.FEBRUARY->2
//        Month.MARCH -> 3
//        Month.APRIL ->4
//        Month.MAY ->5
//        Month.JUNE ->6
//        Month.JULY ->7
//        Month.AUGUST ->8
//        Month.SEPTEMBER ->9
//        Month.OCTOBER ->10
//        Month.NOVEMBER ->11
//        Month.DECEMBER ->12
//    }
//    var m2 = when (date1.month){
//        Month.JANUARY -> 1
//        Month.FEBRUARY->2
//        Month.MARCH -> 3
//        Month.APRIL ->4
//        Month.MAY ->5
//        Month.JUNE ->6
//        Month.JULY ->7
//        Month.AUGUST ->8
//        Month.SEPTEMBER ->9
//        Month.OCTOBER ->10
//        Month.NOVEMBER ->11
//        Month.DECEMBER ->12
//    }
//    var d=date2.dayOfYear-date1.dayOfYear
//    var m=m1-m2
//    var h=(time2.hour-time1.hour)
//    var min=(time2.minute-time1.minute)
//    var s = (time2.second-time1.second)
//
    if (y>1) stat1="более года назад"
    else if (d>1) stat1="$d дней назад"
    else if (h>22) stat1="$h часов назад"
    else if (min>45) stat1="Час назад"
    else if (sec>15&&min>1&&min<45) stat1="$min назад"
    else if (sec>1&&sec<45)stat1="несколько секунд назад"
    else if (sec==0&&sec==1)stat1="только что"

//
//
//
//

        // var period = Period.between(date1, date2)

//var stat=date
//    time -= whedate
//        TimeUnits.SECOND-> SECOND
//        TimeUnits.MINUTE-> MINUTE
//        TimeUnits.HOUR-> HOUR
//        TimeUnits.DAY-> DAY
//        else ->throw IllegalStateException("invalid unit")
//    }
//    this.time=time

//  var stat1 = when (time){
        //  TODO("not implemented")

    return stat1
}

enum class TimeUnits{
    SECOND,
    MINUTE,
    HOUR,
    DAY

}