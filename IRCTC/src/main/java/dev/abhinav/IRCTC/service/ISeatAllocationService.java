package dev.abhinav.IRCTC.service;

import dev.abhinav.IRCTC.dto.BookingRequestDTO;
import dev.abhinav.IRCTC.dto.BookingResponseDTO;
import dev.abhinav.IRCTC.exceptions.SeatAllocationException;

import java.util.List;

public interface ISeatAllocationService {
    public void constructAllocator(List<BookingSetToHandle> bookingSetToHandle);
    public BookingResponseDTO allocate(BookingRequestDTO bookingRequestDTO) throws SeatAllocationException;
}
