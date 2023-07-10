package jakira.springblog.models;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

@Entity
@Table(name = "blog_users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.Identity)
    private long id;

    @Column (nullable = false)
    private String email;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String password;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "creator")
    private List<Post> posts;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "parentUser")
    private List<Ad> Ads;

}
