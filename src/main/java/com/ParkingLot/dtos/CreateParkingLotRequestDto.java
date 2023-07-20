package com.ParkingLot.dtos;

public class CreateParkingLotRequestDto extends ResponseDto {
    private String address;
    private int numberOfFloors;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getNumberOfFloors() {
        return numberOfFloors;
    }

    public void setNumberOfFloors(int numberOfFloors) {
        this.numberOfFloors = numberOfFloors;
    }
}
