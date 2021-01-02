/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.k3518030.faiz.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author ahnaffaiz
 */
@Entity
@Table(name = "db_presensi")
@NamedQueries({
    @NamedQuery(name = "DbPresensi.findAll", query = "SELECT d FROM DbPresensi d"),
    @NamedQuery(name = "DbPresensi.findById", query = "SELECT d FROM DbPresensi d WHERE d.id = :id"),
    @NamedQuery(name = "DbPresensi.findByDatePresensi", query = "SELECT d FROM DbPresensi d WHERE d.datePresensi = :datePresensi")})
public class DbPresensi implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "date_presensi")
    @Temporal(TemporalType.DATE)
    private Date datePresensi;
    @JoinColumn(name = "id_student", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private DbStudent idStudent;

    public DbPresensi() {
    }

    public DbPresensi(Integer id) {
        this.id = id;
    }

    public DbPresensi(Integer id, Date datePresensi) {
        this.id = id;
        this.datePresensi = datePresensi;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDatePresensi() {
        return datePresensi;
    }

    public void setDatePresensi(Date datePresensi) {
        this.datePresensi = datePresensi;
    }

    public DbStudent getIdStudent() {
        return idStudent;
    }

    public void setIdStudent(DbStudent idStudent) {
        this.idStudent = idStudent;
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
        if (!(object instanceof DbPresensi)) {
            return false;
        }
        DbPresensi other = (DbPresensi) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.k3518030.faiz.DbPresensi[ id=" + id + " ]";
    }
    
}
