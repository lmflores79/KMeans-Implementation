package com.sye.pr.core.utils.distance.impl;

import java.util.Arrays;

import org.apache.commons.math3.ml.distance.EuclideanDistance;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;



import com.sye.pr.core.model.IPoint;
import com.sye.pr.core.utils.distance.IDistanceCalculator;

public class EuclideanDistanceCalculatorImpl implements IDistanceCalculator {

	private EuclideanDistance ed = new EuclideanDistance();
	
	private static final Logger logger = LogManager.getLogger(EuclideanDistanceCalculatorImpl.class);
	
	@Override
	public double calculateDistance(IPoint pointA, IPoint pointB) {
		// TODO Auto-generated method stub
		return calculateDistance(pointA.getCoordinates(), pointB.getCoordinates());		
	}
	@Override
	public double calculateDistance(IPoint pointA, double[] pointB) {
		// TODO Auto-generated method stub
		return calculateDistance(pointA.getCoordinates(), pointB);
	}
	@Override
	public double calculateDistance(double[] pointA, double[] pointB) {
		// TODO Auto-generated method stub
		logger.info("Calculating euclidean distance between " + Arrays.toString(pointA) + " and " + Arrays.toString(pointB));
		return ed.compute(pointA, pointB);
	}

}
