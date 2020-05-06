package pl.uw.mim.jnp.zadanie1.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties(prefix = "camel.route.url")
public class CamelRouteUrlProperties {

  private String kafka;

}
