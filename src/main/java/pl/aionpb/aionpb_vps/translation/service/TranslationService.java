package pl.aionpb.aionpb_vps.translation.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.aionpb.aionpb_vps.translation.entity.TranslationEntity;
import pl.aionpb.aionpb_vps.translation.repository.TranslationRepository;

/**
 * @author Grzegorz Nowakowski
 */
@Service
public class TranslationService {

    @Autowired
    private TranslationRepository translationRepository;

    public TranslationEntity findByName(String name) {

        TranslationEntity translationEntity = translationRepository.findByName(name);

        if (translationEntity == null) {
            //getting rid of npe
            translationEntity = new TranslationEntity();
        }

        return translationEntity;
    }
}
