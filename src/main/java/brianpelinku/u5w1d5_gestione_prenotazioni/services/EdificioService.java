package brianpelinku.u5w1d5_gestione_prenotazioni.services;

import brianpelinku.u5w1d5_gestione_prenotazioni.entities.Edificio;
import brianpelinku.u5w1d5_gestione_prenotazioni.exceptions.NotFoundException;
import brianpelinku.u5w1d5_gestione_prenotazioni.exceptions.ValidationException;
import brianpelinku.u5w1d5_gestione_prenotazioni.repositories.EdificioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EdificioService {
    @Autowired
    private EdificioRepository edificioRepository;

    public void saveEdificio(Edificio edificio) {
        if (edificioRepository.existsByNome(edificio.getNome()))
            throw new ValidationException("L'edificio " + edificio.getNome() + " già esistente nel DB");
        edificioRepository.save(edificio);
        System.out.println("L'edificio " + edificio.getNome() + " salvato Correttamente nel DB");
    }

    public Edificio findById(long edificioId) {
        return edificioRepository.findById(edificioId).orElseThrow(() -> new NotFoundException(edificioId));
    }

    public void findByIdAndDelete(long edificioId) {
        Edificio found = this.findById(edificioId);
        edificioRepository.delete(found);
        System.out.println("L'edificio con id " + edificioId + " è stato eliminato correttamente dal DB.");
    }

}
