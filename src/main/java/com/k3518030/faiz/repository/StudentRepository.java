package com.k3518030.faiz.repository;

import com.k3518030.faiz.dto.LoginDto;
import com.k3518030.faiz.entity.DbStudent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<DbStudent, Integer> {
    @Query
    Optional<DbStudent> findByNameAndPassword(String name, String password);
}
