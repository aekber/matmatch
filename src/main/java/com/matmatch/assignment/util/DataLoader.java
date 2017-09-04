package com.matmatch.assignment.util;

import java.io.InputStream;
import java.util.Collections;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;

@Component
public class DataLoader
{     
    private static Logger LOG = LoggerFactory.getLogger(DataLoader.class);

    public <T> List<T> loadObjectList(Class<T> type, String fileName) 
    {
        try {
            CsvSchema bootstrapSchema = CsvSchema.emptySchema().withHeader();
            CsvMapper mapper = new CsvMapper();
            
            ClassPathResource classPathResource = new ClassPathResource(fileName);
            InputStream inputStream = classPathResource.getInputStream();
            MappingIterator<T> readValues = mapper.readerFor(type).with(bootstrapSchema).readValues(inputStream);
            return readValues.readAll();
        } catch (Exception e) {
            LOG.error("Error occurred while loading object list from file " + fileName, e);
            return Collections.emptyList();
        }
    }
}
