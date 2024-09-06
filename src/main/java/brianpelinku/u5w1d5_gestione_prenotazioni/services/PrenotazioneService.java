package brianpelinku.u5w1d5_gestione_prenotazioni.services;

import brianpelinku.u5w1d5_gestione_prenotazioni.entities.Prenotazione;
import brianpelinku.u5w1d5_gestione_prenotazioni.exceptions.NotFoundException;
import brianpelinku.u5w1d5_gestione_prenotazioni.exceptions.ValidationException;
import brianpelinku.u5w1d5_gestione_prenotazioni.repositories.PrenotazioneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PrenotazioneService {
    @Autowired
    private PrenotazioneRepository prenotazioneRepository;

    public void savePrenotazione(Prenotazione prenotazione) {
        if (prenotazioneRepository.existByNome(prenotazione.getNome()))
            throw new ValidationException("La prenotazione " + prenotazione.getNome() + " già esistente nel DB");
        prenotazioneRepository.save(prenotazione);
    }

    public Prenotazione findById(long prenotazioneId) {
        return prenotazioneRepository.findById(prenotazioneId).orElseThrow(() -> new NotFoundException(prenotazioneId));
    }

    public void findByIdAndDelete(long prenotazioneId) {
        Prenotazione found = this.findById(prenotazioneId);
        prenotazioneRepository.delete(found);
        System.out.println("La prenotazione con id " + prenotazioneId + " è stato eliminato correttamente dal DB.");
    }
}
