package com.Step07.springboot.myFirstApp.Hello;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SayHelloController {
    @RequestMapping("say-hello")
    @ResponseBody
    public String sayhello(){
        return "Hello! What are you learning today ?";
    }

    @RequestMapping("say-hello-html")
    @ResponseBody
    public String sayCodeHtml(){
        StringBuffer sb = new StringBuffer();
        sb.append("<html>");
        sb.append("<head>");
        sb.append("<title> My First Html Page </title>");
        sb.append("</head>");
        sb.append("<body>");
        sb.append("<h1>Hello, World!</h1>");
        sb.append("</body>");
        sb.append("</html>");
        return sb.toString();
    }

    @RequestMapping("say-hello-jsp")
    public String sayHelloJPS(){
        return "sayHello";
    }

}
