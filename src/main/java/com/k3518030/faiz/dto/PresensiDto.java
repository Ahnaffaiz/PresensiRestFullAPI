package com.k3518030.faiz.dto;

import java.util.Date;

public class PresensiDto {
    private Integer id;
    private Integer idStudent;
    private Date datePresensi;

    public PresensiDto() {
    }

    public PresensiDto(Integer id, Integer idStudent, Date datePresensi) {
        this.id = id;
        this.idStudent = idStudent;
        this.datePresensi = datePresensi;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIdStudent() {
        return idStudent;
    }

    public void setIdStudent(Integer idStudent) {
        this.idStudent = idStudent;
    }

    public Date getDatePresensi() {
        return datePresensi;
    }

    public void setDatePresensi(Date datePresensi) {
        this.datePresensi = datePresensi;
    }
}
