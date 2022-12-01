package com.mansoorehCo.demo.service;

import com.mansoorehCo.demo.entity.CsvFile;
import com.mansoorehCo.demo.repository.CsvFileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class CsvFileService {
    @Autowired
    CsvFileRepository csvFileRepository;

    public CsvFile uploadFile(MultipartFile file , String fileName){
     //   createRows(file);
        if (!file.isEmpty()){
            CsvFile csvFile = null;
            try {
                csvFile = new CsvFile(fileName, file.getBytes());
            } catch (IOException e) {
                e.printStackTrace();
            }
            return csvFileRepository.save(csvFile);
        }
        return null;
    }

    public List<CsvFile> getAll(){
        return (List<CsvFile>) csvFileRepository.findAll();
    }

    public void deleteAll(){
        csvFileRepository.deleteAll();
    }

    /*private  List<List<CsvEntity>> createRows(MultipartFile file){
        List<List<CsvEntity>> records = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(file)) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split("");
                records.add(Arrays.asList(values));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return records;
    }*/
}
