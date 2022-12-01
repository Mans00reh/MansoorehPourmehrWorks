package com.mansoorehCo.demo.controller;

import com.mansoorehCo.demo.entity.CsvFile;
import com.mansoorehCo.demo.service.CsvFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.util.List;

@RestController
@RequestMapping("/files")
public class CsvFileController {
    @Autowired
    CsvFileService csvFileService;

    @RequestMapping(value = "/upload", method = RequestMethod.POST, consumes = "multipart/*")
    public ResponseEntity<CsvFile> createFile(@RequestParam("csvFile") MultipartFile file, @RequestParam("name") String name) {
        return new ResponseEntity<>(csvFileService.uploadFile(file, "firstFile"), HttpStatus.OK);
    }

    @GetMapping("/find-all")
    public ResponseEntity<List<CsvFile>> getAllCsvFiles() {
        return new ResponseEntity<>(csvFileService.getAll(), HttpStatus.OK);
    }

    /*@GetMapping("/{code}")
    public ResponseEntity<CsvEntity> getCsvFile(@PathVariable(value = "code") Long code) {
        return new ResponseEntity<>(csvFileService.getByCode(code), HttpStatus.OK);
    }*/

    @DeleteMapping("/delete-all")
    public ResponseEntity<Boolean> deleteAllCsvFiles() {
        csvFileService.deleteAll();
        return new ResponseEntity<>(true,HttpStatus.OK);

    }

}
