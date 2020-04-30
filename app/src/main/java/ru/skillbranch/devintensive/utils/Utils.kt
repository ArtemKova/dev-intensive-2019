package ru.skillbranch.devintensive.utils

object Utils {
    fun parseFullName(fullName:String?):Pair<String?,String?>{
//        TODO FIX ME
        var parts:List<String>?=fullName?.split(" ")

        var firstName =parts?.getOrNull(0)
        var lastName =parts?.getOrNull(1)
//        return Pair(firstName, lastName)
        return firstName to lastName
    }

    fun transliteration(payload: String, divider:String=" "): String =
        payload.replace(Regex("[абвгдеёжзийклмнопрстуфхцчшщъыьэюяАБВГДЕЁЖЗИКЛМНОПРСТУФХЦЧШЩЫЭЮЯ ]")) {
            when (it.value) {
                "а" ->"a"
                "А"->"A"
                "б" -> "b"
                "Б"->"B"
                "в" ->"v"
                "В"->"V"
                "г" -> "g"
                "Г"->"G"
                "д" -> "d"
                "Д"->"D"
                "е" -> "e"
                "Е"->"E"
                "ё" -> "e"
                "Ё"->"E"
                "ж" -> "zh"
                "Ж"->"Zh"
                "з" -> "z"
                "З"->"Z"
                "и" -> "i"
                "И"->"I"
                "й" -> "i"
                "Й"->"I"
                "к" -> "k"
                "К"->"K"
                "л" -> "l"
                "Л"->"L"
                "м" -> "m"
                "М"->"M"
                "н" -> "n"
                "Н"->"N"
                "о" -> "o"
                "О"->"O"
                "п" -> "p"
                "П"->"P"
                "р" -> "r"
                "Р"->"R"
                "с" -> "s"
                "С"->"S"
                "т" -> "t"
                "Т"->"T"
                "у" -> "u"
                "У"->"U"
                "ф" -> "f"
                "Ф"->"F"
                "х" -> "h"
                "Х"->"H"
                "ц" -> "c"
                "Ц"->"C"
                "ч" -> "ch"
                "Ч"->"Ch"
                "ш" -> "sh"
                "Ш"->"Sh"
                "щ" -> "sh'"
                "Щ"->"Sh'"
                "ъ" -> ""
                "ы" -> "i"
                "Ы"->"I"
                "ь" -> ""
                "э" -> "e"
                "Э"->"E"
                "ю" -> "yu"
                "Ю"->"Yu"
                "я" -> "ya"
                "Я"->"Ya"
                " "->divider
                else -> it.value
            }

//        var parts:List<String>?=payload?.split(" ")
//
//
////        var firstName =parts?.getOrNull(0)
////        var lastName =parts?.getOrNull(1)
////        return Pair(firstName, lastName)
//        return firstName to lastName


    }
  fun  toInitials(firstName: String?, lastName: String?): String?
  {

      var first = firstName?.get(0)
      var last = lastName?.get(0)
      var initials = ("$first$last")
      return  initials
      TODO("not implemented")
  }
}