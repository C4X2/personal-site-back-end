package page.nb.personal.contact.exceptions;

import org.springframework.beans.factory.annotation.Value;

/**
 * @author Nate B.
 * @version 1.0
 */
public class EmailValidationException extends Exception{

    public EmailValidationException () {
        super("This email address is incorrectly formatted. Validation has failed");
    }

}

