package com.sye.pr.core.clustering.kmeans.impl;

import java.util.List;
import java.util.Set;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.sye.pr.core.clustering.kmeans.model.ICluster;
import com.sye.pr.core.model.IPattern;
import com.sye.pr.core.testing.utils.TestUtils;
import com.sye.pr.core.utils.distance.impl.EuclideanDistanceCalculatorImpl;

public class StandardPatternProcessorImplTest {

	private Set<IPattern> patterns;
	private StandardPatternProcessorImpl patternProcessor;

	@Before
	public void setup(){
		
		/** We get a predefined set of Patterns in a specific order and setup all necessary classes */
		patterns = TestUtils.getTestPatternSet();
		patternProcessor = new StandardPatternProcessorImpl();
		patternProcessor.setDistanceCalculator(new EuclideanDistanceCalculatorImpl());;
	}
	
	
	
	/**
	 * Knowing an initial configuration of clusters and patterns, we can predict how the algorithm will behave
	 * Here we test one iteration with a predefined cluster's and pattern's configuration
	 */
	@Test
	public void test(){
		
		
		List<ICluster> clusters = TestUtils.getInitialClusterList();
		boolean iterateAgain = patternProcessor.processPattern(patterns, clusters);
		
		/** It is expected that this iteration is not the final one*/
		assertTrue(iterateAgain);
		
		
		/**
		 * We know where patterns should be assigned. Therefore, we test two patterns per cluster
		 */
		Object[] patternArray = patterns.toArray();
		assertTrue(clusters.get(0).containsPattern((IPattern)patternArray[0]));
		assertTrue(clusters.get(0).containsPattern((IPattern)patternArray[1]));

		assertTrue(clusters.get(1).containsPattern((IPattern)patternArray[21]));
		assertTrue(clusters.get(1).containsPattern((IPattern)patternArray[28]));
		
		assertTrue(clusters.get(2).containsPattern((IPattern)patternArray[15]));
		assertTrue(clusters.get(2).containsPattern((IPattern)patternArray[22]));
		
		/**
		 * We also know where centroids should be. We test for them as well
		 */		
		assertArrayEquals(new double[]{23.16,21}, clusters.get(0).getCentroid().getMean(),1);
		assertArrayEquals(new double[]{50.83,60}, clusters.get(1).getCentroid().getMean(),1);
		assertArrayEquals(new double[]{40,37}, clusters.get(2).getCentroid().getMean(),1);
		
	}
	
}
