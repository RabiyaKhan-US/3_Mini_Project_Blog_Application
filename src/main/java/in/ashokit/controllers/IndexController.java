package in.ashokit.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

public class IndexController {

        @GetMapping("/")
        public String indexPage(){
            return "index";
        }

    }
