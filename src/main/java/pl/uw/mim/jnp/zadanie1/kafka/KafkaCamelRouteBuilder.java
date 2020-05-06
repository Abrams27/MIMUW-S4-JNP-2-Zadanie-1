package pl.uw.mim.jnp.zadanie1.kafka;

import lombok.AllArgsConstructor;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;
import pl.uw.mim.jnp.zadanie1.config.CamelRouteUrlProperties;
import pl.uw.mim.jnp.zadanie1.kafka.config.KafkaCamelProperties;

@Component
@AllArgsConstructor
public class KafkaCamelRouteBuilder extends RouteBuilder {

  private CamelRouteUrlProperties camelRouteUrlProperties;
  private KafkaCamelProperties kafkaCamelProperties;

  @Override
  public void configure() {
    from(camelRouteUrlProperties.getKafka())
        .to(buildCamelKafkaUrlWithTopic());
  }

  private String buildCamelKafkaUrlWithTopic() {
    return String.format("kafka:%s?brokers=%s", kafkaCamelProperties.getTopic(), kafkaCamelProperties.getUrl());
  }

}
