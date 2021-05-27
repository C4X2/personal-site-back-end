package page.nb.personal.contact.dm;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author Nate B.
 * @version 1.0
 */
@Component
public class EmailConfig {

    @Value("${nb.email.to-address}")
    private String toAddress;

    public String getToAddress() {
        return toAddress;
    }

    public void setToAddress(String toAddress) {
        this.toAddress = toAddress;
    }

}
