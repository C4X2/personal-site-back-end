package page.nb.personal.contact.service;

import page.nb.personal.contact.dm.EmailContact;

/**
 * @author Nate B.
 * @version 1.0
 */
public interface EmailService {
    void sendEmail(String address, String text, String name);
    void sendEmail(EmailContact emailContact);
}
