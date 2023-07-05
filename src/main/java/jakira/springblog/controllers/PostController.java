package jakira.springblog.controllers;

import jakira.springblog.models.Post;
import jakira.springblog.repositories.PostRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;
import lombok.*;


@AllArgsConstructor

@Controller
public class PostController {
    private PostRepository postDao;
    @GetMapping("/post")
    public String post(Model model) {
        model.addAttribute("post", new Post(1L,"Hello", "Hello World"));
        return "/posts/index";
    }

    @GetMapping("/posts")
    public String posts(Model model) {
        List<Post> posts = new ArrayList<>();
        posts.add(new Post(2L,"Hello", "Hello World"));
        posts.add(new Post(3L, "Hello Queen", "Hello Beautiful :)"));
        model.addAttribute("posts", posts);
        return "/posts/show";
    }
}

