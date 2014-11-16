package com.sye.pr.core.clustering.kmeans.impl;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

import com.sye.pr.core.clustering.kmeans.model.ICluster;
import com.sye.pr.core.model.IPattern;
import com.sye.pr.core.model.impl.PatternImpl;
import com.sye.pr.core.testing.utils.TestUtils;

public class RandomClusterSelectorImplTest {

	private RandomClusterSelectorImpl randomClusterSelector;
	private Set<IPattern> patterns;
	
	@Before
	public void setup(){		
		randomClusterSelector = new RandomClusterSelectorImpl();		
		patterns = TestUtils.getTestPatternSet();		
	}
	
	@Test
	public void testRandomSelection(){
		List<ICluster> clusters = randomClusterSelector.getInitialClusters(patterns, 3);
		
		/**
		 * As selection is random, we cannot test 
		 * anything but the number of clusters generated
		 * */
		assertEquals(3, clusters.size());
	}
}
