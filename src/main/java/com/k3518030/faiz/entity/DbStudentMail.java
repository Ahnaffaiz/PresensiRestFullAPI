/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.k3518030.faiz.entity;

import java.io.Serializable;
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

/**
 *
 * @author ahnaffaiz
 */
@Entity
@Table(name = "db_student_mail")
@NamedQueries({
    @NamedQuery(name = "DbStudentMail.findAll", query = "SELECT d FROM DbStudentMail d"),
    @NamedQuery(name = "DbStudentMail.findById", query = "SELECT d FROM DbStudentMail d WHERE d.id = :id"),
    @NamedQuery(name = "DbStudentMail.findByEmail", query = "SELECT d FROM DbStudentMail d WHERE d.email = :email")})
public class DbStudentMail implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "email")
    private String email;
    @JoinColumn(name = "id_student", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private DbStudent idStudent;

    public DbStudentMail() {
    }

    public DbStudentMail(Integer id) {
        this.id = id;
    }

    public DbStudentMail(Integer id, String email) {
        this.id = id;
        this.email = email;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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
        if (!(object instanceof DbStudentMail)) {
            return false;
        }
        DbStudentMail other = (DbStudentMail) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.k3518030.faiz.DbStudentMail[ id=" + id + " ]";
    }
    
}
