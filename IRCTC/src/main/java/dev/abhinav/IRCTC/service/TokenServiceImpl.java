package dev.abhinav.IRCTC.service;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Base64;
import java.util.HashSet;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class TokenServiceImpl implements ITokenService {
    private ConcurrentHashMap<String,String> tokenToMachineMap=new ConcurrentHashMap<>();
    private HashSet<String> registeredMachines=new HashSet<String>();
    @Override
    public String getBookingToken(String userId, Long trainId, LocalDate journeyStartDate, Long coachTypeId) {
        return null;
    }
    private String getKey(String userId, Long trainId, LocalDate journeyStartDate, Long coachTypeId)
    {
        String keyToHash=String.valueOf(trainId)+"_"+journeyStartDate.toString()+"_"+String.valueOf(coachTypeId);
        return keyToHash;
    }

    @Override
    public String getEndpointToServiceToken(String token) {
        return null;
    }

    //this implementation is just a dummy implementation
    @Override
    public List<BookingSetToHandle> registerMachine(String machineName) {
        BookingSetToHandle bookingSet1=new BookingSetToHandle();
        BookingSetToHandle bookingSet2=new BookingSetToHandle();
        BookingSetToHandle bookingSet3=new BookingSetToHandle();
        ArrayList<BookingSetToHandle> bookingSetToHandleArrayList=new ArrayList<>();
        bookingSetToHandleArrayList.add(bookingSet1);
        bookingSetToHandleArrayList.add(bookingSet2);
        bookingSetToHandleArrayList.add(bookingSet3);
        return bookingSetToHandleArrayList;
    }


}
