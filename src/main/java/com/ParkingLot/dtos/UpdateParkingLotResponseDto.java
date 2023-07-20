package com.ParkingLot.dtos;

import com.ParkingLot.models.ParkingLot;

public class UpdateParkingLotResponseDto extends ResponseDto {
    private ParkingLot parkingLot;

    public ParkingLot getParkingLot() {
        return parkingLot;
    }

    public void setParkingLot(ParkingLot parkingLot) {
        this.parkingLot = parkingLot;
    }
}
