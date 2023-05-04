package in.ashokit.repo;

import in.ashokit.entities.UserDetailsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDetailsRepo extends JpaRepository<UserDetailsEntity, Integer>  {
    public UserDetailsEntity findByuserEmail(String userEmail);

    @Query("select u from UserDetailsEntity u where u.userEmail=:e and u.userPwd=:p")
    public UserDetailsEntity findByuserEmailAnduserPwd(@Param("e")String userEmail, @Param("p")String userPwd);

}