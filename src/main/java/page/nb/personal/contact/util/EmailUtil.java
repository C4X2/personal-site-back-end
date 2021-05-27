package page.nb.personal.contact.util;

import org.apache.commons.lang3.StringUtils;
import page.nb.personal.contact.dm.EmailContact;

import java.util.Locale;

/**
 * @author Nate B.
 * @version 1.1
 */
public class EmailUtil {
    /**
     * Prevent instantiation from outside since this class has all static methods
     */
    private EmailUtil() {
    }

    public static String buildSubjectLine(String text) {
        if (StringUtils.isBlank(text)) {
            return StringUtils.EMPTY;
        }

        String capitalized = StringUtils.capitalize(text.toLowerCase(Locale.ROOT));
        return StringUtils.join(capitalized, " sent an email!");
    }

    /**
     * Since we are using an intermediary email server to send contacts, the email address of the person will be lost. So we append the email address of the sender to the end of there message to maintain that point of contact.
     *
     * @param emailContact the information of the person who wants to contact me
     */
    public static void augmentEmailText(EmailContact emailContact) {
        if (emailContact == null) return;

        String text = StringUtils.join(emailContact.getMessage(), System.lineSeparator(), "Reach out at ", emailContact.getSendersEmailAddress());

        emailContact.setMessage(text);
    }

}
