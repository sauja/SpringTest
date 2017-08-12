package sauja.in;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Tester {

    public static void main(String args[])
    {
        //Use annotation based context
        AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext(HelloPOJO.class);

        //get bean using context
        HelloPOJO helloPOJO=context.getBean(HelloPOJO.class);
        helloPOJO.sayHello("User");
    }
}
