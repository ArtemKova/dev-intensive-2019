package ru.skillbranch.devintensive.models

import ru.skillbranch.devintensive.extensions.humanizeDiff
import java.util.*


class ImageMessage (
    id:String,
    from:User?,
    chat:Chat,
    inComming:Boolean=false,
    date: Date = Date(),
    var image:String?

):BaseMessage(id, from, chat, inComming, date) {
    override fun formatMessage(): String ="id:$id ${from?.firstName}" +
    " ${if (inComming) "получил" else "отправил"} изображение \"$image\" ${date.humanizeDiff()}"
}