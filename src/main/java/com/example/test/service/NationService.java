package com.example.test.service;

import com.example.test.model.Nation;
import com.example.test.repository.INationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class NationService implements INationService {
    @Autowired
    INationRepo nationRepo;
    @Override
    public List<Nation> findAll() {
        return nationRepo.findAll();
    }
}
