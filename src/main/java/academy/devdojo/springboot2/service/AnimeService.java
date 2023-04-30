package academy.devdojo.springboot2.service;

import academy.devdojo.springboot2.DateUtil;
import academy.devdojo.springboot2.domain.Anime;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@Service
public class AnimeService {
    private static List<Anime> animes;
    static{
     animes = new ArrayList<>(List.of(new Anime(1L, "Boku No Hero"), new Anime(2L, "Berserk")));
    }


    // private final AnimeRepository animeRepository;
    public List<Anime> listAll() {
        return animes;
    }

    public Anime findById(long id) {
        return animes.stream()
                .filter(anime -> anime.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Anime not Found"));
    }

    public ResponseEntity<Anime> save(Anime anime) {
        anime.setId(ThreadLocalRandom.current().nextLong(3, 100000));
        animes.add(anime);
    return ResponseEntity.ok().build();


    }
}