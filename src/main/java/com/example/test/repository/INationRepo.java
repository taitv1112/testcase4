package com.example.test.repository;

import com.example.test.model.Nation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface INationRepo extends JpaRepository<Nation,Long> {
}
