package jakira.springblog.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.concurrent.ThreadLocalRandom;

@Controller
public class DiceController {
    @GetMapping("/roll-dice")
    public String dice(){
        return "rolldice";
    }

    @GetMapping("/roll-dice/${num}")
    public  String diceRoll(@PathVariable int num, Model model){
        int rand_int = ThreadLocalRandom.current().nextInt(1,7);
        model.addAttribute("result", rand_int);
        model.addAttribute("choice", num);

        if (num == rand_int){
            model.addAttribute("match", "Your number matched!");
        } else {
            model.addAttribute("match", "Your did not number matched!");
        }
        return "rolldice";
    }

}
