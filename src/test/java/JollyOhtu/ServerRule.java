package JollyOhtu;


import org.junit.rules.ExternalResource;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;


public class ServerRule extends ExternalResource {
private ConfigurableApplicationContext appCont;
    @Override
    protected void before() throws Throwable {
//        SpringApplication.run(Main.class, "");
        appCont = SpringApplication.run(Main.class, "");
    }

    @Override
    protected void after() {
        appCont.close();
    }
    
}
