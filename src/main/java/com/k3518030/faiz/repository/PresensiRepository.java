package com.k3518030.faiz.repository;

import com.k3518030.faiz.entity.DbPresensi;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PresensiRepository extends JpaRepository<DbPresensi, Integer> {
}
