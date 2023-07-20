package com.ParkingLot.models;

import java.util.Date;

public class Invoice extends BaseModel {
    private Ticket ticket;
    private double amount;
    private Date exitTime;
    private Operator exitOperator;
    private InvoicePaidStatus invoicePaidStatus;
}
