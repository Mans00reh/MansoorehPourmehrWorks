package com.mansoorehCo.demo.repository;

import com.mansoorehCo.demo.entity.CsvFile;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CsvFileRepository extends CrudRepository<CsvFile, Long> {
}
