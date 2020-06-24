package dev.abhinav.IRCTC.service;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public interface ITokenService {
    public String getBookingToken(String userId, Long trainId, LocalDate journeyStartDate, Integer coachTypeId);
    public String getServiceMachineFromToken(String token);
    public List<BookingSetToHandle> registerMachine(String machineName);
    public void refreshBookingSetToHandle();
}
