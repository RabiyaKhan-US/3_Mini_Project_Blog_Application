package in.ashokit.controllers;

import in.ashokit.binding.LoginForm;
import in.ashokit.binding.Posts;
import in.ashokit.binding.SignUpForm;
import in.ashokit.entities.UserDetailsEntity;
import in.ashokit.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/login")
    public String loginPage(Model model) {
        model.addAttribute("loginForm", new LoginForm());
        return "login";
    }

    @PostMapping("/login")
    public String login(@ModelAttribute("loginForm") LoginForm loginForm, Model model) {
        String status = userService.login(loginForm);
        if(status.contains("success")){
            // Redirect request  to dashboard
            return "dashboard";
        }
        model.addAttribute("errMessage", status);
        return "login";

    }

    @GetMapping("/signup")
    public String signPage(Model model) {
        model.addAttribute("user", new SignUpForm());
        return "signup";
    }

    @PostMapping("/signup")
    public String handleSignUp(@ModelAttribute("user") SignUpForm signUpForm, Model model) {
        boolean status = userService.signup(signUpForm);
        if (status) {
            model.addAttribute("Success", "Registration Successful");
        } else {
            model.addAttribute("ErrMessage", "Registration Failed");
        }
        return "signup";

    }

    @GetMapping("/blogs")
    public String blogPage(Model model) {
        model.addAttribute("user", new Posts());
        return "blog-page";
    }

}
