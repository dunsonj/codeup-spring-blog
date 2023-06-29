package jakira.springblog.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(path = "/posts")
public class PostController {
    @GetMapping()
    @ResponseBody
    public String index(){
        return "post index page";
    }
    @GetMapping("/{id}")
    @ResponseBody
    public String detail(@PathVariable Long id){
        return "view an indiviual post " + id;
    }
    @GetMapping("/create")
    @ResponseBody
    public String insert(){
        return "view the form for creating a post";
    }

    @PostMapping("/create")
    @ResponseBody
    public String saveNewPost(){
        return "create a new post";
    }

}
