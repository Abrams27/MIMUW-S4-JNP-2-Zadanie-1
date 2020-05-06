package pl.uw.mim.jnp.zadanie1;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

@Component
public class MailRoute extends RouteBuilder {
    @Value("${mailroute.host}")
    private String host;

    @Value("${mailroute.username}")
    private String username;

    @Value("${mailroute.password}")
    private String password;

    private static String encodeURL(String s) throws UnsupportedEncodingException {
        return URLEncoder.encode(
                s,
                java.nio.charset.StandardCharsets.UTF_8.toString()
        );
    }

    public void configure() throws Exception {
        from("imaps://" + host
                + "?username=" + encodeURL(username) + "&password=" + encodeURL(password)
                + "&delete=false&unseen=true&delay=60000")
                .log("${body}");
    }
}
