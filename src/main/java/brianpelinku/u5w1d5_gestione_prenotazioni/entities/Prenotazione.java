package brianpelinku.u5w1d5_gestione_prenotazioni.entities;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "prenotazioni")
public class Prenotazione {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private long id;
    @Column(name = "nome", nullable = false)
    private String nome;
    @Column(name = "giorno_prenotazione", nullable = false)
    private LocalDate giornoPrenotazione;

    @ManyToOne
    @JoinColumn(name = "utente_id")
    private Utente utente;

    @ManyToOne
    @JoinColumn(name = "postazione_id")
    private PostazioneAziendale postazioneAziendale;

    public Prenotazione(String nome, LocalDate giornoPrenotazione, Utente utente, PostazioneAziendale postazioneAziendale) {
        this.nome = nome;
        this.giornoPrenotazione = giornoPrenotazione;
        this.utente = utente;
        this.postazioneAziendale = postazioneAziendale;
    }

    @Override
    public String toString() {
        return "Prenotazione{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", giornoPrenotazione=" + giornoPrenotazione +
                ", utente=" + utente +
                ", postazioneAziendale=" + postazioneAziendale +
                '}';
    }
}
