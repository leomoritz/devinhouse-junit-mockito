package com.muller.devincars.repository;

import com.muller.devincars.model.Dev;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface DevRepository extends JpaRepository<Dev, UUID> {

}
