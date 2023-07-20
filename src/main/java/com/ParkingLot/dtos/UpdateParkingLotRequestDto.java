package com.ParkingLot.dtos;

public class UpdateParkingLotRequestDto extends ResponseDto {
    private Long parkingLotId;
    private String address;

    public Long getParkingLotId() {
        return parkingLotId;
    }

    public void setParkingLotId(Long parkingLotId) {
        this.parkingLotId = parkingLotId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
