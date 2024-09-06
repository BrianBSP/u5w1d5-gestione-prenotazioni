package brianpelinku.u5w1d5_gestione_prenotazioni.runners;

import brianpelinku.u5w1d5_gestione_prenotazioni.U5w1d5GestionePrenotazioniApplication;
import brianpelinku.u5w1d5_gestione_prenotazioni.entities.Edificio;
import brianpelinku.u5w1d5_gestione_prenotazioni.entities.Utente;
import brianpelinku.u5w1d5_gestione_prenotazioni.services.EdificioService;
import brianpelinku.u5w1d5_gestione_prenotazioni.services.PostazioneAziendaleService;
import brianpelinku.u5w1d5_gestione_prenotazioni.services.PrenotazioneService;
import brianpelinku.u5w1d5_gestione_prenotazioni.services.UtenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
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

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(U5w1d5GestionePrenotazioniApplication.class);

        try {

            Utente utente1 = context.getBean("paolo_rossi", Utente.class);
//            utenteService.saveUtente(utente1);
            Utente utente2 = context.getBean("aldo_baglio", Utente.class);
//            utenteService.saveUtente(utente2);

            Edificio edificio1 = context.getBean("edificio_empire_state", Edificio.class);
//            edificioService.saveEdificio(edificio1);
            Edificio edificio2 = context.getBean("palazzo_reale", Edificio.class);
//            edificioService.saveEdificio(edificio2);


        } catch (Exception e) {
            System.err.println(e.getMessage());
        } finally {
            context.close();
        }


    }
}
