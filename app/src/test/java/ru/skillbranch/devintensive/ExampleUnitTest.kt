package ru.skillbranch.devintensive

import org.junit.Test

import org.junit.Assert.*
import ru.skillbranch.devintensive.extensions.TimeUnits
import ru.skillbranch.devintensive.extensions.add
import ru.skillbranch.devintensive.extensions.format
import ru.skillbranch.devintensive.extensions.toUserView
import ru.skillbranch.devintensive.models.*
import java.util.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }
    @Test
    fun test_instance(){
//        val user=User("1")
        val user2=User("2", "Jhon", "Cene")
    }
    @Test
    fun test_factory(){
//        val user=User.makeUser("Jhon Cene")
//        val user2=User.makeUser("Jhon Wick")
        val user=User.makeUser("Jhon Wick")
        val user2=user.copy(id="2",lastName = "Cene",lastVisit = Date())
        print("$user \n$user2")
    }
    @Test
    fun test_decomposition(){
        val user=User.makeUser("Jhon Wick")

        fun getUserInfo()=user

        val(id, firstName, lastName)=getUserInfo()
         println("$id $firstName $lastName")
        println("${user.component1()} ${user.component2()} ${user.component3()}")

    }
    @Test
    fun test_copy(){
        val user=User.makeUser("Jhon Wick")
        val user2=user.copy( lastVisit = Date())
        val user3=user.copy( lastVisit = Date().add(-2))
        val user4=user.copy(lastName = "Cene", lastVisit = Date().add(2, TimeUnits.HOUR))

        println("""
            ${user.lastVisit?.format()}
            ${user2.lastVisit?.format()}
            ${user3.lastVisit?.format()}
            ${user4.lastVisit?.format()}
        """.trimIndent())





//        if (user==user2){
//            println ("equals\n${user.hashCode()}$user\n${user2.hashCode()}$user2")
//        } else {
//            println ("not equals\n${user.hashCode()}$user\n ${user2.hashCode()}$user2")
//        }
//
//
//        if (user===user2){
//            println ("equals address\n${System.identityHashCode(user)}\n${System.identityHashCode(user2)}")
//        } else {
//            println ("not equals address\n${System.identityHashCode(user)}\n${System.identityHashCode(user2)}")
//        }
    }
    @Test
    fun test_dataq_maping(){
        val user=User.makeUser("Ковалев Артем")

        println(user)

        val userView = user.toUserView()
        userView.printMe()
    }
    @Test
    fun test_abstract_factory(){
        val user=User.makeUser("Ковалев Артем")
        val txtMessage=BaseMessage.makeMessage(user, Chat("0"),payload = "Any text message", type = "text")
        val imgMessage=BaseMessage.makeMessage(user, Chat("0"),payload = "Any image url", type = "image")

        println (txtMessage.formatMessage())
        println (imgMessage.formatMessage())

    }

}
