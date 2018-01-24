package demo.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;

@Controller
@RequestMapping(value = "/users")
public class AppController {

    /**
     * http://localhost:8080/users/bob
     * @param id
     * @return
     */
    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
    public String userProfile(@PathVariable(value = "id") String id ,Model model) {
        model.addAttribute("title", "This is a blog with id = " + id);
        return "echart" ;
    }

    /**
     * http://localhost:8080/users/user?id=3
     * @param blogId
     * @return
     */
    @RequestMapping(value = "/user")
    @ResponseBody
    public String setupForm(@RequestParam(name="id",required = false,defaultValue = "1") int blogId ) {
        return String.format("blog id = %d", blogId);
    }

    /**
     * http://localhost:8080/users/create
     * @return
     */
    @RequestMapping("/create")
    public String create(){
        return "echart";
    }
}
