package page.nb.personal.contact.service;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import page.nb.personal.contact.dm.EmailContact;
import page.nb.personal.contact.exceptions.EmailValidationException;
import page.nb.personal.contact.exceptions.NullFieldLevelException;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Nate B.
 * @version 1.0
 */
@Component
public class EmailValidationServiceImpl implements EmailValidationService {
    @Value("${nb.email.regex-validation}")
    private String emailRegex;

    @Override
    public void validateEmailContact(EmailContact emailContact) throws NullPointerException, EmailValidationException, NullFieldLevelException {
        if (emailContact == null)
            throw new NullPointerException();

        String clazzName = EmailContact.class.getSimpleName();

        if (StringUtils.isBlank(emailContact.getMessage()))
            throw new NullFieldLevelException(clazzName, "Message");

        if (StringUtils.isBlank(emailContact.getSendersEmailAddress()))
            throw new NullFieldLevelException(clazzName, "Email");

        if (StringUtils.isBlank(emailContact.getSendersName()))
            throw new NullFieldLevelException(clazzName, "Name");

        Pattern pattern = Pattern.compile(getEmailRegex(), Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(emailContact.getSendersEmailAddress());

        if (!matcher.find())
            throw new EmailValidationException();
    }

    public String getEmailRegex() {
        return emailRegex;
    }

    public void setEmailRegex(String emailRegex) {
        this.emailRegex = emailRegex;
    }
}
