package jakira.springblog.repositories;

import jakira.springblog.models.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface PostRepository extends JpaRepository<Post, Long> {
    @Query("from Post d where d.title like %:title")
    List<Post> searchByTitle(@Param("title") String title);
}
