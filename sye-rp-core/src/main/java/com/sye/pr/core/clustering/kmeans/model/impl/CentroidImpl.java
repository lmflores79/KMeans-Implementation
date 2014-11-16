package com.sye.pr.core.clustering.kmeans.model.impl;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.sye.pr.core.clustering.kmeans.impl.KMeansClusteringMethodImpl;
import com.sye.pr.core.clustering.kmeans.model.ICentroid;
import com.sye.pr.core.model.IPattern;

public class CentroidImpl implements ICentroid {

	private double[] mean;
	private static final Logger logger = LogManager.getLogger(KMeansClusteringMethodImpl.class);
	
	@Override
	public double[] getMean() {
		// TODO Auto-generated method stub
		return mean;
	}

	@Override
	public void updateMean(Set<IPattern> patterns) {
		// TODO Auto-generated method stub
		/** We get the first pattern to init the centroid mean*/
		logger.info("Updating Centroid... " + patterns);
		if(!patterns.iterator().hasNext()){
			logger.info("There are no patterns for the centroid to be updated");
			return;
		}
		int patternLenght = patterns.iterator().next().getPattern().length;
		mean = new double[patternLenght];
		for(IPattern pattern: patterns){
			int featureCount = 0;
			for(double feature: pattern.getPattern()){
				mean[featureCount] += feature;
				featureCount++;
			}
		}
		
		
		for(int i=0; i < patternLenght; i++){
			mean[i] = mean[i] / patterns.size();
		}
		
		logger.info("Centroid sucessfully updated. " + this.toString());

	}

	@Override
	public String toString() {
		return "Centroid: [Mean=" + Arrays.toString(mean) + "]";
	}
	

}
