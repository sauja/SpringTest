package sauja.in;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;


//Registers a POJO as a spring bean
@Component

/*
* The default scope of a Component is Singleton i.e when we get HelloPOJO bean in another
* class it will be a singleton object. To use different pattern use @Scope("<>") to change
* the pattern
*
* singleton--------:This scopes the bean definition to a single instance per Spring IoC container (default).
* prototype--------:This scopes a single bean definition to have any number of object instances.
* request----------:This scopes a bean definition to an HTTP request. Only valid in the context of
*                   a web-aware Spring ApplicationContext.
* session----------:This scopes a bean definition to an HTTP session. Only valid in the context of a
*                   web-aware Spring ApplicationContext.
* global-session---:This scopes a bean definition to a global HTTP session. Only valid in the
*                   context of a web-aware Spring ApplicationContext.
* */
//@Scope("prototype")
public class HelloPOJO {
    public void sayHello(String message)
    {
        System.out.println("Hello "+message+"!");
    }
}
