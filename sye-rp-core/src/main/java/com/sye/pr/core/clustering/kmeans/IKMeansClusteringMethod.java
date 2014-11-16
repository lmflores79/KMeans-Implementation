package com.sye.pr.core.clustering.kmeans;


import java.util.Set;

import com.sye.pr.core.clustering.kmeans.model.IKMeansModel;
import com.sye.pr.core.model.IPattern;

/** 
 * This interface is intended to be implemented by those classes which
 * are going to provide a service for clustering using an implementation of
 * the KMeans algorithm
 * 
 * @author luis m flores
 * @version 1.0
 * @since 15-11-2014
 * 
 */
public interface IKMeansClusteringMethod {
	
	/**
	 * 
	 * @param patterns        Set of patterns to work with
	 * @param k               Number of clusters to generate
	 * @param maxIterations   Max number of iterations in case the algorithm do not converges 
	 * @return                KMeansModel with the final result  
	 */
	public IKMeansModel cluster(Set<IPattern> patterns, int k, int maxIterations);		
}
