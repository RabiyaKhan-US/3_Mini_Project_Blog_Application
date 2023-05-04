package in.ashokit.entities;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Setter
@Getter
@Table(name = "COMMENTS_TBL")
public class CommentsEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer CId;
    @CreationTimestamp
    private LocalDate createdDate;
    @Lob
    private String commentDesc;
    private String userName;
    private String email;


    @ManyToOne
    @JoinColumn(name = "post_id")
    private PostEntity post;

}
