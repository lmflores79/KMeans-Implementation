package com.sye.pr.core.clustering.kmeans.model;

import java.util.List;
import java.util.Set;

import com.sye.pr.core.model.IPattern;

public interface ICluster extends Cloneable{

	public boolean containsPattern(IPattern pattern);
	public void addPattern(IPattern pattern);
	public void removePattern(IPattern pattern);
	public void setPatterns(Set<IPattern> patterns);
	public Set<IPattern> getPatterns();
	public ICentroid getCentroid();
	public String getId();	
	
}
