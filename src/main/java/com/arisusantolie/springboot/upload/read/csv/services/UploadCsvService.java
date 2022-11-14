package com.arisusantolie.springboot.upload.read.csv.services;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
    Credit By : Ari Susanto Lie
    Website : https://arisusantolie.my.id
 */

@Service
public class UploadCsvService {

    public List<Map<String,Object>> extractCsvFile(MultipartFile csvFile) throws IOException {

        Reader reader = new InputStreamReader(csvFile.getInputStream());
        CSVParser csvParser = CSVFormat.DEFAULT.withHeader("FirstName","MiddleName","LastName").parse(reader);

        List<Map<String,Object>> response=new ArrayList<>();
        for (CSVRecord csvRecord : csvParser) {
            if(csvRecord.getRecordNumber()!=1){ //Note : skip if record number == 1, because row 1 is a header row.
                Map<String,Object> dt=new HashMap<>();
                dt.put("firstName",csvRecord.get("FirstName"));
                dt.put("middleName",csvRecord.get("MiddleName"));
                dt.put("lastName",csvRecord.get("LastName"));

                response.add(dt);

            }
        }

        return response;
    }
}



