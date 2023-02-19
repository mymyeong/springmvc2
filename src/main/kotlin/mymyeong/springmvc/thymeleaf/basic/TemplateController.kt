package mymyeong.springmvc.thymeleaf.basic

import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping

@Controller
@RequestMapping("/template")
class TemplateController {

    @GetMapping("fragment")
    fun template(model: Model): String {
        return "template/fragment/fragmentMain"
    }
}