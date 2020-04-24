package septembermarket.controllers;

import com.geekbrains.septembermarket.entities.User;
import com.geekbrains.septembermarket.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.security.Principal;

@Controller
public class MainController {
    @Autowired
    UserService userService;


    @GetMapping("/")
    public String index(Principal principal) {
        if(principal != null) {
            User user = userService.findByPhone(principal.getName());
            System.out.println(user.getEmail());
        }
        return "index";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/admin")
    @ResponseBody
    public String admin() {
        return "Hello";
    }
}
