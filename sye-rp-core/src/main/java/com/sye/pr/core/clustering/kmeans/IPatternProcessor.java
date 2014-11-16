package com.sye.pr.core.clustering.kmeans;

import java.util.List;
import java.util.Set;

import com.sye.pr.core.clustering.kmeans.model.ICluster;
import com.sye.pr.core.model.IPattern;

/** 
 * This interface is intended to be implemented by those classes which
 * are going to provide a service for doing the actual clustering used by the KMeansClusteringMethod service.
 * As there are several variations of the KMeans algorithm, this way, one KMeansCLustering class could use several different variations
 * through this interface just changing the spring configuration
 * 
 * 
 * @author luis m flores
 * @version 1.0
 * @since 15-11-2014
 * 
 */

public interface IPatternProcessor {

	/**
	 * This method represents the logic of the algorithm for one iteration. Its responsibilities are assigning the patterns
	 * to a specific cluster following the logic for the KMeans variation used.
	 * 
	 * @param patterns   Pattern set to process
	 * @param clusters   Cluster configuration
	 * @return		     true if there were adjustments and another iteration is required or false 
	 *                   if there were no adjustments and another iteration is not required.
	 */
	public boolean processPattern(Set<IPattern> patterns,List<ICluster> clusters);
}
