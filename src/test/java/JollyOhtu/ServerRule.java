package JollyOhtu;


import org.junit.rules.ExternalResource;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;


public class ServerRule extends ExternalResource {
private ConfigurableApplicationContext appCont;
    @Override
    protected void before() throws Throwable {
        // Starts application for testing on localhost
        appCont = SpringApplication.run(Main.class, "");
    }

    @Override
    protected void after() {
        // Closes opened application
        appCont.close();
    }
    
}
