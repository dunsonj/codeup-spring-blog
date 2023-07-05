package jakira.springblog.models;

import jakarta.persistence.*;
import lombok.*;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString

@Entity
@Table(name = "Children")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "Child_Name", length = 100, nullable = false)
    private String name;

    @Column(nullable = false)
    private int age;

    @Column(length = 255)
    private String parents;


    private String title;
    private String body;

    public String getTitle() {
        return title;
    }
    public Post(String title, String body) {
        this.title = title;
        this.body = body;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getBody() {
        return body;
    }
    public void setBody(String body) {
        this.body = body;
    }


}