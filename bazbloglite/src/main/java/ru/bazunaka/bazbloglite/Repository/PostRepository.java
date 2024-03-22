package ru.bazunaka.bazbloglite.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.bazunaka.bazbloglite.Entity.Post;

public interface PostRepository extends JpaRepository<Post, Long> {
}
