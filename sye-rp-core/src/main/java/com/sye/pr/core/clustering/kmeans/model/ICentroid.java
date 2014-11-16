package com.sye.pr.core.clustering.kmeans.model;

import java.util.List;
import java.util.Set;

import com.sye.pr.core.model.IPattern;


public interface ICentroid extends Cloneable {

	public double[] getMean();
	public void updateMean(Set<IPattern> patterns);	
}
