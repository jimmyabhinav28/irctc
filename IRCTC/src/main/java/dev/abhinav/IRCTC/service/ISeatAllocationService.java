package dev.abhinav.IRCTC.service;

import dev.abhinav.IRCTC.dto.BookingRequestDTO;
import dev.abhinav.IRCTC.exceptions.SeatAllocationException;

import java.util.List;

public interface ISeatAllocationService {
    public void constructAllocator(List<BookingSetToHandle> bookingSetToHandle);

    public AllocationDetails allocate(BookingRequestDTO bookingRequestDTO) throws SeatAllocationException;
}
