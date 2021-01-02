package com.k3518030.faiz.repository;

import com.k3518030.faiz.entity.DbProdi;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdiRepository extends JpaRepository<DbProdi, Integer> {
}
