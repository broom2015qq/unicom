package demo.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import demo.model.HelloMessage;
import demo.model.searchid;
import demo.service.*;
import org.springframework.boot.jackson.JsonObjectDeserializer;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class AppController {

    @Resource
    private ReadjsonService readjsonService;

    /**
     * 输入id查询
     * @param model
     * @return
     */
    @RequestMapping(value="/echart", method=RequestMethod.GET)
    public String sayHelloForm(Model model) {
        model.addAttribute("searchid", new searchid());
        return "index";
    }

    @RequestMapping(value="/echart", method=RequestMethod.POST)
    public String sayHello(@ModelAttribute searchid searchid, Model model) {
        model.addAttribute("searchid", searchid);
        System.out.println("这里打印出"+searchid.getId());
        //拿到了id，写处理逻辑，返回json
        return "echart";
    }

    @RequestMapping(value = "/get",method = RequestMethod.GET)
    public ModelAndView showchart(HttpServletRequest req, HttpServletResponse resp, ModelMap model){
        String data = JSON.parseObject(readjsonService.getData()).toString();
        model.addAttribute("option", data);
        return new ModelAndView("echart",model);
    }

    @RequestMapping(value = "/idQuery",method = {RequestMethod.GET,RequestMethod.POST})
    public String findById(ModelMap modelMap,searchid searchid){
        String data = readjsonService.getData();
        modelMap.addAttribute("data", data);
        return "index1";
//        return "echart1";
//        return "tmp";
    }

    /**
     * http://localhost:8080/users/bob
     * @param id
     * @return
     */
    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
    public String userProfile(@PathVariable(value = "id") String id ,Model model) {
        JSONObject data = new JSONObject();
        data = JSON.parseObject(readjsonService.getData());
        model.addAttribute("data", data);
        return "echart" ;
    }

    /**
     * http://localhost:8080/users/user?id=3
     * @param blogId
     * @return
     */
    @RequestMapping(value = "/user")
    public String setupForm(@RequestParam(name="id",required = false,defaultValue = "1") int blogId ,Model model) {
        JSONObject data = new JSONObject();
        data = JSON.parseObject(readjsonService.getData());
        model.addAttribute("data", data);
        return "echart" ;
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
