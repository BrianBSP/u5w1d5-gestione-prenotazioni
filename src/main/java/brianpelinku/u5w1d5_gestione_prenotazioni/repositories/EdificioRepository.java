package brianpelinku.u5w1d5_gestione_prenotazioni.repositories;

import brianpelinku.u5w1d5_gestione_prenotazioni.entities.Edificio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EdificioRepository extends JpaRepository<Edificio, Long> {

    boolean existsByNome(String nome);

    @Query("SELECT e FROM Edificio e")
    List<Edificio> findAllEdifici();
}
