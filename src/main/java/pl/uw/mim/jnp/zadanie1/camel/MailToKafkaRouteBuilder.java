package pl.uw.mim.jnp.zadanie1.camel;

import java.nio.charset.StandardCharsets;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

import java.net.URLEncoder;
import pl.uw.mim.jnp.zadanie1.camel.config.CamelKafkaProperties;
import pl.uw.mim.jnp.zadanie1.camel.config.CamelMailProperties;

@Component
@AllArgsConstructor
public class MailToKafkaRouteBuilder extends RouteBuilder {

  private CamelMailProperties camelMailProperties;
  private CamelKafkaProperties camelKafkaProperties;

  @Override
  public void configure() {
    from(buildMailUrlWithCredentials())
        .to(buildKafkaUrlWithTopic());
  }

  private String buildMailUrlWithCredentials() {
    return String.format("imaps://%s?username=%s&password=%s&delete=false&unseen=true&delay=%d",
        camelMailProperties.getHost(),
        encodeURL(camelMailProperties.getUsername()),
        encodeURL(camelMailProperties.getPassword()),
        camelMailProperties.getDelay());
  }

  @SneakyThrows
  private String encodeURL(String s) {
    return URLEncoder.encode(s, StandardCharsets.UTF_8.toString());
  }

  private String buildKafkaUrlWithTopic() {
    return String.format("kafka:%s?brokers=%s", camelKafkaProperties.getTopic(), camelKafkaProperties.getUrl());
  }

}
