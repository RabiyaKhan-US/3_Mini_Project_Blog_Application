package in.ashokit.services;

import in.ashokit.binding.LoginForm;
import in.ashokit.binding.SignUpForm;
import in.ashokit.entities.UserDetailsEntity;
import org.springframework.stereotype.Service;

@Service
public interface UserService {

    public String login(LoginForm loginForm);


    public boolean signup(SignUpForm signupForm);

}
