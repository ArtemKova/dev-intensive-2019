package ru.skillbranch.devintensive.extensions

import android.provider.ContactsContract
import ru.skillbranch.devintensive.models.User
import ru.skillbranch.devintensive.models.UserView
import ru.skillbranch.devintensive.utils.Utils
import java.util.*

fun User.toUserView():UserView{
    val nickName =Utils.transliteration("$firstName $lastName","_")
    val initials=Utils.toInitials(firstName, lastName)
    val status= if (lastVisit==null)"Еще не разу не был" else if (isOnLine)"Is Online" else "Последний раз был ${lastVisit.humanizeDiff()}"


    return UserView(
        id,
        fullName = "$firstName $lastName",
        avatar = avatar,
        nickName =nickName ,
        initials =initials ,
        status =status
            )
}


