package com.parcialdoscapas.parcialcapas.repositories;


import com.parcialdoscapas.parcialcapas.entities.Gender;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface GenderRepository extends JpaRepository<Gender, UUID> {
}
