package main.controller;

import main.service.MyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author The Weather Company, An IBM Business
 */
@RestController
public class MainController {

    final MyService myService;

    @Autowired
    public MainController(MyService myService) {
        this.myService = myService;
    }

    @GetMapping(value = "/data")
    public String getData(){
        myService.save();
        return "Hello world";
    }
}
