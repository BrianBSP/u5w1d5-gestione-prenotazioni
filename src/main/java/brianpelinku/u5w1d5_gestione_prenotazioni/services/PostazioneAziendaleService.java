package brianpelinku.u5w1d5_gestione_prenotazioni.services;

import brianpelinku.u5w1d5_gestione_prenotazioni.entities.PostazioneAziendale;
import brianpelinku.u5w1d5_gestione_prenotazioni.enums.TipoPostazione;
import brianpelinku.u5w1d5_gestione_prenotazioni.exceptions.NotFoundException;
import brianpelinku.u5w1d5_gestione_prenotazioni.exceptions.ValidationException;
import brianpelinku.u5w1d5_gestione_prenotazioni.repositories.PostazioneAziendaleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostazioneAziendaleService {
    @Autowired
    private PostazioneAziendaleRepository postazioneAziendaleRepository;

    public void savePostazione(PostazioneAziendale postazioneAziendale) {
        if (postazioneAziendaleRepository.existsByDescrizione(postazioneAziendale.getDescrizione()))
            throw new ValidationException("La postazione " + postazioneAziendale.getDescrizione() + " già esistente nel DB");
        postazioneAziendaleRepository.save(postazioneAziendale);
        System.out.println("La postazione " + postazioneAziendale.getDescrizione() + " salvato Correttamente nel DB");
    }

    public PostazioneAziendale findById(long postazioneId) {
        return postazioneAziendaleRepository.findById(postazioneId).orElseThrow(() -> new NotFoundException(postazioneId));
    }

    public void findByIdAndDelete(long postazioneId) {
        PostazioneAziendale found = this.findById(postazioneId);
        postazioneAziendaleRepository.delete(found);
        System.out.println("La postazione con id " + postazioneId + " è stato eliminato correttamente dal DB.");
    }

    public List<PostazioneAziendale> findPostazioniByTipoCitta(TipoPostazione tipoPostazione, String citta) {
        return postazioneAziendaleRepository.findPostazioniByTipoECitta(tipoPostazione, citta);
    }
}
