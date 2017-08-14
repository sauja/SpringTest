package sauja.in.complex;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Tester {
    public static void main(String args[])
    {
        AnnotationConfigApplicationContext  applicationContext =new AnnotationConfigApplicationContext(Application.class);
        NotificationService notificationService=applicationContext.getBean(NotificationService.class);
        notificationService.sendNotification("to","from","message");
        applicationContext.close();


    }
}
