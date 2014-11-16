package com.sye.pr.core.clustering.kmeans;

import java.util.List;
import java.util.Set;

import com.sye.pr.core.clustering.kmeans.model.ICluster;
import com.sye.pr.core.model.IPattern;

/** 
 * This interface is meant to be implemented by those classes which
 * are going to provide a service for selecting initial cluster configuration. There are 
 * several proposal of how to choose the initial clusters and centroids, therefore,
 * a KMeans implementation could use several choices by just changing the spring configuration
 * 
 * @author luis m flores
 * @version 1.0
 * @since 15-11-2014
 * 
 */

public interface IClusterSelector {

	/**
	 * Method for getting the initial cluster configuration
	 * 
	 * @param patterns    Set of patterns to work with
	 * @param k           Number of iterations
	 * @return            List of initial clusters to use
	 */
	public List<ICluster> getInitialClusters(Set<IPattern> patterns,int k);
}
