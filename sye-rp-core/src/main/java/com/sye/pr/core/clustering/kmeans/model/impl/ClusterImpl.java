package com.sye.pr.core.clustering.kmeans.model.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.sye.pr.core.clustering.kmeans.impl.KMeansClusteringMethodImpl;
import com.sye.pr.core.clustering.kmeans.model.ICentroid;
import com.sye.pr.core.clustering.kmeans.model.ICluster;
import com.sye.pr.core.model.IPattern;

public class ClusterImpl implements ICluster{

	private Set<IPattern> patterns = new HashSet<IPattern>();
	private ICentroid centroid = new CentroidImpl();
	private String id;
	
	private static final Logger logger = LogManager.getLogger(ClusterImpl.class);
	
	public ClusterImpl(int id){
		this.id = String.valueOf(id);
		logger.info("Creating cluster with " + id);
	}
	
	public void updateCentroid(){
		centroid.updateMean(patterns);
	}
	@Override
	public void addPattern(IPattern pattern) {
		// TODO Auto-generated method stub
		logger.info("Cluster " + id + ". Adding pattern to the cluster: " + pattern);
		patterns.add(pattern);		
	}

	@Override
	public void removePattern(IPattern pattern) {
		// TODO Auto-generated method stub
		logger.info("Cluster " + id + ". Removing pattern from the cluster: " + pattern);
		patterns.remove(pattern);
	}

	public void removeAllPatterns() {
		// TODO Auto-generated method stub
		logger.info("Cluster " + id + ". Removing all patterns from cluster. ");
		patterns.clear();		
	}

	@Override
	public void setPatterns(Set<IPattern> patterns) {
		// TODO Auto-generated method stub
		this.patterns = patterns;		
	}

	@Override
	public ICentroid getCentroid() {
		// TODO Auto-generated method stub
		return centroid;
	}
	
	@Override
	public boolean containsPattern(IPattern pattern) {
		// TODO Auto-generated method stub
		return patterns.contains(pattern);
	}
	
	@Override
	public String getId() {
		// TODO Auto-generated method stub
		return this.id;
	}

	@Override
	public Set<IPattern> getPatterns() {
		// TODO Auto-generated method stub
		return patterns;
	}	

}
