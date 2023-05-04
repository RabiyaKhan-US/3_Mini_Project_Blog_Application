package in.ashokit.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Table(name = "USER_TBL")
@Getter
@Setter
@Entity
public class UserDetailsEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userId;
    private String userEmail;
    private String userFirstName;
    private String userLastName;
    private String userPwd;
}
