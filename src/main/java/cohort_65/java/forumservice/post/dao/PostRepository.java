package cohort_65.java.forumservice.post.dao;

import cohort_65.java.forumservice.post.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.Set;

public interface PostRepository extends JpaRepository<Post, Long> {
    Iterable<Post> findAllByAuthorIgnoreCase(String author);
    Iterable<Post> findAllByTagsIn(Set<String> tags);
    Iterable<Post> findAllByDateCreatedBetween(LocalDateTime from, LocalDateTime to);
}
