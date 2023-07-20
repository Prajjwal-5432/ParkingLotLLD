package com.ParkingLot.services;

import com.ParkingLot.models.ParkingLot;
import com.ParkingLot.repositries.ParkingLotRepositry;

public class ParkingLotService {
    private ParkingLotRepositry parkingLotRepositry;

    public ParkingLotService(ParkingLotRepositry parkingLotRepositry) {
        this.parkingLotRepositry = parkingLotRepositry;
    }
    public ParkingLot createParkingLot(ParkingLot parkingLot) {
        return parkingLotRepositry.save(parkingLot);
    }

    public ParkingLot updateAddress(Long id, String address) {
        ParkingLot parkingLot = parkingLotRepositry.getById(id);
        parkingLot.setAddress(address);
        ParkingLot updatedParkingLot = parkingLotRepositry.update(id, parkingLot);
        return updatedParkingLot;
    }
}
