package academy.devdojo.springboot2.service;

import academy.devdojo.springboot2.DateUtil;
import academy.devdojo.springboot2.domain.Anime;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

@Log4j2
@Component
public class AnimeService {
    // private AnimeRepository animeRepository;
    @Autowired
    private DateUtil dateUtil;

    public List<Anime> list(){
        log.info(dateUtil.formatLocalDateTime(LocalDateTime.now()));
        return List.of(new Anime(1L,"Dbz"), new Anime(2L,"Bersker"),  new Anime(3L,"Bersker2"));
    }

}
