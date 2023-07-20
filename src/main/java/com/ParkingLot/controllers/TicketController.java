package com.ParkingLot.controllers;

import com.ParkingLot.dtos.GenerateTicketRequestDto;
import com.ParkingLot.dtos.GenerateTicketResponseDto;
import com.ParkingLot.dtos.ResponseStatusDto;
import com.ParkingLot.models.Ticket;
import com.ParkingLot.services.TicketService;
import com.ParkingLot.strategies.SpotAssignmentStrategy;

public class TicketController {
    private TicketService ticketService;
    public TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }
    public GenerateTicketResponseDto generateTicket(GenerateTicketRequestDto request) {
        Ticket ticket = ticketService.generateTicket(
                request.getVehicle(),
                request.getEntryGate(),
                request.getSpotType(),
                request.getParkingLotId()
        );

        if(ticket == null) {
            GenerateTicketResponseDto responseDto = new GenerateTicketResponseDto();
            responseDto.setResponseStatusDto(ResponseStatusDto.FAILURE);
            return responseDto;
        }

        GenerateTicketResponseDto responseDto = new GenerateTicketResponseDto();
        responseDto.setTicket(ticket);
        responseDto.setResponseStatusDto(ResponseStatusDto.SUCCESS);

        return responseDto;
    }
}
