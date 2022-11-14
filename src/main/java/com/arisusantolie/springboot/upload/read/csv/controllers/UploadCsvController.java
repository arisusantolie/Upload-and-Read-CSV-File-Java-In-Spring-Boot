package com.arisusantolie.springboot.upload.read.csv.controllers;

import com.arisusantolie.springboot.upload.read.csv.services.UploadCsvService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Map;

/*
    Credit By : Ari Susanto Lie
    Website : https://arisusantolie.my.id
 */

@RestController
@RequestMapping("api/csv")
public class UploadCsvController {

    @Autowired
    UploadCsvService uploadCsvService;

    @PostMapping()
    public List<Map<String,Object>> extractCsv(@RequestParam(value = "file")MultipartFile file) throws IOException {
        return uploadCsvService.extractCsvFile(file);
    }
}
