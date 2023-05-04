package in.ashokit.services;

import in.ashokit.binding.LoginForm;
import in.ashokit.binding.SignUpForm;
import in.ashokit.constants.AppConstants;
import in.ashokit.entities.UserDetailsEntity;
import in.ashokit.repo.UserDetailsRepo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDetailsRepo urepo;

    @Autowired
    private HttpSession session;


    @Override
    public String login(LoginForm loginForm) {
        UserDetailsEntity entity = urepo.findByuserEmailAnduserPwd(loginForm.getUserEmail(),loginForm.getUserPwd());

        if(entity == null){
            return AppConstants.INVALID_CRED;
        }
        session.setAttribute(AppConstants.USERID, entity.getUserId());
        return AppConstants.SUCCESS;
    }

    @Override
    public boolean signup(SignUpForm signupForm) {

       UserDetailsEntity userEntity =  urepo.findByuserEmail(signupForm.getUserEmail());

        if(userEntity!= null){
            return false;
        }
        // Todo: 1. Copy data from binding object to entity object
        UserDetailsEntity entity = new UserDetailsEntity();
        BeanUtils.copyProperties(signupForm, entity);
        urepo.save(entity);
        return true;
    }
}
