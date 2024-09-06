package brianpelinku.u5w1d5_gestione_prenotazioni.exceptions;

public class ValidationException extends RuntimeException{
    public ValidationException(String mess){
        super(mess);
    }
}
