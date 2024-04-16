package com.example.phonesearch.controller;


import com.example.phonesearch.service.PhoneService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;


@RestController
@RequestMapping("/v2/")
public class MyPhoneController {


  @Autowired
  PhoneService phoneService;

  @PostMapping("/uploadExcel")
  public ResponseEntity<?> uploadFile(@RequestParam("file") MultipartFile file) {
    try {
      if (!file.getOriginalFilename().endsWith(".xls") && !file.getOriginalFilename()
          .endsWith(".xlsx")) {
        throw new Exception("Only XLS and XLSX files are supported");
      }

      return ResponseEntity.status(HttpStatus.CREATED)
          .body(phoneService.saveCsvToDataBase(file));
    } catch (Exception e) {
      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
          .body("Failed to upload file or : " + e.getMessage());
    }
  }

}
