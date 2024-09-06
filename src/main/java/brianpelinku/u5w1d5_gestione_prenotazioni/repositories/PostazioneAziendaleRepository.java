package brianpelinku.u5w1d5_gestione_prenotazioni.repositories;

import brianpelinku.u5w1d5_gestione_prenotazioni.entities.PostazioneAziendale;
import brianpelinku.u5w1d5_gestione_prenotazioni.enums.TipoPostazione;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostazioneAziendaleRepository extends JpaRepository<PostazioneAziendale, Long> {
    boolean existsByDescrizione(String descrizione);

    @Query("SELECT p FROM PostazioneAziendale p JOIN Edificio e " +
            "WHERE p.tipoPostazione = :tipoPostazione AND e.citta = :citta")
    List<PostazioneAziendale> findPostazioniByTipoECitta(@Param("tipoPostazione") TipoPostazione tipoPostazione, @Param("citta") String citta);
}
