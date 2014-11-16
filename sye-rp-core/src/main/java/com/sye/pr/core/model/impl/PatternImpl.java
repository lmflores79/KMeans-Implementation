package com.sye.pr.core.model.impl;

import com.sye.pr.core.model.IPattern;
import com.sye.pr.core.model.IPoint;

public class PatternImpl implements IPattern {

	private double[] pattern;
	
	@Override
	public double[] getPattern() {
		// TODO Auto-generated method stub
		return pattern;
	}

	@Override
	public void setPattern(double[] pattern) {
		// TODO Auto-generated method stub
		this.pattern = pattern;

	}

	@Override
	public double[] getCoordinates() {
		// TODO Auto-generated method stub
		return pattern;
	}

	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		if(obj instanceof PatternImpl){
		
			PatternImpl comparedPattern = (PatternImpl)obj;
			if(comparedPattern.pattern.length != this.pattern.length){
				return false;
			}
			
			for(int i=0; i<this.pattern.length; i++){
				if(this.pattern[i] != comparedPattern.pattern[i]){
					return false;
				}
			}
			return true;
		}
		return false;
		
	}

	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		int hashCode = 0;
		for(double feature: this.pattern){
			hashCode += feature;
		}
		return hashCode;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
	
		StringBuilder sb = new StringBuilder("(");
		for(double feature: this.pattern){
			sb.append(feature +  ",");
		}
		sb.append(")");

		return sb.toString();
	}
	
	
}
