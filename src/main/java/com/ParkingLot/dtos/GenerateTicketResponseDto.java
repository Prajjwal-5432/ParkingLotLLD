package com.ParkingLot.dtos;

import com.ParkingLot.models.Ticket;

public class GenerateTicketResponseDto extends ResponseDto {
    private Ticket ticket;

    public Ticket getTicket() {
        return ticket;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }
}
