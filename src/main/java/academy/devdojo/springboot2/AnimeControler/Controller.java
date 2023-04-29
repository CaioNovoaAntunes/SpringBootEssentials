package academy.devdojo.springboot2.AnimeControler;

import academy.devdojo.springboot2.DateUtil;
import academy.devdojo.springboot2.domain.Anime;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("anime")
@Log4j2
@AllArgsConstructor
public class Controller {

    @Autowired
    private DateUtil dateUtil;

    @GetMapping(path = "list")
    public List<Anime> animes(){
        log.info(dateUtil.formatLocalDateTime(LocalDateTime.now()));
        return List.of(new Anime("Dbz"), new Anime("Bersker"),  new Anime("Bersker2"));
    }
}
