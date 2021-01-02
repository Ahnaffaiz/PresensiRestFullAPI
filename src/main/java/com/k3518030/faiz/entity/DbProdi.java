/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.k3518030.faiz.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author ahnaffaiz
 */
@Entity
@Table(name = "db_prodi")
@NamedQueries({
    @NamedQuery(name = "DbProdi.findAll", query = "SELECT d FROM DbProdi d"),
    @NamedQuery(name = "DbProdi.findById", query = "SELECT d FROM DbProdi d WHERE d.id = :id"),
    @NamedQuery(name = "DbProdi.findByProdi", query = "SELECT d FROM DbProdi d WHERE d.prodi = :prodi")})
public class DbProdi implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "prodi")
    private String prodi;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idProdi")
    private List<DbStudent> dbStudentList;

    public DbProdi() {
    }

    public DbProdi(Integer id) {
        this.id = id;
    }

    public DbProdi(Integer id, String prodi) {
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

    public List<DbStudent> getDbStudentList() {
        return dbStudentList;
    }

    public void setDbStudentList(List<DbStudent> dbStudentList) {
        this.dbStudentList = dbStudentList;
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
        if (!(object instanceof DbProdi)) {
            return false;
        }
        DbProdi other = (DbProdi) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.k3518030.faiz.DbProdi[ id=" + id + " ]";
    }
    
}
