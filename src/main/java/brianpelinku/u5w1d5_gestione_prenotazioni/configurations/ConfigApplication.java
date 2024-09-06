package brianpelinku.u5w1d5_gestione_prenotazioni.configurations;

import brianpelinku.u5w1d5_gestione_prenotazioni.entities.Edificio;
import brianpelinku.u5w1d5_gestione_prenotazioni.entities.Utente;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("application.properties")
public class ConfigApplication {

    // edifici
    @Bean("edificio_empire_state")
    public Edificio empireState() {
        return new Edificio("empireState", "via le mani", "Roma");
    }

    @Bean("palazzo_reale")
    public Edificio palazzoReale() {
        return new Edificio("palazzo_reale", "piazza grande", "Milano");
    }

    // utenti
    @Bean("paolo_rossi")
    public Utente paoloRossi() {
        return new Utente("paoloRossi1", "Paolo Rossi", "paolo@rossi.it");
    }

    @Bean("aldo_baglio")
    public Utente aldoBaglio() {
        return new Utente("aldoBaglio2", "Aldo Baglio", "aldo@baglio.it");
    }

}
