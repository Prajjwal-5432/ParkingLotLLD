package com.ParkingLot.dtos;

import com.ParkingLot.models.EntryGate;
import com.ParkingLot.models.SpotType;
import com.ParkingLot.models.Vehicle;

public class GenerateTicketRequestDto extends ResponseDto {
    private Vehicle vehicle;
    private EntryGate entryGate;
    private Long parkingLotId;
    private SpotType spotType;

    public SpotType getSpotType() {
        return spotType;
    }

    public void setSpotType(SpotType spotType) {
        this.spotType = spotType;
    }

    public Long getParkingLotId() {
        return parkingLotId;
    }

    public void setParkingLotId(Long parkingLotId) {
        this.parkingLotId = parkingLotId;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public EntryGate getEntryGate() {
        return entryGate;
    }

    public void setEntryGate(EntryGate entryGate) {
        this.entryGate = entryGate;
    }
}
