package page.nb.personal.contact.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;
import page.nb.personal.contact.dm.EmailContact;
import page.nb.personal.contact.util.EmailUtil;
import page.nb.personal.contact.dm.EmailConfig;

import javax.mail.internet.MimeMessage;

/**
 * @author Nate B.
 * @version 1.0
 */
@Component
public class EmailServiceImpl implements EmailService {

    @Autowired
    private JavaMailSender javaMailSender;
    @Autowired
    private EmailConfig emailConfig;

    @Override
    public void sendEmail(String address, String text, String name) {
        MimeMessage message = getJavaMailSender().createMimeMessage();
        try {
            MimeMessageHelper helper = new MimeMessageHelper(message, false);
            helper.setText(text);
            helper.setFrom(address);
            helper.setTo(getEmailConfig().getToAddress());

            String subjectLn = EmailUtil.buildSubjectLine(name);
            helper.setSubject(subjectLn);
            getJavaMailSender().send(helper.getMimeMessage());
        } catch (Exception e) {
            // do nothing
        }
    }

    @Override
    public void sendEmail(EmailContact emailContact) {
        if (emailContact != null)
        {
            EmailUtil.augmentEmailText(emailContact);
            sendEmail(emailContact.getSendersEmailAddress(), emailContact.getMessage(), emailContact.getSendersName());
        }

    }

    public JavaMailSender getJavaMailSender() {
        return javaMailSender;
    }

    public void setJavaMailSender(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    public EmailConfig getEmailConfig() {
        return emailConfig;
    }

    public void setEmailConfig(EmailConfig emailConfig) {
        this.emailConfig = emailConfig;
    }
}
