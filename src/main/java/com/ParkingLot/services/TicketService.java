package com.ParkingLot.services;

import com.ParkingLot.models.*;
import com.ParkingLot.repositries.ParkingLotRepositry;
import com.ParkingLot.repositries.TicketRepository;
import com.ParkingLot.strategies.SpotAssignmentStrategy;

import java.util.Date;

public class TicketService {
    private TicketRepository ticketRepository;
    private SpotAssignmentStrategy spotAssignmentStrategy;
    private ParkingLotRepositry parkingLotRepositry;
    public TicketService(TicketRepository ticketRepository, SpotAssignmentStrategy spotAssignmentStrategy,
                         ParkingLotRepositry parkingLotRepositry) {
        this.ticketRepository = ticketRepository;
        this.spotAssignmentStrategy = spotAssignmentStrategy;
        this.parkingLotRepositry = parkingLotRepositry;
    }
    public Ticket generateTicket(Vehicle vehicle, EntryGate entryGate, SpotType spotType, Long parkingLotId) {
        ParkingLot parkingLot = parkingLotRepositry.getById(parkingLotId);
        ParkingSpot parkingSpot = spotAssignmentStrategy.assignSpot(parkingLot, spotType, entryGate);

        if(parkingLot == null) return null;

        Ticket ticket = new Ticket();
        ticket.setEntryGate(entryGate);
        ticket.setGeneratedBy(entryGate.getOperator());
        ticket.setParkingSpot(parkingSpot);
        ticket.setVehicle(vehicle);
        ticket.setEntryTime(new Date());
        return ticket;
    }
}
