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

        // controlla se c'è una prenotazione con lo stesso nome
        if (prenotazioneRepository.existsByNome(prenotazione.getNome()))
            throw new ValidationException("La prenotazione " + prenotazione.getNome() + " già esistente nel DB");
        // controlla se c'è una prenotazione con lo stesso giorno
        if (prenotazioneRepository.existsByGiornoPrenotazione(prenotazione.getGiornoPrenotazione()))
            throw new ValidationException("La prenotazione del " + prenotazione.getGiornoPrenotazione() + " già esistente nel DB");
        // controlla se c'è una prenotazione con lo stesso utente
        if (prenotazioneRepository.existsByPostazioneAziendale(prenotazione.getPostazioneAziendale()))
            throw new ValidationException("La prenotazione nella postazione " + prenotazione.getPostazioneAziendale() + " già esistente nel DB");
        // controlla se c'è una prenotazione con la stessa postazione
        if (prenotazioneRepository.existsByUtente(prenotazione.getUtente()))
            throw new ValidationException("La prenotazione di " + prenotazione.getUtente() + " già esistente nel DB");
        prenotazioneRepository.save(prenotazione);
        System.out.println("La prenotazione " + prenotazione.getNome() + " salvato Correttamente nel DB");
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
