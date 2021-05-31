package job.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/login")
    public String login(Model model) {
        return "login";
    }

    @GetMapping("/user")
    public String userIndex() {
        return "user/index";
    }

    @GetMapping("/border_a")
    public String border_a() {
    return "border_a";
    }

    @GetMapping("/border_b")
    public String border_b() {
        return "border_b";
    }

    @GetMapping("/border_d")
    public String border_d() {
        return "border_d";
    }

    @GetMapping("/border_m")
    public String border_m() {
        return "border_m";
    }

    @GetMapping("/border_h")
    public String border_h() {
        return "border_h";
    }

    @GetMapping("/write")
    public String write() {
        return "write";
    }

}