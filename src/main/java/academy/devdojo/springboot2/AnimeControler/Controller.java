package academy.devdojo.springboot2.AnimeControler;

import academy.devdojo.springboot2.DateUtil;
import academy.devdojo.springboot2.domain.Anime;
import academy.devdojo.springboot2.request.AnimePutRequestBody;
import academy.devdojo.springboot2.request.AnimeRequest;
import academy.devdojo.springboot2.service.AnimeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("animes")
@Log4j2
@RequiredArgsConstructor
public class Controller {
    @Autowired
    private final AnimeService animeService;
    @Autowired
    private DateUtil dateUtil;

    @GetMapping(path = "listall")
    public ResponseEntity<List<Anime>> animes(){
        return new ResponseEntity<>(animeService.listAll(), HttpStatus.OK);
    }
    @GetMapping(path = "/{id}")
    public ResponseEntity<Anime> findByid(@PathVariable long id){
        log.info(dateUtil.formatLocalDateTime(LocalDateTime.now()));
        return  ResponseEntity.ok(animeService.findByIdOrElseThrowBadRequest(id));
    }
    @PostMapping
    public ResponseEntity<Anime> animeSave(@RequestBody AnimeRequest anime ){
    return new ResponseEntity<>(animeService.save(anime), HttpStatus.CREATED);
    }
    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> deleteAnime(@PathVariable long id){

        animeService.delete(id);

        return new  ResponseEntity<>(HttpStatus.NO_CONTENT);
    }



    @PutMapping
    public ResponseEntity<Void> replace(@RequestBody AnimePutRequestBody animePutRequestBody){

        animeService.replace(animePutRequestBody);

        return new  ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
