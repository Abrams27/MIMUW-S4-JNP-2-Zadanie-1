package pl.uw.mim.jnp.zadanie1.camel.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties(prefix = "camel.kafka")
public class CamelKafkaProperties {

  private String topic;
  private String url;

}

