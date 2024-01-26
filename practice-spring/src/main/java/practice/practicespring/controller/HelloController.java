package practice.practicespring.controller;

import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {
    @GetMapping("hello")
    public String hello(Model model){
        model.addAttribute("data", "hello!!!!");
        return "templeteHello";
    }

    @GetMapping("hello-mvc")
    public String helloMvc(@RequestParam("name") String name, Model model){
        model.addAttribute("name", name);
        return "hello-template";
    }
    @GetMapping("hello-string")
    @ResponseBody
    // html을 거치지 않고 api 방식으로 조작하는 방식, 데이터를 그대로 내려줌.
    public String helloString(@RequestParam("name") String name){
        return "hello" + name; // "hello spring"
    }
    @GetMapping("hello-api")
    @ResponseBody
    public Hello helloApi(@RequestParam("name") String name){
        // 객체가 오면 기본 방식 즉 default에서는 json으로 만들어서 반환합니다.
        Hello hello = new Hello();
        hello.setName(name);
        return hello;
    }

    static class Hello {
        private String name;
        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

    }

}
