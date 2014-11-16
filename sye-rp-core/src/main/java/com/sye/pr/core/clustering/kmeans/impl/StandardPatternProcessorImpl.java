package com.sye.pr.core.clustering.kmeans.impl;

import java.util.List;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.sye.pr.core.clustering.kmeans.IPatternProcessor;
import com.sye.pr.core.clustering.kmeans.model.ICluster;
import com.sye.pr.core.clustering.kmeans.model.impl.ClusterImpl;
import com.sye.pr.core.model.IPattern;
import com.sye.pr.core.utils.distance.IDistanceCalculator;

/**
 * This class implements the standard kmeans algorithm over one iteration
 * 
 * @author luis m flores
 *
 */
public class StandardPatternProcessorImpl implements IPatternProcessor {
	
	private static final Logger logger = LogManager.getLogger(StandardPatternProcessorImpl.class);
	
	private IDistanceCalculator distanceCalculator;
	
	@Override
	public boolean processPattern(Set<IPattern> patterns,
			List<ICluster> clusters) {
		boolean adjustment = false;
		for(IPattern pattern: patterns){
			logger.info("Evaluating pattern " + pattern);
			
			double minDistance = 0;
			boolean first = true;
			ICluster currentCluster = null;
			ICluster newCluster = null;
			for(ICluster cluster: clusters){
				logger.info("Verifying distance for cluster " + cluster.getId());
				double distance = distanceCalculator.calculateDistance(pattern, cluster.getCentroid().getMean());
				logger.info("Distance: " + distance);
				if(cluster.containsPattern(pattern)){
					logger.info("The pattern is already in the cluster. ");
					currentCluster = cluster;
					logger.info("Current Cluster = " + cluster.getId());
				}
				if(first || distance < minDistance){
					if(first){
						first = false;
					}
					minDistance = distance;					
					newCluster = cluster;
					logger.info("Minimum distance found so far : " + minDistance);
					logger.info("Potential cluster to add the pattern to: " + cluster.getId());
				}				
			}
			
			if(newCluster != currentCluster){
				
				adjustment = true;
				
				if(currentCluster != null){
					logger.info("Exchanging pattern from cluster " + currentCluster.getId() + " to cluster " + newCluster.getId());
					currentCluster.removePattern(pattern);	
				}else{
					logger.info("Assigning pattern to cluster " + newCluster.getId());
				}
				newCluster.addPattern(pattern);
			}else{
				logger.info("There is no cluster exchange for the pattern");
			}
		}
		
		if(adjustment){
			logger.info("There was exchange of pattern between clusters. Adjusting cluster's centroids.");
			for(ICluster cluster: clusters){
				((ClusterImpl)cluster).updateCentroid();
			}
			
		}
		
		return adjustment;
	}

	/** Getters and setters */
	public IDistanceCalculator getDistanceCalculator() {
		return distanceCalculator;
	}

	public void setDistanceCalculator(IDistanceCalculator distanceCalculator) {
		this.distanceCalculator = distanceCalculator;
	}

}
