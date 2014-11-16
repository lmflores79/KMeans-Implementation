package com.sye.pr.core.clustering.kmeans.impl;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

import static org.easymock.EasyMock.*;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

import com.sye.pr.core.clustering.kmeans.IClusterSelector;
import com.sye.pr.core.clustering.kmeans.model.ICluster;
import com.sye.pr.core.clustering.kmeans.model.IKMeansModel;
import com.sye.pr.core.clustering.kmeans.model.impl.ClusterImpl;
import com.sye.pr.core.clustering.kmeans.model.impl.KMeansModelImpl;
import com.sye.pr.core.clustering.test.annotations.IntegrationTest;
import com.sye.pr.core.model.IPattern;
import com.sye.pr.core.testing.utils.TestUtils;
import com.sye.pr.core.utils.distance.IDistanceCalculator;
import com.sye.pr.core.utils.distance.impl.EuclideanDistanceCalculatorImpl;

/**
 * This is an example of an "integration test" for this little application
 * using standard maven FailSafe plugin behaviour
 * 
 * For this, we want to test not just an unit but the whole application,
 * however, for this test to be predictable we have to know the initial cluster configuration,
 * therefore, we do need to mock the ClusterSelector as it is used inside the KMeansClusteringMethod
 * and we need to control what it returns
 * 
 * @author luis m flores
 * @version 1.0
 * @since 15-11-2014
 *
 */


public class KMeansClusteringMethodImplIT {

	private Set<IPattern> patterns;
	private KMeansClusteringMethodImpl kmeansClusteringMthd;
	private List<ICluster> clusters;
	private IClusterSelector clusterSelector;
	

	@Before
	public void setup(){
		
		patterns = TestUtils.getTestPatternSet();
		clusters = TestUtils.getInitialClusterList();
		
		
		StandardPatternProcessorImpl patternProcessor = new StandardPatternProcessorImpl();
		patternProcessor.setDistanceCalculator(new EuclideanDistanceCalculatorImpl());
		
		clusterSelector = createMock(IClusterSelector.class);
		
		kmeansClusteringMthd = new KMeansClusteringMethodImpl();		
		kmeansClusteringMthd.setPatternProcessor(patternProcessor);
		
		kmeansClusteringMthd.setClusterSelector(clusterSelector);
		
	}
	
	
	/**
	 * This method test a well known configuration to see if the overall implementation works fine.
	 * This test is based on the kmeans-run.xls file sheet "8a Iteracion"contained in the test resources folder which shows
	 * a complete run of the algorithm for some two dimensional patterns with an initial 3 cluster configuration.
	 */
	@Test
	public void testClusteringService(){
		expect(clusterSelector.getInitialClusters(patterns, 3)).andReturn(clusters);
		replay(clusterSelector);
		
		IKMeansModel kmeansModel = kmeansClusteringMthd.cluster(patterns, 3, 100);
		
		/** We first test each centroid of each cluster */
		
		List<ICluster> finalClusters = kmeansModel.getClusters();
		
		assertArrayEquals(new double[]{17,18},finalClusters.get(0).getCentroid().getMean(), 0);
		assertArrayEquals(new double[]{48.75,57.5},finalClusters.get(1).getCentroid().getMean(), 0);
		assertArrayEquals(new double[]{32.90,25.72},finalClusters.get(2).getCentroid().getMean(), 1);
		
		/** Now we test that some patterns belong to the expected custer */
		Object[] patternArray = patterns.toArray();
		
		assertTrue(finalClusters.get(0).containsPattern((IPattern)patternArray[0]));
		assertTrue(finalClusters.get(0).containsPattern((IPattern)patternArray[10]));
		
		assertTrue(finalClusters.get(1).containsPattern((IPattern)patternArray[21]));
		assertTrue(finalClusters.get(1).containsPattern((IPattern)patternArray[28]));
		
		assertTrue(finalClusters.get(2).containsPattern((IPattern)patternArray[14]));
		assertTrue(finalClusters.get(2).containsPattern((IPattern)patternArray[20]));

	}
	
}
