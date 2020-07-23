package com.praline.meetZicker.repositories;

import com.praline.meetZicker.entities.MRM;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MRMRepository extends JpaRepository<MRM, Long> {
}
