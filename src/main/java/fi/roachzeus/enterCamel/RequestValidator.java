package fi.roachzeus.enterCamel;

import org.springframework.stereotype.Component;

@Component
public class RequestValidator {

    public void validate(ProcessRequest request) throws Exception {

        if (request.name() == null || request.name().isBlank()) {
            throw new Exception("Field 'name' is required");
        }

        if (request.city() == null || request.city().isBlank()) {
            throw new Exception("Field 'city' is required");
        }
    }
}