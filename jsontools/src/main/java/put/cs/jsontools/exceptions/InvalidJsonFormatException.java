package put.cs.jsontools.exceptions;

public class InvalidJsonFormatException extends RuntimeException{
    private String message;

    public InvalidJsonFormatException(){
    }

    public InvalidJsonFormatException(String message){
        super(message);
        this.message = message;
    }
}
