package com.sye.pr.core.clustering.kmeans.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.sye.pr.core.clustering.kmeans.IClusterSelector;
import com.sye.pr.core.clustering.kmeans.model.ICluster;
import com.sye.pr.core.clustering.kmeans.model.impl.ClusterImpl;
import com.sye.pr.core.model.IPattern;

/** 
 * Implementation for IClusterSelector that chooses randomly 
 * the initial clusters based on existing patterns found in the pattern set 
 * 
 * @author luis m flores
 * @version 1.0
 * @since 15-11-2014
 * 
 */

public class RandomClusterSelectorImpl implements IClusterSelector {

	private static final Logger logger = LogManager.getLogger(RandomClusterSelectorImpl.class);
	
	@Override
	public List<ICluster> getInitialClusters(Set<IPattern> patterns,int k) {
		
		List<ICluster> clusters = new ArrayList<ICluster>();		
		
		Object[] patternsArray = patterns.toArray();
		logger.info("Selecting randomly initial centroids");
		for(int i=0; i < k; i++){			
			int patternForClusterIdx = (int)(Math.random() * patterns.size());
			logger.info("Random Index generated: " + patternForClusterIdx);
			logger.info("Pattern for random index : " + patternForClusterIdx + " = " + (IPattern)patternsArray[patternForClusterIdx]);
			ClusterImpl cluster = new ClusterImpl(i);
			
			cluster.addPattern((IPattern)patternsArray[patternForClusterIdx]);
			cluster.updateCentroid();
			clusters.add(cluster);
		}		
		
		return clusters;
	}

}
