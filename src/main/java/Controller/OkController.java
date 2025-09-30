package Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/ctrl")
public class OkController {

    @PostMapping("/ok")
    public String m1(Model model) {
        model.addAttribute("message", "m1");
        return "ok"; // Trả về view: src/main/resources/templates/ok.html
    }

    @GetMapping("/ok")
    public String m2(Model model) {
        model.addAttribute("message", "m3");
        return "ok";
    }

    @PostMapping("/ok/9")
    public String m3(Model model) {
        model.addAttribute("message", "m3");
        return "ok";
    }
}
