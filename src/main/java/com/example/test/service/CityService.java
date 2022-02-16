package com.example.test.service;

import com.example.test.model.City;
import com.example.test.repository.ICityRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class CityService implements ICityService {
    @Autowired
    ICityRepo usersRepo;
    @Override
    public Page<City> findAll(Pageable pageable) {
        return usersRepo.findAll(pageable);
    }

    @Override
    public void save(City users) {
        System.out.println("lam den đay");
        System.out.println("lam den đay");
        System.out.println("lam den đay");
        System.out.println("lam den đay");
    usersRepo.save(users);
    }

    @Override
    public void delete(long id) {
    usersRepo.deleteById(id);
    }

    @Override
    public City findById(long id) {
        return usersRepo.findById(id).get();
    }

    @Override
    public Page<City> findUsersByName(String name, Pageable pageable) {
        return usersRepo.findAllByName(name,pageable);
    }
}
