package com.ParkingLot.controllers;

import com.ParkingLot.dtos.*;
import com.ParkingLot.models.ParkingFloor;
import com.ParkingLot.models.ParkingLot;
import com.ParkingLot.services.ParkingLotService;

import java.util.ArrayList;
import java.util.List;

public class ParkingLotController {
    private ParkingLotService parkingLotService;
    public ParkingLotController(ParkingLotService parkingLotService) {
        this.parkingLotService = parkingLotService;
    }
    public CreateParkingLotResponseDto createParkingLot(CreateParkingLotRequestDto request) {
        if(request.getNumberOfFloors() < 2) {
            CreateParkingLotResponseDto response = new CreateParkingLotResponseDto();
            response.setResponseStatusDto(ResponseStatusDto.FAILURE);
            return response;
        }
        ParkingLot parkingLot = new ParkingLot();
        parkingLot.setAddress(request.getAddress());
        List<ParkingFloor> parkingFloors = new ArrayList<>();
        for(int i = 0; i < request.getNumberOfFloors(); i++) {
            parkingFloors.add(new ParkingFloor());
        }
        parkingLot.setParkingFloors(parkingFloors);

        ParkingLot createdParkingLot = parkingLotService.createParkingLot(parkingLot);

        CreateParkingLotResponseDto response = new CreateParkingLotResponseDto();
        response.setParkingLot(createdParkingLot);
        response.setResponseStatusDto(ResponseStatusDto.SUCCESS);
        return response;
    }

    public UpdateParkingLotResponseDto updateParkingLot(UpdateParkingLotRequestDto request) {
        ParkingLot parkingLot =
                parkingLotService.updateAddress(request.getParkingLotId(), request.getAddress());

        UpdateParkingLotResponseDto response = new UpdateParkingLotResponseDto();
        response.setParkingLot(parkingLot);
        response.setResponseStatusDto(ResponseStatusDto.SUCCESS);
        return response;
    }
}

//In the createParkingLot method there can be many attributes in the future so what we will be
// doing is creating a DTO
//DTO -> Data transfer object
//for every request/response we will create a dto
