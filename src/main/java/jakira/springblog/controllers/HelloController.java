package jakira.springblog.controllers;

import jakira.springblog.models.Item;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller //tells the machine that this class is a controller. Needs to be hocked up and loaded.
//@RequestMapping(path = "/hello")// this is telling the class they are alll going to start w /hello, if the url has something diff it will show on the get mapping of the methods
public class HelloController {
    /*
    Type in application /hello
    it will return the screen Hello World! (What the browser will display)

    If query parameter added it will show
    ex:
    /hello?name=bob will show Hello bob!
    /hello/bob ill show Hello bob!

    GET /ads will show list of ads
    GET /ads?param=val search for subset of ads using prameter
    GET /ads/1 will show page with te ad tht has id 1
    GET /ads/create  show page to add an ad
    GET /ads/1/edit  show page to update ad with id 1
    POST /ads/create  show page to add an ad
    PUT /ads/1 crete update an existing ad with id 1
    DELETE /ads/1 delete existing ad with id 1
     */
//
//    First one
//
//    One controller can control multiple end points, the name should infer what the controller infers
//
//    //Request get request
//    @GetMapping() //to trigger the method underneath. The url. If sees ur as a get request it will show the body on the browser.
//    @ResponseBody  //we need to tell spring the body is the body of HTML browser
//
//    public String sayHello(@RequestParam @Nullable String name){
//        if (name == null){
//            name = "world";
//        } // removes the word null
//        return getHelloString(name);
//
//        /*@RequestParam String personName Adds query parameters that gives it s string
//         url has to have /hello?name=bob, the bob can be changed to anything, this is to show on the web browser
//        @Nullable allows parameter to be called without a name
//         */
//
//        /*
//        Send over a path variable
//         */
//
//    }
//
//    @GetMapping("/{personName}")
//    @ResponseBody
//    public String sayHelloToName(@PathVariable String personName){
//        if (personName == null){
//            personName = "world";
//        }
//        return getHelloString(personName);
//    }
//
//    private String getHelloString (String peronName){
//        return "<h1>Hello " + peronName + "!</h1>";
//
//        /*
//        return  "<h1>Hello " + personName + "!</h1>";
//        return  "<h1>Hello " + name + "!</h1>";
//
//        This prevents the code from getting complex, instead of  returing the <1> elements
//        you will call the last method and it will make it simpler
//         */
//    }
//

@GetMapping("/hello/{name}")
public String sayHello(@PathVariable String name, Model model) {
    model.addAttribute("name", name);
    return "hello";
}

    @GetMapping("/join")
    public String showJoinForm(Model model) {
        List<Item> shoppingCart = new ArrayList<>();
        shoppingCart.add(new Item("screwdriver"));
        shoppingCart.add(new Item("hammer"));
//        shoppingCart.add(new Item("drill"));
        model.addAttribute("shoppingCart", shoppingCart);
        return "join";
    }

    @PostMapping("/join")
    public String joinCohort(@RequestParam(name = "cohort") String cohort, Model model) {
        model.addAttribute("cohort", "Welcome to " + cohort + "!");
        return "join";
    }



}
