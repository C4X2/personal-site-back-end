package page.nb.personal.contact.service;

import page.nb.personal.contact.dm.EmailContact;
import page.nb.personal.contact.exceptions.EmailValidationException;
import page.nb.personal.contact.exceptions.NullFieldLevelException;

/**
 * The purpose of this service is to validate that all information needed to send an email is present
 * @author Nate B.
 * @version 1.0
 */
public interface EmailValidationService {
    /**
     * Validates the given emailContact object
     * @param emailContact Object received from the front-end that will be validated by this service
     * @throws NullPointerException if param emailContact is null
     * @throws EmailValidationException if the email address is not properly formatted
     * @throws NullFieldLevelException if any field is null or empty
     */
    void validateEmailContact(EmailContact emailContact) throws NullPointerException, EmailValidationException, NullFieldLevelException;
}
