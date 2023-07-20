package com.ParkingLot.strategies;

import com.ParkingLot.models.EntryGate;
import com.ParkingLot.models.ParkingLot;
import com.ParkingLot.models.ParkingSpot;
import com.ParkingLot.models.SpotType;

public interface SpotAssignmentStrategy {
    ParkingSpot assignSpot(ParkingLot parkingLot, SpotType spotType, EntryGate entryGate);
}
