package jakira.springblog.controllers;

public class ViewsLec {
    /*
    Thymleaf:
    Known s natural templates
    Uses th: prefex in the HTML File


Path variable is :
@GetMapping("/hello/{name}")
public String sayHello(@PathVariable String name, Model model) {
    model.addAttribute("name", name);
    return "hello";
}

Model represents the tpe of page we are working with.
This allows information to be passed into the view
The quotation os what it will look on our page and the variable is the variable we created.

    GET/POST Request:
 @GetMapping("/join")
    public String showJoinForm() {
        return "join";
    }

    @PostMapping("/join")
    public String joinCohort(@RequestParam(name = "cohort") String cohort, Model model) {
        model.addAttribute("cohort", "Welcome to " + cohort + "!");
        return "join";
    }

    Post mapping has to correspod with the from in the HTML
    Request param is to accept the info that is inputted in the form

    It will take what is inputted and give it the value and the inputted text will reflect

    each and if tag
    each:
    give list of each of th object/ item we wanted
    Array list need to be created to have numerous of items to show
    That array list has to be attached to the view

    Partials:
This is to include templates





     */




}
