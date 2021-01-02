package com.k3518030.faiz.dto;

public class ProdiDto {
    private Integer id;
    private String prodi;

    public ProdiDto() {
    }

    public ProdiDto(Integer id, String prodi) {
        this.id = id;
        this.prodi = prodi;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProdi() {
        return prodi;
    }

    public void setProdi(String prodi) {
        this.prodi = prodi;
    }
}
