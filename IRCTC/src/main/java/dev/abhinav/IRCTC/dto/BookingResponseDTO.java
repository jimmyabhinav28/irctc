package dev.abhinav.IRCTC.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookingResponseDTO {
    String pnr;
    String paymentUrl;
}
