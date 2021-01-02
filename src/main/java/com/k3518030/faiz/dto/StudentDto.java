package com.k3518030.faiz.dto;

public class StudentDto {
    private Integer id;
    private Integer idProdi;
    private String name;
    private String gender;
    private String password;

    public StudentDto() {
    }

    public StudentDto(Integer id, Integer idProdi, String name, String gender, String password) {
        this.id = id;
        this.idProdi = idProdi;
        this.name = name;
        this.gender = gender;
        this.password = password;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIdProdi() {
        return idProdi;
    }

    public void setIdProdi(Integer idProdi) {
        this.idProdi = idProdi;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
