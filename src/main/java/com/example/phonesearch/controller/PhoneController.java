package com.example.phonesearch.controller;

import com.example.phonesearch.model.Phone;
import com.example.phonesearch.service.PhoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/v1/")
public class PhoneController {

    @Autowired
    PhoneService phoneService;

    @GetMapping("/sms/{name}")
    String getMsg(@PathVariable String name){
        return "Hi " + name;
    }
    // localhost:9091/v1/sms/Tejas

    @GetMapping("/getAllPhones")
    List<Phone> getAllPhone(){
        List<Phone> listOfPhone = phoneService.getListOfPhone();
        System.out.println(listOfPhone);
        return listOfPhone;
    }

    @GetMapping("/getPhone/{id}")
    public ResponseEntity<Phone> getPhoneById(@PathVariable Long id) {
        Optional<Phone> phoneOptional = phoneService.getPhoneById(id);
        if (phoneOptional.isPresent()) {
            return ResponseEntity.ok(phoneOptional.get());
        } else {
            return ResponseEntity.notFound().build();
        }

    }



}
