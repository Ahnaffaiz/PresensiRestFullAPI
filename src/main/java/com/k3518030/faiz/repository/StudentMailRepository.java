package com.k3518030.faiz.repository;

import com.k3518030.faiz.entity.DbStudentMail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentMailRepository extends JpaRepository<DbStudentMail, Integer> {
}
