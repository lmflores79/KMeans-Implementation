package com.sye.pr.dal.impl;

import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import static org.junit.Assert.*;

import com.sye.pr.dal.exceptions.LoadDataException;
import com.sye.pr.dal.impl.CsvReaderImpl;

public class CsvReaderImplTest {

	@Rule
    public TemporaryFolder folder = new TemporaryFolder();
	private File file;
	private CsvReaderImpl reader;
	private static final String FILE_NAME = "test.csv";

	@Before
	public void setup() throws IOException{
        
		file = folder.newFile(FILE_NAME);
		
		PrintWriter pw = new PrintWriter(file);
        pw.println("10,20,15,12");
        pw.println("11,21,16,13");
        pw.println("12,22,17,14");
        pw.println("13,23,18,15");
        pw.println("14,24,19,16");
        pw.println("15,25,20,17");
        pw.println("16,26,21,18");
        pw.println("17,27,22,19");
        pw.println("18,28,23,20");
        pw.println("19,29,24,21");
        pw.println("20,30,25,22");
        pw.println("21,31,26,23");
        pw.println("22,32,27,24");
        pw.println("23,33,28,25");
        pw.println("24,34,29,26");
        pw.println("25,35,30,27");
        pw.println("26,36,31,28");
        pw.println("27,37,32,29");
        pw.flush();
        pw.close();
		
        reader = new CsvReaderImpl();
        
        
	}
	
	@Test
	public void testRead(){
		assertTrue(file.exists());		
		List<double[]> records = reader.read(file.getAbsolutePath());
		
		assertEquals(18,records.size());
		
		/** We test first and last elements */		
		assertArrayEquals( new double[]{10,20,15,12}, records.get(0),0);
		assertArrayEquals( new double[]{27,37,32,29}, records.get(records.size() -1),0);		
		
	}
	
	@Test(expected=LoadDataException.class)
	public void testLoadDataException(){		
		reader.read("non-existing-file.csv");
	}
	

	
	
}

