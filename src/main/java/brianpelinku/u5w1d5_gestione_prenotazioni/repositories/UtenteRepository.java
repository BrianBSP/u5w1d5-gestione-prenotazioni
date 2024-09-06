package brianpelinku.u5w1d5_gestione_prenotazioni.repositories;

import brianpelinku.u5w1d5_gestione_prenotazioni.entities.Utente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UtenteRepository extends JpaRepository<Utente, Long> {
    boolean existsByUsername(String username);
}
