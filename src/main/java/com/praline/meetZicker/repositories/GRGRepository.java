package com.praline.meetZicker.repositories;

import com.praline.meetZicker.entities.GRG;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GRGRepository extends JpaRepository<GRG, Long> {
}
