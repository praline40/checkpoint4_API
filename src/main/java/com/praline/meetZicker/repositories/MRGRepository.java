package com.praline.meetZicker.repositories;

import com.praline.meetZicker.entities.MRG;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MRGRepository extends JpaRepository<MRG, Long> {
}
