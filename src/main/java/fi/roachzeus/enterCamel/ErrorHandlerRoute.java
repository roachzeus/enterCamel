package fi.roachzeus.enterCamel;

import org.apache.camel.Exchange;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class ErrorHandlerRoute extends RouteBuilder {

    @Override
    public void configure() {

        onException(Exception.class)
            .handled(true)
            .setHeader(Exchange.HTTP_RESPONSE_CODE, constant(400))
            .setBody(simple("""
                {
                  "error":"${exception.message}"
                }
                """));

        onException(Exception.class)
            .handled(true)
            .setHeader(Exchange.HTTP_RESPONSE_CODE, constant(500))
            .setBody(simple("""
                {
                  "error":"Internal server error"
                }
                """));
    }
}