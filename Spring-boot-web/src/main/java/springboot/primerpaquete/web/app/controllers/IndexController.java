package springboot.primerpaquete.web.app.controllers;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class IndexController {
    @GetMapping({"/index","/","/home"})
    public String index(){
        return "index";
    }
}
