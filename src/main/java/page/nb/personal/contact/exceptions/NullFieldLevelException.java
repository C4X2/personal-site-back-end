package page.nb.personal.contact.exceptions;

/**
 * @author Nate B.
 * @version 1.0
 */
public class NullFieldLevelException extends Exception {

    public NullFieldLevelException(String clazz, String fieldName){
        super("The " + fieldName + " field in " + clazz + " failed validation.");
    }
}
