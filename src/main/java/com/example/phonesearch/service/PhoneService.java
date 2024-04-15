package com.example.phonesearch.service;

import com.example.phonesearch.model.Phone;
import com.example.phonesearch.repository.PhoneRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Collections;

import java.util.Optional;

@Service
public class PhoneService {

    @Autowired
    PhoneRepo phoneRepo;

    public List<Phone> getListOfPhone() {
        return phoneRepo.findAll();
    }

    public Optional<Phone> getPhoneById(Long id) {
        return phoneRepo.findById(id);
    }
}



