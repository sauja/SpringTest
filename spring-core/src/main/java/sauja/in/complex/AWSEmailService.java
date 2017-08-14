package sauja.in.complex;

import org.springframework.stereotype.Component;

@Component("AWSEmailService")
public class AWSEmailService implements EmailService {
    @Override
    public void sendNotification(String to, String from, String message) {
        System.out.println("AWSEmailService Service");
        System.out.println("From: "+from);
        System.out.println("To: "+to);
        System.out.println("Body: "+message);
    }
}
