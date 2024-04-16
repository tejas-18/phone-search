package com.example.phonesearch.service;

import com.example.phonesearch.model.Phone;
import com.example.phonesearch.repository.PhoneRepo;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


import java.util.Optional;
import org.springframework.web.multipart.MultipartFile;

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

  public List<Phone> saveCsvToDataBase(MultipartFile file) throws IOException {
    InputStream fis = file.getInputStream();
    Workbook workbook = new XSSFWorkbook(fis);
    Sheet sheet = workbook.getSheetAt(0);
    List<Phone> phoneList = new ArrayList<>();
    for (Row row : sheet) {
      // Skip header row
      if (row.getRowNum() == 0) {
        continue;
      }

      Phone phone = Phone.builder()
          .brand_name(row.getCell(0) != null && row.getCell(0).getCellType() != CellType.BLANK
              ? row.getCell(0).getStringCellValue() : null)
          .model(row.getCell(1) != null && row.getCell(1).getCellType() != CellType.BLANK
              ? row.getCell(1).getStringCellValue() : null)
          .price(row.getCell(2) != null && row.getCell(2).getCellType() != CellType.BLANK
              ? row.getCell(2).getNumericCellValue() : null)
          .avg_rating(row.getCell(3) != null && row.getCell(3).getCellType() != CellType.BLANK
              ? row.getCell(3).getNumericCellValue() : null)
          .is_5G(row.getCell(4) != null && row.getCell(4).getCellType() != CellType.BLANK ?
              row.getCell(4).getNumericCellValue() == 1.0 : null)
          .processor_brand(row.getCell(5) != null && row.getCell(5).getCellType() != CellType.BLANK
              ? row.getCell(5).getStringCellValue() : null)
          .num_cores(row.getCell(6) != null && row.getCell(6).getCellType() != CellType.BLANK
              ? (int) row.getCell(6).getNumericCellValue() : null)
          .processor_speed(row.getCell(7) != null && row.getCell(7).getCellType() != CellType.BLANK
              ? row.getCell(7).getNumericCellValue() : null)
          .battery_capacity(row.getCell(8) != null && row.getCell(8).getCellType() != CellType.BLANK
              ? (int) row.getCell(8).getNumericCellValue() : null)
          .fast_charging_available(
              row.getCell(9) != null && row.getCell(9).getCellType() != CellType.BLANK ?
                  row.getCell(9).getNumericCellValue() == 1.0 : null)
          .fast_charging(row.getCell(10) != null && row.getCell(10).getCellType() != CellType.BLANK
              ? (int) row.getCell(10).getNumericCellValue() : null)
          .ram_capacity(row.getCell(11) != null && row.getCell(11).getCellType() != CellType.BLANK
              ? (int) row.getCell(11).getNumericCellValue() : null)
          .internal_memory(
              row.getCell(12) != null && row.getCell(12).getCellType() != CellType.BLANK
                  ? (int) row.getCell(12).getNumericCellValue() : null)
          .screen_size(row.getCell(13) != null && row.getCell(13).getCellType() != CellType.BLANK
              ? row.getCell(13).getNumericCellValue() : null)
          .refresh_rate(row.getCell(14) != null && row.getCell(14).getCellType() != CellType.BLANK
              ? (int) row.getCell(14).getNumericCellValue() : null)
          .num_rear_cameras(
              row.getCell(15) != null && row.getCell(15).getCellType() != CellType.BLANK
                  ? (int) row.getCell(15).getNumericCellValue() : null)
          .os(row.getCell(16) != null && row.getCell(16).getCellType() != CellType.BLANK
              ? row.getCell(16).getStringCellValue() : null)
          .primary_camera_rear(
              row.getCell(17) != null && row.getCell(17).getCellType() != CellType.BLANK
                  ? row.getCell(17).getNumericCellValue() : null)
          .primary_camera_front(
              row.getCell(18) != null && row.getCell(18).getCellType() != CellType.BLANK
                  ? row.getCell(18).getNumericCellValue() : null)
          .extended_memory_available(
              row.getCell(19) != null && row.getCell(19).getCellType() != CellType.BLANK ?
                  row.getCell(19).getNumericCellValue() == 1.0 : null)
          .resolution_height(
              row.getCell(20) != null && row.getCell(20).getCellType() != CellType.BLANK
                  ? (int) row.getCell(20).getNumericCellValue() : null)
          .resolution_width(
              row.getCell(21) != null && row.getCell(21).getCellType() != CellType.BLANK
                  ? (int) row.getCell(21).getNumericCellValue() : null)
          .build();

      phoneRepo.save(phone);
      phoneList.add(phone);
      System.out.println("Added " + phone.getModel() + " : " + phone);
    }

    workbook.close();
    fis.close();

    return phoneList;
  }

}



