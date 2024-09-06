package brianpelinku.u5w1d5_gestione_prenotazioni.exceptions;

public class NotFoundException extends RuntimeException{
    public NotFoundException(long id){
        super("Il RECORD con id " + id + " non è stato trovato nel DB.");
    }
}
