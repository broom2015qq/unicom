package demo.controller;
import demo.model.HelloMessage;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
@Controller
public class SayHelloController {

    /**
     * 显示表单页面sayhello
     * @param model
     * @return
     */
    @RequestMapping(value="/sayhello", method=RequestMethod.GET)
    public String sayHelloForm(Model model) {
        model.addAttribute("helloMessage", new HelloMessage());
        return "sayhello";
    }

    /**
     * 收到提交请求，将数据渲染到message
     * @param helloMessage
     * @param model
     * @return
     */
    @RequestMapping(value="/sayhello", method=RequestMethod.POST)
    public String sayHello(@ModelAttribute HelloMessage helloMessage, Model model) {
        model.addAttribute("helloMessage", helloMessage);
        return "message";
    }

}
