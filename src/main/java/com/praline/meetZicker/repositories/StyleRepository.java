package com.praline.meetZicker.repositories;

import com.praline.meetZicker.entities.Style;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StyleRepository extends JpaRepository<Style, Long> {
}
