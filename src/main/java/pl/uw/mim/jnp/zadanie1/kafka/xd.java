package pl.uw.mim.jnp.zadanie1.kafka;

import org.apache.camel.ProducerTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class xd {

  @Autowired
  ProducerTemplate producerTemplate;

  @RequestMapping(value = "/")
  void startCamel() {
    producerTemplate.sendBody("direct:start", "Calling via Spring Boot Rest Controller");
  }

}
