package academy.devdojo.springboot2.repository;


import academy.devdojo.springboot2.domain.Anime;
import org.springframework.data.annotation.Id;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AnimeRepository extends JpaRepository<Anime, Long> {
}