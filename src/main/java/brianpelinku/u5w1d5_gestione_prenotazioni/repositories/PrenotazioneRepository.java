package brianpelinku.u5w1d5_gestione_prenotazioni.repositories;

import brianpelinku.u5w1d5_gestione_prenotazioni.entities.Prenotazione;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PrenotazioneRepository extends JpaRepository<Prenotazione, Long> {
    boolean existsByNome(String nome);
}
