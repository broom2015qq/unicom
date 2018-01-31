package demo.controller;

import demo.model.User;
import demo.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Api(value = "用户管理", tags = {"用户管理API"}, description = "描述信息")
@Controller
public class UserController {

    private Logger logger = Logger.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    /*
     *  http://localhost:8080/getUserInfo
     */
    @ApiOperation(value = "获得用户信息", notes = "获得用户列表notes", produces = "application/json")
    @RequestMapping(value = "/getUserInfo",method = RequestMethod.GET)
    @ResponseBody
    public User getUserInfo() {
        User user = userService.getUserInfo();
        if(user!=null){
            System.out.println("user.getName():"+user.getName());
            logger.info("user.getAge():"+user.getAge());
        }
        return user;
    }

    @ApiOperation(value = "获得用户信息方法2", notes = "获得用户列表notes", produces = "application/json")
    @RequestMapping(value = "/getUser",method = RequestMethod.GET)
    public String getUser(Model model) {
        User user = userService.getUserInfo();
        if(user!=null){
            System.out.println("user.getName():"+user.getName());
            logger.info("user.getAge():"+user.getAge());
        }
        model.addAttribute("user",user);
        return "echart";
    }
}