package com.sye.pr.core.clustering.kmeans.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.sye.pr.core.clustering.kmeans.IClusterSelector;
import com.sye.pr.core.clustering.kmeans.IKMeansClusteringMethod;
import com.sye.pr.core.clustering.kmeans.IPatternProcessor;
import com.sye.pr.core.clustering.kmeans.model.ICentroid;
import com.sye.pr.core.clustering.kmeans.model.ICluster;
import com.sye.pr.core.clustering.kmeans.model.IKMeansModel;
import com.sye.pr.core.clustering.kmeans.model.impl.ClusterImpl;
import com.sye.pr.core.clustering.kmeans.model.impl.KMeansModelImpl;
import com.sye.pr.core.model.IPattern;
import com.sye.pr.core.utils.distance.IDistanceCalculator;

/** 
 * Implementation of KMeansCLusteringMethod for providing a service for clustering 
 * 
 * @author luis m flores
 * @version 1.0
 * @since 15-11-2014
 * 
 */

public class KMeansClusteringMethodImpl implements IKMeansClusteringMethod{

	private static final Logger logger = LogManager.getLogger(KMeansClusteringMethodImpl.class);
	
	
	/**
	 * Pattern Processor
	 */
	private IPatternProcessor patternProcessor;
	
	/**
	 * Clusters
	 */
	private List<ICluster> clusters;
	
	/**
	 * Cluster selector foe getting initial configuration
	 */
	private IClusterSelector clusterSelector;	

	/**
	 * Method exposed through KMeansClusterMethod interface
	 */
	@Override
	public IKMeansModel cluster(Set<IPattern> patterns, int k, int maxIterations){
		logger.info("Clustering started...");
		logger.info("Parameters k = " + k + " maxIterations = " + maxIterations);

		logger.info("For pattern set:");
		for(IPattern pattern: patterns){
			logger.info(pattern);
		}
		
		clusters = clusterSelector.getInitialClusters(patterns, k);

		int iteration = 0;
		do{
			logger.info("Iteration #" + iteration +  ": Starting");
			if(!patternProcessor.processPattern(patterns, clusters)){
				logger.info("Iteration #" + iteration +  ": Finished: No exchange of patterns between clusters");				
				break;
			}else{
				logger.info("There was exchange of pattern between clusters. Continue iterating.");
			}
			logger.info("Iteration #" + iteration +  ": Finished");
			iteration++;
		}while(iteration < maxIterations);
		
		logger.info("Creating model for the result");
		KMeansModelImpl kmeansModel = new KMeansModelImpl();
		kmeansModel.setClusters(clusters);
		
		return kmeansModel;		
	}
	
	
	/** Getters and Setters */

	public IClusterSelector getClusterSelector() {
		return clusterSelector;
	}


	public void setClusterSelector(IClusterSelector clusterSelector) {
		this.clusterSelector = clusterSelector;
	}


	public IPatternProcessor getPatternProcessor() {
		return patternProcessor;
	}


	public void setPatternProcessor(IPatternProcessor patternProcessor) {
		this.patternProcessor = patternProcessor;
	}
}
