package pl.aionpb.aionpb_vps.translation.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import pl.aionpb.aionpb_vps.translation.entity.TranslationEntity;
import pl.aionpb.aionpb_vps.translation.repository.TranslationRepository;

import java.util.Optional;

/**
 * @author Grzegorz Nowakowski
 */
@RestController
public class TranslationApiController {

    @Autowired
    TranslationRepository translationRepository;

    @GetMapping("/api/translation/{name}")
    public ResponseEntity<TranslationEntity> getTranslationByNameApi(@PathVariable("name") String name) {
        Optional<TranslationEntity> translation = Optional.ofNullable(translationRepository.findByName(name));

        return translation.map(TranslationEntity -> new ResponseEntity<>(TranslationEntity, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

}
