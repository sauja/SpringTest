package sauja.in;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration

//Used to define where to find all the beans. Default is the package in which
// the current file is located
@ComponentScan
public class Application {

    @Bean
    public HelloPOJO getHelloPOJO()
    {
        return new HelloPOJO("4.10 RELEASE");
    }
}
