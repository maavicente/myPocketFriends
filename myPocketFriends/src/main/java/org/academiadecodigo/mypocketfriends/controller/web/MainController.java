package org.academiadecodigo.mypocketfriends.controller.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class MainController {


    @RequestMapping("/maiiiiiinnnnnnnn")
    public String home() {
        return "redirect:/kid/list";
    }
}
