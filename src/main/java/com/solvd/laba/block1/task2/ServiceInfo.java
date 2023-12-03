package com.solvd.laba.block1.task2;

public class ServiceInfo {

    private static String address = "Aleja Jerozolimskie 98 ";

    public void setAddress(String address) {
        this.address = address;
    }

    public static String getAddress() {
        return address;
    }

    public static String serviceInfo(){
        return getAddress();
    }
}
