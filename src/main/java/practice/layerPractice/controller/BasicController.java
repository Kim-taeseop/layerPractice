package practice.layerPractice.controller;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class BasicController {

    // 정적 방식 기초
    @GetMapping("basic/hello")
    public String hello(Model model){
        model.addAttribute("data", "Hello!!!");
        return "basic/hello";
    }

    // mvc 방식 기초
    @GetMapping("basic/hello-mvc")
    public String helloMvc(@RequestParam(value = "name", required = false) String name, Model model){
        name = "김태섭";
        model.addAttribute("name", name);
        return "basic/hello-mvc";
    }

    /*
    String 방식
    html 바디에 직접 입력하는 방식
    View 없이 리턴값이 바로 나감
     */
    @GetMapping("basic/hello-string")
    @ResponseBody
    public String helloString(@RequestParam("name") String name){
        return "hello " + name;
    }

    /*
    API 방식
    String 방식에서 리턴값이 문자대신 데이터
    Json 사용
    Json : 키와 벨류로 구성된 방식
    {"name":"spring!"} 이런식으로 구성
     */
    @GetMapping("basic/hello-api")
    @ResponseBody
    public Hello helloApi(@RequestParam("name") String name){
        Hello hello = new Hello();
        hello.setName(name);
        return hello;
    }


    @Getter
    @Setter
    static class Hello{
        private String name;
    }
}
