package Validator;

/**
 *
 * @author M
 */
public class InvalidAttributeException extends Exception {
    
    public InvalidAttributeException(){
        super();
    }
    
    public InvalidAttributeException(String message){
        super(message);
    }
}
