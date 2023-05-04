package in.ashokit.binding;


import lombok.Data;

@Data
public class SignUpForm {
    private String userEmail;
    private String userFirstName;
    private String userLastName;
    private String userPwd;
}
