package demo.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(value = "/users")
public class AppController {

    /**
     * http://localhost:8080/users/bob
     * @param user
     * @return
     */
    @RequestMapping(value = "/{username}", method = RequestMethod.GET)
    @ResponseBody
    public String userProfile(@PathVariable(value = "username") String user) {
        return user;
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
