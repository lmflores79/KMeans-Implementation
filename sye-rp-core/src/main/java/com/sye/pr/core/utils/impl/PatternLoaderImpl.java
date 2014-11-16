package com.sye.pr.core.utils.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.sye.pr.core.model.IPattern;
import com.sye.pr.core.model.impl.PatternImpl;
import com.sye.pr.core.utils.IPatternLoader;
import com.sye.pr.core.utils.distance.impl.EuclideanDistanceCalculatorImpl;
import com.sye.pr.dal.IReader;

public class PatternLoaderImpl implements IPatternLoader {

	private IReader reader;
	
	private static final Logger logger = LogManager.getLogger(PatternLoaderImpl.class);
	
	@Override
	public Set<IPattern> loadPatterns(String fileName) {
		// TODO Auto-generated method stub
		List<double[]> records = reader.read(fileName);
		Set<IPattern> patterns = new LinkedHashSet<IPattern>();
		
		logger.info("Creating patterns");
		for(double[] record : records){
			IPattern pattern = new PatternImpl();
			pattern.setPattern(record);
			patterns.add(pattern);
		}
		return patterns;
	}

	public IReader getReader() {
		return reader;
	}

	public void setReader(IReader reader) {
		this.reader = reader;
	}

}
