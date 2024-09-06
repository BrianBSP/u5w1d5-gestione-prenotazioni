package brianpelinku.u5w1d5_gestione_prenotazioni.services;

import brianpelinku.u5w1d5_gestione_prenotazioni.repositories.PostazioneAziendaleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostazioneAziendaleService {
    @Autowired
    private PostazioneAziendaleRepository postazioneAziendaleRepository;
}
