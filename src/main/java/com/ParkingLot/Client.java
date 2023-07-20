package com.ParkingLot;

import com.ParkingLot.controllers.ParkingLotController;
import com.ParkingLot.controllers.TicketController;
import com.ParkingLot.dtos.*;
import com.ParkingLot.models.ParkingLot;
import com.ParkingLot.repositries.ParkingLotRepositry;
import com.ParkingLot.repositries.TicketRepository;
import com.ParkingLot.services.ParkingLotService;
import com.ParkingLot.services.TicketService;
import com.ParkingLot.strategies.RandomSpotAssignmentStrategy;
import com.ParkingLot.strategies.SpotAssignmentStrategy;

public class Client {
    public static void main(String[] args) {
        ObjectRegistry.put("parkingLotRepository", new ParkingLotRepositry());
        ObjectRegistry.put("parkingLotService", new ParkingLotService(
                (ParkingLotRepositry) ObjectRegistry.get("parkingLotRepository")
        ));
        ObjectRegistry.put("parkingLotController", new ParkingLotController(
                (ParkingLotService) ObjectRegistry.get("parkingLotService")
        ));

        ObjectRegistry.put("ticketRepository", new TicketRepository());
        ObjectRegistry.put("spotAssignmentStrategy", new RandomSpotAssignmentStrategy());
        ObjectRegistry.put("ticketService", new TicketService(
                (TicketRepository) ObjectRegistry.get("ticketRepository"),
                (SpotAssignmentStrategy) ObjectRegistry.get("spotAssignmentStrategy"),
                (ParkingLotRepositry) ObjectRegistry.get("parkingLotRepository")
        ));
        ObjectRegistry.put("ticketController", new TicketController(
                (TicketService) ObjectRegistry.get("ticketService")
        ));


        ParkingLotController parkingLotController =
                (ParkingLotController) ObjectRegistry.get("parkingLotController");

        CreateParkingLotRequestDto request = new CreateParkingLotRequestDto();
        request.setAddress("Jhansi Railway Station");
        request.setNumberOfFloors(4);

        CreateParkingLotResponseDto response = parkingLotController.createParkingLot(request);
        if(response.getResponseStatusDto().equals(ResponseStatusDto.FAILURE)) {
            System.out.println("Something went wrong");
        } else {
            System.out.println(response.getParkingLot());
        }

        UpdateParkingLotRequestDto updateParkingLotRequestDto = new UpdateParkingLotRequestDto();
        updateParkingLotRequestDto.setParkingLotId(1L);
        updateParkingLotRequestDto.setAddress("Noida");

        UpdateParkingLotResponseDto updateParkingLotResponseDto =
                parkingLotController.updateParkingLot(updateParkingLotRequestDto);

        System.out.println(updateParkingLotResponseDto);
    }
}
