package brianpelinku.u5w1d5_gestione_prenotazioni.entities;


import brianpelinku.u5w1d5_gestione_prenotazioni.enums.TipoPostazione;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "postazioni_aziendali")
public class PostazioneAziendale {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private long id;
    @Column(name = "descrizione", nullable = false)
    private String descrizione;

    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_postazione", nullable = false)
    private TipoPostazione tipoPostazione;
    @Column(name = "numero_max_occupanti", nullable = false)
    private int numeroMaxOccupanti;
    @Column(name = "is_free", nullable = false)
    private boolean isFree;

    @ManyToOne
    @JoinColumn(name = "edificio_id")
    private Edificio edificio;

    @OneToMany(mappedBy = "postazioneAziendale")
    private List<Prenotazione> prenotazioni;

    public PostazioneAziendale(String descrizione, TipoPostazione tipoPostazione, int numeroMaxOccupanti, boolean isFree, Edificio edificio, List<Prenotazione> prenotazioni) {
        this.descrizione = descrizione;
        this.tipoPostazione = tipoPostazione;
        this.numeroMaxOccupanti = numeroMaxOccupanti;
        this.isFree = isFree;
        this.edificio = edificio;
        this.prenotazioni = prenotazioni;
    }

    public PostazioneAziendale(long id, String descrizione, TipoPostazione tipoPostazione, int numeroMaxOccupanti, boolean isFree, Edificio edificio, List<Prenotazione> prenotazioni) {
        this.id = id;
        this.descrizione = descrizione;
        this.tipoPostazione = tipoPostazione;
        this.numeroMaxOccupanti = numeroMaxOccupanti;
        this.isFree = isFree;
        this.edificio = edificio;
        this.prenotazioni = prenotazioni;
    }
}
