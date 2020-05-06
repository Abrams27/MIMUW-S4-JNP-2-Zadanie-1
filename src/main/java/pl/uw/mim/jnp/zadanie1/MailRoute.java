package pl.uw.mim.jnp.zadanie1;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class MailRoute extends RouteBuilder {
    @Value("${mailroute.host}")
    private String host;

    @Value("${mailroute.username}")
    private String username;

    @Value("${mailroute.password}")
    private String password;

    public void configure() throws Exception {
        from("imaps://" + host + "?username=" + username + "&password=" + password
                + "&delete=false&unseen=true&delay=60000")
                .log("${body}");
    }
}
