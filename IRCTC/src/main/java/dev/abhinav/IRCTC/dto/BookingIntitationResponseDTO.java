package dev.abhinav.IRCTC.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class BookingIntitationResponseDTO {
    //this booking initiation token should eventually be secure and should have an expiry time
    //the token is meant to be passed in subsequent booking request in headers or some mechanism that
    //enables the booking request to go to a particular server only
    //the token will identify which server should the request be redirected for processing
    String bookingInitiationToken;
}
