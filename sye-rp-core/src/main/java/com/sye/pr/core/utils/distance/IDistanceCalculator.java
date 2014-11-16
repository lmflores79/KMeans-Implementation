package com.sye.pr.core.utils.distance;

import com.sye.pr.core.model.IPoint;

public interface IDistanceCalculator {

	public double calculateDistance(IPoint pointA, IPoint pointB);
	public double calculateDistance(IPoint pointA, double[] pointB);
	public double calculateDistance(double[] pointA, double[] pointB);
	
}
