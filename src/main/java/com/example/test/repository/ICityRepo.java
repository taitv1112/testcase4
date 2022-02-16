package com.example.test.repository;

import com.example.test.model.City;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ICityRepo extends JpaRepository<City,Long> {
    @Query(value = " select u from City u where u.city_name like concat('%' ,:name, '%')")
    Page<City> findAllByName(@Param("name") String name, Pageable pageable);
}
