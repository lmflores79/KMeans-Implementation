package com.sye.pr.core.clustering.kmeans.model.impl;

import java.util.List;

import com.sye.pr.core.clustering.kmeans.model.ICluster;
import com.sye.pr.core.clustering.kmeans.model.IKMeansModel;

public class KMeansModelImpl implements IKMeansModel {

	private List<ICluster> clusters;
	
	@Override
	public List<ICluster> getClusters() {
		// TODO Auto-generated method stub
		return clusters;
	}

	public void setClusters(List<ICluster> clusters) {
		this.clusters = clusters;
	}
	
}
