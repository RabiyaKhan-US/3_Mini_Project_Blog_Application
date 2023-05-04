package in.ashokit.entities;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Setter
@Getter
@Table(name = "POST_TBL")
public class PostEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer postId;
    private String description;
    private String title;
    @Lob
    private String content;
    @CreationTimestamp
    private LocalDate postCreatedDate;
    @UpdateTimestamp
    private LocalDate postUpdatedDate;

    @OneToMany(mappedBy = "post", cascade = CascadeType.REMOVE)
    private List<CommentsEntity> comments;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserDetailsEntity user;
}
