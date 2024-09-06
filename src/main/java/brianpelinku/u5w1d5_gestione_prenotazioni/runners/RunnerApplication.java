package brianpelinku.u5w1d5_gestione_prenotazioni.runners;

import brianpelinku.u5w1d5_gestione_prenotazioni.services.EdificioService;
import brianpelinku.u5w1d5_gestione_prenotazioni.services.PostazioneAziendaleService;
import brianpelinku.u5w1d5_gestione_prenotazioni.services.PrenotazioneService;
import brianpelinku.u5w1d5_gestione_prenotazioni.services.UtenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class RunnerApplication implements CommandLineRunner {

    @Autowired
    private EdificioService edificioService;

    @Autowired
    private PostazioneAziendaleService postazioneAziendaleService;

    @Autowired
    private PrenotazioneService prenotazioneService;

    @Autowired
    private UtenteService utenteService;



    @Override
    public void run(String... args) throws Exception {

    }
}
