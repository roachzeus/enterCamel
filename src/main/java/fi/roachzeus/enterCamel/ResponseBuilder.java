package fi.roachzeus.enterCamel;

import org.apache.camel.Exchange;
import org.springframework.stereotype.Component;

@Component
public class ResponseBuilder {

    public ProcessResponse build(Exchange exchange) {

        return new ProcessResponse(
                exchange.getVariable("name", String.class),
                exchange.getVariable("city", String.class),
                exchange.getVariable("currentTemperature", Double.class),
                exchange.getVariable("timestamp", String.class)
        );
    }
}
