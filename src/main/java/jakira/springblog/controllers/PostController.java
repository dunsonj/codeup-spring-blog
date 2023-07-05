package jakira.springblog.controllers;

import jakira.springblog.controllers.models.Post;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;


@Controller
public class PostController {
    @GetMapping("/post")
    public String post(Model model) {
        model.addAttribute("post", new Post("Hello", "Hello World"));
        return "/posts/index";
    }

    @GetMapping("/posts")
    public String posts(Model model) {
        List<Post> posts = new ArrayList<>();
        posts.add(new Post("Hello", "Hello World"));
        posts.add(new Post("Hello Queen", "Hello Beautiful :)"));
        model.addAttribute("posts", posts);
        return "/posts/show";
    }
}

