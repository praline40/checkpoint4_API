package com.praline.meetZicker.repositories;

import com.praline.meetZicker.entities.GRM;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GRMRepository extends JpaRepository<GRM, Long> {
}
