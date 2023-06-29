package jakira.springblog.controllers;

import jakarta.annotation.Nullable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/getMapping")
public class HomeController {

    @GetMapping()
    @ResponseBody
    public String landingPage(@RequestParam @Nullable String quote){
        return "<p>This is the landing page!</p>";
    }


}
