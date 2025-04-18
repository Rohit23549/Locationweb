package com.rohit.location.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import com.rohit.location.entities.Location;

public interface LocationRepository extends JpaRepository<Location,Long> {
}
