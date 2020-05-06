package pl.uw.mim.jnp.zadanie1.kafka.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties(prefix = "camel.kafka")
public class KafkaCamelProperties {

  private String topic;
  private String url;

}

