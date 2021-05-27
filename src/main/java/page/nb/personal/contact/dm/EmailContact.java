package page.nb.personal.contact.dm;

import java.time.LocalDate;

/**
 * Backend object that corresponds to the 'Contact Me' page on the front-end
 *
 *@author Nate B.
 *@version 1.0
 *
 */

public class EmailContact {

    String sendersEmailAddress;
    String sendersName;
    String message;
    LocalDate today = LocalDate.now();

    public EmailContact() {}

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getSendersName() {
        return sendersName;
    }

    public void setSendersName(String sendersName) {
        this.sendersName = sendersName;
    }

    public String getSendersEmailAddress() {
        return sendersEmailAddress;
    }

    public void setSendersEmailAddress(String sendersEmailAddress) {
        this.sendersEmailAddress = sendersEmailAddress;
    }

    public String dateOfContact() {
        return today.toString();
    }

}
