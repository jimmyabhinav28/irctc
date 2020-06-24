package dev.abhinav.IRCTC.service;

import java.time.LocalDate;
import java.util.List;

public interface ITokenService {
    public String getBookingToken(String userId, Long trainId, LocalDate journeyStartDate,Long coachTypeId);
    public String getEndpointToServiceToken(String token);
    public List<BookingSetToHandle> registerMachine(String machineName);
}
