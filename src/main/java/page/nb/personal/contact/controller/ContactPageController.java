package page.nb.personal.contact.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import page.nb.personal.contact.dm.EmailContact;
import page.nb.personal.contact.exceptions.EmailValidationException;
import page.nb.personal.contact.exceptions.NullFieldLevelException;
import page.nb.personal.contact.service.EmailService;
import page.nb.personal.contact.service.EmailValidationService;

import javax.servlet.http.HttpServletResponse;

/**
 * @author Nate B.
 */
@RestController
public class ContactPageController {
    @Autowired
    private EmailService emailService;
    @Autowired
    private EmailValidationService emailValidationService;

    @PostMapping(value = "/contact", consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.TEXT_PLAIN_VALUE})
    public String processEmailRequest(@RequestBody String emailObj) {
        try {
            EmailContact emailContact = new ObjectMapper().readValue(emailObj, EmailContact.class);
            getEmailValidationService().validateEmailContact(emailContact);
            getEmailService().sendEmail(emailContact);
            return String.valueOf(HttpServletResponse.SC_OK);
        } catch (EmailValidationException | NullFieldLevelException ex) {
            ex.printStackTrace();
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return String.valueOf(HttpServletResponse.SC_BAD_REQUEST);
    }

    public EmailService getEmailService() {
        return emailService;
    }

    public void setEmailService(EmailService emailService) {
        this.emailService = emailService;
    }

    public EmailValidationService getEmailValidationService() {
        return emailValidationService;
    }

    public void setEmailValidationService(EmailValidationService emailValidationService) {
        this.emailValidationService = emailValidationService;
    }
}
