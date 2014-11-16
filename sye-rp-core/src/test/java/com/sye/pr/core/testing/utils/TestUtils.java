package com.sye.pr.core.testing.utils;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import com.sye.pr.core.clustering.kmeans.model.ICluster;
import com.sye.pr.core.clustering.kmeans.model.impl.ClusterImpl;
import com.sye.pr.core.model.IPattern;
import com.sye.pr.core.model.impl.PatternImpl;

public class TestUtils {

	protected static double[][] features = {{10,10},
									 {15,10},
									 {20,15},
									 {15,15},
									 {10,15},
									 {15,20},
									 {20,20},
									 {25,20},
									 {25,25},
									 {20,25},
									 {20,30},
									 {25,30},
									 {30,30},
									 {30,25},
									 {30,20},									 
									 {35,30},
									 {35,25},
									 {40,30},
									 {40,25},
									 {37,23},
									 {35,20},
									 {40,55},									 
									 {40,50},
									 {45,50},
									 {45,60},
									 {55,65},
									 {55,60},
									 {50,55},
									 {60,65}};
	public static Set<IPattern> getTestPatternSet(){
		Set<IPattern> patterns = new LinkedHashSet<IPattern>();		
		
		for(int i=0; i < features.length; i++){
			PatternImpl pattern = new PatternImpl();		
			pattern.setPattern(features[i]);
			patterns.add(pattern);
			
		}
		

		return patterns;
	}
	
	public static List<ICluster> getInitialClusterList(){
		List<ICluster> clusters = new ArrayList<ICluster>();
		
		IPattern pattern1 = new PatternImpl();
		pattern1.setPattern(new double[]{30,25});

		IPattern pattern2 = new PatternImpl();
		pattern2.setPattern(new double[]{60,65});

		IPattern pattern3 = new PatternImpl();
		pattern3.setPattern(new double[]{40,30});
				
		ClusterImpl cluster1 = new ClusterImpl(1);
		cluster1.addPattern(pattern1);
		cluster1.updateCentroid();
		
		ClusterImpl cluster2 = new ClusterImpl(1);
		cluster2.addPattern(pattern2);
		cluster2.updateCentroid();
		
		ClusterImpl cluster3 = new ClusterImpl(1);
		cluster3.addPattern(pattern3);
		cluster3.updateCentroid();
		
		clusters.add(cluster1);
		clusters.add(cluster2);
		clusters.add(cluster3);
		
		return clusters;
	}
}
