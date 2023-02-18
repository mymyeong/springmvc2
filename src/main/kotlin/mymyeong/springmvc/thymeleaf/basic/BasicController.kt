package mymyeong.springmvc.thymeleaf.basic

import jakarta.servlet.http.HttpSession
import org.springframework.stereotype.Component
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import java.time.LocalDateTime

@Controller
@RequestMapping("/basic")
class BasicController {

    @GetMapping("text-basic")
    fun textBasic(model: Model): String {
        model.addAttribute("data", "hello spring")
        return "basic/text-basic"
    }

    @GetMapping("text-unescaped")
    fun textUnescaped(model: Model): String {
        model.addAttribute("data", "hello <b>spring<b>")
        return "basic/text-unescaped"
    }

    @GetMapping("variable")
    fun variable(model: Model): String {
        val userA = User("userA", 10)
        val userB = User("userB", 10)

        model.addAttribute("user", userA)
        model.addAttribute("users", listOf(userA, userB))
        model.addAttribute(
            "userMap", mapOf(
                "userA" to userA,
                "userB" to userB
            )
        )
        return "basic/variable"
    }

    @GetMapping("basic-objects")
    fun basicObjects(session: HttpSession): String {
        session.setAttribute("sessionData", "hello session")
        return "basic/basic-objects"
    }

    @GetMapping("date")
    fun date(model: Model): String {
        model.addAttribute("localDateTime", LocalDateTime.now())
        return "basic/date"
    }

    @GetMapping("link")
    fun link(model: Model): String {
        model.addAttribute("param1", "date1")
        model.addAttribute("param2", "date2")
        return "basic/link"
    }

    @Component("helloBean")
    class HelloBean {
        fun hello(data: String): String {
            return "hello $data"
        }
    }

    data class User(
        var username: String = "",
        var age: Int = 0
    )
}