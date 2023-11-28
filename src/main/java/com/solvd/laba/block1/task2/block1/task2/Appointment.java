package com.solvd.laba.block1.task2.block1.task2;

import java.time.LocalDateTime;

import java.time.format.DateTimeFormatter;


public class Appointment {

    private String date;
    private String time;
    private Customer customer;
    private KumcuRepairService serviceRequest;


    public Appointment(String date, Customer customer, KumcuRepairService serviceRequest) {
        this.date = date;
        this.customer = customer;
        this.serviceRequest = serviceRequest;

    }

    public String getDate() {
        return this.date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return this.time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public Customer getCustomer() {
        return this.customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public KumcuRepairService getServiceRequest() {
        return this.serviceRequest;
    }

    public void setServiceRequest(KumcuRepairService serviceRequest) {
        this.serviceRequest = serviceRequest;
    }


    @Override
    public String toString() {
        return "Appointment{" +
                "date='" + date + '\'' +
                ", time='" + time + '\'' +
                ", customer=" + customer.toString() +
                ", serviceRequest=" + serviceRequest.toString() +
                '}';
    }
}
