package brianpelinku.u5w1d5_gestione_prenotazioni.repositories;

import brianpelinku.u5w1d5_gestione_prenotazioni.entities.PostazioneAziendale;
import brianpelinku.u5w1d5_gestione_prenotazioni.entities.Prenotazione;
import brianpelinku.u5w1d5_gestione_prenotazioni.entities.Utente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Repository
public interface PrenotazioneRepository extends JpaRepository<Prenotazione, Long> {
    boolean existsByNome(String nome);

    boolean existsByGiornoPrenotazione(LocalDate giornoPrenotazione);

    boolean existsByPostazioneAziendale(PostazioneAziendale postazioneAziendale);

    boolean existsByUtente(Utente utente);
}
