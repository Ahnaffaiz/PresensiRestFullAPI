/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.k3518030.faiz.entity;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author ahnaffaiz
 */
@Entity
@Table(name = "db_student")
@NamedQueries({
    @NamedQuery(name = "DbStudent.findAll", query = "SELECT d FROM DbStudent d"),
    @NamedQuery(name = "DbStudent.findById", query = "SELECT d FROM DbStudent d WHERE d.id = :id"),
    @NamedQuery(name = "DbStudent.findByGender", query = "SELECT d FROM DbStudent d WHERE d.gender = :gender"),
    @NamedQuery(name = "DbStudent.findByName", query = "SELECT d FROM DbStudent d WHERE d.name = :name"),
    @NamedQuery(name = "DbStudent.findByPassword", query = "SELECT d FROM DbStudent d WHERE d.password = :password")})
public class DbStudent implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "gender")
    private String gender;
    @Basic(optional = false)
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
    @Column(name = "password")
    private String password;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idStudent")
    private List<DbStudentAddres> dbStudentAddresList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idStudent")
    private List<DbStudentMail> dbStudentMailList;
    @JoinColumn(name = "id_prodi", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private DbProdi idProdi;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idStudent")
    private List<DbPresensi> dbPresensiList;

    public DbStudent() {
    }

    public DbStudent(Integer id) {
        this.id = id;
    }

    public DbStudent(Integer id, String gender, String name, String password) {
        this.id = id;
        this.gender = gender;
        this.name = name;
        this.password = password;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<DbStudentAddres> getDbStudentAddresList() {
        return dbStudentAddresList;
    }

    public void setDbStudentAddresList(List<DbStudentAddres> dbStudentAddresList) {
        this.dbStudentAddresList = dbStudentAddresList;
    }

    public List<DbStudentMail> getDbStudentMailList() {
        return dbStudentMailList;
    }

    public void setDbStudentMailList(List<DbStudentMail> dbStudentMailList) {
        this.dbStudentMailList = dbStudentMailList;
    }

    public DbProdi getIdProdi() {
        return idProdi;
    }

    public void setIdProdi(DbProdi idProdi) {
        this.idProdi = idProdi;
    }

    public List<DbPresensi> getDbPresensiList() {
        return dbPresensiList;
    }

    public void setDbPresensiList(List<DbPresensi> dbPresensiList) {
        this.dbPresensiList = dbPresensiList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DbStudent)) {
            return false;
        }
        DbStudent other = (DbStudent) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.k3518030.faiz.DbStudent[ id=" + id + " ]";
    }
    
}
