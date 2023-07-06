package jakira.springblog.controllers;

import jakira.springblog.models.Post;
import jakira.springblog.repositories.PostRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.GetMapping;

@AllArgsConstructor

@Controller
@RequestMapping("/post")
public class PostController {
    private PostRepository postDao;
    @GetMapping
    @ResponseBody
    public String index() {
        List<Post> post = postDao.findAll();

        System.out.println(post);
       List<Post> sPost = postDao.searchByTitle("a");
        System.out.println(sPost);

        return "show all posts here";
    }
    @GetMapping("/{id}")
    @ResponseBody
    public String fetchById(@PathVariable Long id){
        Optional<Post> optionalPost = postDao.findById(id);

        if(optionalPost.isEmpty()){
            return "No post found, return a 404 instead";
        }
        Post post = optionalPost.get();
        return post.toString();
    }
    @GetMapping("/posts/create")
    public String showCreate(){
        return "/posts/create";
    }
    @PostMapping("/posts/create")
    @ResponseBody
    public String doCreate( @RequestParam String title
                        , @RequestParam String body) {
        System.out.printf("%s %s\n", title, body);
        Post post = new Post();

        post.setTitle(title);
        post.setBody(body);

        postDao.save(post);

        return "redirect:/posts";
    }
    @GetMapping("/{id}/delete")
    @ResponseBody
    public String delete(@PathVariable Long id){
        postDao.deleteById(id);
        return "post" + id + " deleted";
    }
}

