package com.ParkingLot.repositries;

import com.ParkingLot.models.Ticket;

import java.util.HashMap;
import java.util.Map;

public class TicketRepository {
    private Map<Long, Ticket> tickets = new HashMap<>();
    private Long autoIncrementId = 0L;

    public void save(Ticket ticket) {
        autoIncrementId += 1;
        ticket.setId(autoIncrementId);
        tickets.put(autoIncrementId, ticket);
    }
}
