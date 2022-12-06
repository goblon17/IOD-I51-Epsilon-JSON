package put.cs.jsontools.exceptions;

public class FieldInJsonNotFoundException extends RuntimeException{
    private String message;

    public FieldInJsonNotFoundException(){
    }

    public FieldInJsonNotFoundException(String message){
        super(message);
        this.message = message;
    }
}
