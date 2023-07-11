package jakira.springblog.controllers;

import jakira.springblog.models.EmailService;
import jakira.springblog.models.Post;
import jakira.springblog.models.User;
import jakira.springblog.repositories.PostRepository;
import jakira.springblog.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.GetMapping;

@AllArgsConstructor

@Controller
@RequestMapping("/posts")
public class PostController {
    private PostRepository postDao;
    private UserRepository userDao;

    private EmailService emailService;
    @GetMapping("")
    public String posts (Model model){
        User loggedInUser = (User) SecurityContextHolder
                .getContext()
                .getAuthentication()
                .getPrincipal();
        if(loggedInUser.getId() ==0){
            System.out.println("You are not logged in");
        }else{
            System.out.println("You're logged in as user id "+ loggedInUser.getId()
                        +" "+loggedInUser.getUsername()
                        +"  "+loggedInUser.getEmail());
        }
        List<Post> posts = postDao.findAll();

        model.addAttribute("posts", posts);
        return "/posts/index";
    }
    @GetMapping("/{id}")

    public String showSinglePost(@PathVariable Long id, Model model){
        Optional<Post> optionalPost = postDao.findById(id);

        if(optionalPost.isEmpty()){
            System.out.printf("Post with id " + id + " not found!");
            return "home";
        }
        model.addAttribute("post", optionalPost.get());
        return "/posts/show";
    }
    @GetMapping("/create")
    public String showCreate(Model model){
        model.addAttribute("post", new Post());
        return "/posts/create";
    }

    @PostMapping("/create")
    public String doCreate( @ModelAttribute Post post) {
//        Post post = new Post();
//        post.setTitle(title);
//        post.setBody(body);
        User loggedInUser = userDao.findById(1L).get();
        post.setCreator(loggedInUser);
//        emailService.prepareAndSend(post, title, body);
        postDao.save(post);
        return "redirect:/posts";
    }

    @GetMapping("/{id}/edit")
    public String showEdit(@PathVariable Long id, Model model){
       Post postToEdit = postDao.getReferenceById(id);
        model.addAttribute("newPost", postToEdit);
        return "/posts/create";
    }
}

