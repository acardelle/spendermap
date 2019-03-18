package com.cardelle.SpenderMap2.models;

import com.opencsv.bean.ColumnPositionMappingStrategy;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.List;

public class CSVTrans {
        private static final String SAMPLE_CSV_FILE_PATH = "test.csv";

        public static void loadCSV() throws IOException {
            try (
                    Reader reader = Files.newBufferedReader(Paths.get(SAMPLE_CSV_FILE_PATH));
            ) {
                ColumnPositionMappingStrategy strategy = new ColumnPositionMappingStrategy();
                strategy.setType(Transaction.class);
                String[] memberFieldsToBindTo = {"name", "description"};
                strategy.setColumnMapping(memberFieldsToBindTo);

                CsvToBean<Transaction> csvToBean = new CsvToBeanBuilder(reader)
                        .withMappingStrategy(strategy)
                        .withSkipLines(1)
                        .withIgnoreLeadingWhiteSpace(true)
                        .build();

                Iterator<Transaction> myTransactionIterator = csvToBean.iterator();

                while (myTransactionIterator.hasNext()) {
                  Transaction NewTrans = myTransactionIterator.next();
                }
            }
        }
    }
