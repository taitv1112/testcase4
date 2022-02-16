package com.example.test.service;

import com.example.test.model.City;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ICityService {
     Page<City> findAll(Pageable pageable);
     void save(City users);
     void delete(long id);
     City findById(long id);
     Page<City> findUsersByName(String name, Pageable pageable);
}
