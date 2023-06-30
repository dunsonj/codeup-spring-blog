package jakira.springblog.controllers;

import jakarta.annotation.Nullable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


//@Controller
//@RequestMapping("/getMapping")
//public class HomeController {

// Controller exercise
//    @GetMapping()
//    @ResponseBody
//    public String home(){
//        return "<p>This is the landing page!</p>";
//    }
//
//
//}



@Controller
public class HomeController {

    @GetMapping("/home")
    public String welcome() {
        return "home";
    }

//    @GetMapping("/hello/{name}")
//    public String sayHello(@PathVariable String name, Model model) {
//        model.addAttribute("name", name);
//        return "hello";
//    }

    @GetMapping("/join")
    public String showJoinForm() {
        return "join";
    }

    @PostMapping("/join")
    public String joinCohort(@RequestParam(name = "cohort") String cohort, Model model) {
        model.addAttribute("cohort", "Welcome to " + cohort + "!");
        return "join";
    }




}
