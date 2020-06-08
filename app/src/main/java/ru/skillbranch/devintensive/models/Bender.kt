package ru.skillbranch.devintensive.models

class Bender (var status:Status = Status.NORMAL,var question:Question = Question.NAME) {
    var i=0
    fun askQuestion(): String = when (question) {
        Question.NAME -> Question.NAME.question
        Question.PROFESSION -> Question.PROFESSION.question
        Question.MATRIAL -> Question.MATRIAL.question
        Question.BDAY -> Question.BDAY.question
        Question.SERIAL -> Question.SERIAL.question
        Question.IDLE -> Question.IDLE.question
    }

    fun listenAnswer(answer: String): Pair<String, Triple<Int, Int, Int>> {

        return if (question.answers.contains(answer)) {
            question = question.nextQuestion()
            "Отлично - ты справился!\n${question.question}" to status.color
        } else {
            i += 1
            if (i==3){
                status = status.beginStatus()
                question = question.beginQuestion()
                "Это неправильный ответ!\nДавай все по новой\n${question.question}" to status.color

            }else{
            status = status.nextStatus()
            "Это неправильный ответ!\n${question.question}" to status.color}

        }
    }

    enum class Status(val color: Triple<Int, Int, Int>) {
        NORMAL(Triple(255, 255, 255)),
        WARNING(Triple(255, 120, 0)),
        DANGER(Triple(255, 60, 60)),
        CRITICAL(Triple(255, 255, 0));

        fun nextStatus(): Status {
            return if (this.ordinal < values().lastIndex) {
                values()[this.ordinal + 1]
            } else {
                values()[0]
            }
        }
        fun beginStatus(): Status{
            return  values()[0]
            }
    }


    enum class Question(val question: String, val answers: List<String>) {
        NAME("Как меня зовут", listOf("бендер", "bender")) {
            override fun nextQuestion(): Question = PROFESSION
        },
        PROFESSION("Назови мою профессию", listOf("сгибальщик", "bender")) {
            override fun nextQuestion(): Question = MATRIAL
        },
        MATRIAL("Из чего я сделан", listOf("металл", "дерево", "iron", "wood")) {
            override fun nextQuestion(): Question = BDAY
        },
        BDAY("Когда меня создали", listOf("2993")) {
            override fun nextQuestion(): Question = SERIAL
        },
        SERIAL("Мой серийный номер", listOf("2116057")) {
            override fun nextQuestion(): Question = IDLE
        },
        IDLE("НА этом вопросов больше нет", listOf()) {
            override fun nextQuestion(): Question = IDLE
        };

        abstract fun nextQuestion(): Question
        fun beginQuestion(): Question{
            return  values()[0]
        }
    }
}