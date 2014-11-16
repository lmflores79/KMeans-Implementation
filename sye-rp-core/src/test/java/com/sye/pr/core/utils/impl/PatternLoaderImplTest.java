package com.sye.pr.core.utils.impl;


import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static org.junit.Assert.*;
import static org.easymock.EasyMock.*;

import org.junit.Before;
import org.junit.Test;

import com.sye.pr.core.model.IPattern;
import com.sye.pr.core.utils.impl.PatternLoaderImpl;
import com.sye.pr.dal.IReader;

public class PatternLoaderImplTest {

	private PatternLoaderImpl patternLoader;
	private IReader reader;
	private List<double[]> records;
	private String fileName = "records.csv";
	
	@Before
	public void setup(){
		reader = createMock(IReader.class);
		patternLoader = new PatternLoaderImpl();
		patternLoader.setReader(reader);
		records = new ArrayList<double[]>();
		
		records.add(new double[]{10,20,15,12});
		records.add(new double[]{11,21,16,13});
		records.add(new double[]{12,22,17,14});
		records.add(new double[]{13,23,18,15});
		records.add(new double[]{14,24,19,16});
		records.add(new double[]{15,25,20,17});
		records.add(new double[]{16,26,21,18});
		records.add(new double[]{17,27,22,19});
		records.add(new double[]{18,28,23,20});
		records.add(new double[]{19,29,24,21});
		records.add(new double[]{20,30,25,22});
		records.add(new double[]{21,31,26,23});
		records.add(new double[]{22,32,27,24});
		records.add(new double[]{23,33,28,25});
		records.add(new double[]{24,34,29,26});
		records.add(new double[]{25,35,30,27});
		records.add(new double[]{26,36,31,28});
		records.add(new double[]{27,37,32,29});
		
	}
	


	/**
	 * Test if pattern are properly instantiated 
	 * from the list provided
	 */
	@Test
	public void testLoadPatterns(){		
		
		expect(reader.read(fileName)).andReturn(records);
		replay(reader);
		Set<IPattern> patterns = patternLoader.loadPatterns(fileName);
		assertNotNull(patterns);
		assertEquals(patterns.size(), records.size());		
	}
}
