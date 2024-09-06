package brianpelinku.u5w1d5_gestione_prenotazioni.services;

import brianpelinku.u5w1d5_gestione_prenotazioni.entities.Utente;
import brianpelinku.u5w1d5_gestione_prenotazioni.exceptions.NotFoundException;
import brianpelinku.u5w1d5_gestione_prenotazioni.exceptions.ValidationException;
import brianpelinku.u5w1d5_gestione_prenotazioni.repositories.UtenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UtenteService {
    @Autowired
    private UtenteRepository utenteRepository;

    public void saveUtente(Utente utente) {
        if (utenteRepository.existsByUsername(utente.getUsername()))
            throw new ValidationException("L'utente " + utente.getUsername() + " già esistente nel DB");
        utenteRepository.save(utente);
        System.out.println("L'utente " + utente.getUsername() + " salvato Correttamente nel DB");
    }

    public Utente findById(long utenteId) {
        return utenteRepository.findById(utenteId).orElseThrow(() -> new NotFoundException(utenteId));
    }

    public void findByIdAndDelete(long utenteId) {
        Utente found = this.findById(utenteId);
        utenteRepository.delete(found);
        System.out.println("L'utente con id " + utenteId + " è stato eliminato correttamente dal DB.");
    }
}
