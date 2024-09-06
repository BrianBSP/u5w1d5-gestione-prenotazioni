package brianpelinku.u5w1d5_gestione_prenotazioni.runners;

import brianpelinku.u5w1d5_gestione_prenotazioni.U5w1d5GestionePrenotazioniApplication;
import brianpelinku.u5w1d5_gestione_prenotazioni.entities.Edificio;
import brianpelinku.u5w1d5_gestione_prenotazioni.entities.PostazioneAziendale;
import brianpelinku.u5w1d5_gestione_prenotazioni.entities.Prenotazione;
import brianpelinku.u5w1d5_gestione_prenotazioni.entities.Utente;
import brianpelinku.u5w1d5_gestione_prenotazioni.enums.TipoPostazione;
import brianpelinku.u5w1d5_gestione_prenotazioni.services.EdificioService;
import brianpelinku.u5w1d5_gestione_prenotazioni.services.PostazioneAziendaleService;
import brianpelinku.u5w1d5_gestione_prenotazioni.services.PrenotazioneService;
import brianpelinku.u5w1d5_gestione_prenotazioni.services.UtenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

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
            Utente utente2 = context.getBean("aldo_baglio", Utente.class);
//            utenteService.saveUtente(utente1);
//            utenteService.saveUtente(utente2);

            Edificio edificio1 = context.getBean("edificio_empire_state", Edificio.class);
            Edificio edificio2 = context.getBean("palazzo_reale", Edificio.class);
//            edificioService.saveEdificio(edificio1);
//            edificioService.saveEdificio(edificio2);

            PostazioneAziendale postazione1 = new PostazioneAziendale("sala riunione grande", TipoPostazione.SALA_RIUNIONE, 10, true, edificioService.findById(1));
            PostazioneAziendale postazione2 = new PostazioneAziendale("sala open space", TipoPostazione.OPEN_SPACE, 50, true, edificioService.findById(2));
//            postazioneAziendaleService.savePostazione(postazione1);
//            postazioneAziendaleService.savePostazione(postazione2);

            Prenotazione prenotazione1 = new Prenotazione("prenoto sala riunione", LocalDate.of(2024, 9, 8), utenteService.findById(1), postazioneAziendaleService.findById(3));
            Prenotazione prenotazione2 = new Prenotazione("prenoto sala open space", LocalDate.of(2024, 10, 20), utenteService.findById(2), postazioneAziendaleService.findById(4));
            prenotazioneService.savePrenotazione(prenotazione1);
            prenotazioneService.savePrenotazione(prenotazione2);


        } catch (Exception e) {
            System.err.println(e.getMessage());
        } finally {
            context.close();
        }


    }
}
