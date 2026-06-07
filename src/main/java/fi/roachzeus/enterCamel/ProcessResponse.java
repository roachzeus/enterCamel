package fi.roachzeus.enterCamel;


public record ProcessResponse(
        String name,
        String city,
        Double currentTemperature,
        String time
) {
}
