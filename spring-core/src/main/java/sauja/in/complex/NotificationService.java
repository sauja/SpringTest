package sauja.in.complex;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class NotificationService  {
    @Autowired
    @Qualifier("azureEmailService")
    private EmailService emailService;


    /*public NotificationService(EmailService emailService) {
        this.emailService = emailService;
    }*/

    public void sendNotification(String to, String from, String message) {
        emailService.sendNotification(to,from,message);
    }
}
