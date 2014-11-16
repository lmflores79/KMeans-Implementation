package com.sye.pr.dal.impl;


import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.csvreader.CsvReader;
import com.sye.pr.dal.IReader;
import com.sye.pr.dal.exceptions.LoadDataException;

public class CsvReaderImpl implements IReader {

	private static final Logger logger = LogManager.getLogger(CsvReaderImpl.class);
	@Override
	public List<double[]> read(String fileName) {
		// TODO Auto-generated method stub
		logger.info("Loading data from " + fileName);
		List<double[]> records = new ArrayList<double[]>();
		CsvReader csvReader = null;
		try{
			csvReader = new CsvReader(fileName);
			
			
			while(csvReader.readRecord()){
				int cols = csvReader.getColumnCount();
				double[] record = new double[cols];
				for(int i=0; i< cols; i++){
					record[i] = Double.parseDouble(csvReader.get(i));
				}
				records.add(record);
			}
			
			
			
		}catch(Exception e){
			e.printStackTrace();
			throw new LoadDataException(e);
		}finally{
			if(csvReader != null){
				csvReader.close();
			}
		}
		
		return records;
	}

}
