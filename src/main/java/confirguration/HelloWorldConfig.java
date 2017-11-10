package confirguration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@EnableWebMvc
@ComponentScan({"configuration", "controller", "objects", "repositories", "services"})
public class HelloWorldConfig {

    @Configuration
    @Profile("verify")
    @PropertySource("classpath:application-verify.properties")
    static class ApplicationVerifyProperties {}

    @Configuration
    @Profile("default")
    @PropertySource("classpath:application-default.properties")
    static class ApplicationDefaultProperties {}


}
