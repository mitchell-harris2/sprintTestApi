package confirguration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@EnableWebMvc
@ComponentScan({"configuration", "controller", "objects", "repositories", "services"})
public class HelloWorldConfig {

    @Configuration
    @PropertySource("classpath:application.properties")
    static class ApplicationProperties {}


}
