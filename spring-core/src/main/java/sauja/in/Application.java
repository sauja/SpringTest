package sauja.in;


import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration

//Used to define where to find all the beans. Default is the package in which
// the current file is located
@ComponentScan
public class Application {
}
