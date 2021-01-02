package com.k3518030.faiz.dto;

public class StudentAddressDto {
    private Integer id;
    private String address;

    public StudentAddressDto() {
    }

    public StudentAddressDto(Integer id, String address) {
        this.id = id;
        this.address = address;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
