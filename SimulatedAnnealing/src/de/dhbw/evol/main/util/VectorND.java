package de.dhbw.evol.main.util;

import java.util.ArrayList;
import java.util.List;

public class VectorND {
	private List<Double> data;
	
	private int dimension = 6;
	
	public VectorND(int dimension) {
		this.dimension = dimension;
		
		data = new ArrayList<>();
		
		for(int i = 0; i < this.dimension; i++) {
			data.add(0.0);
		}
	}
	
	public double getSquareSum() {
		double returnValue = 0.0f;
		
		for(Double element: data) {
			returnValue += element * element;
		}
		
		return returnValue;
	}
	
	public double getCosinusSum(double c) {
		double returnValue = 0.0f;
		
		for(Double element : data) {
			returnValue += Math.cos(c * element);
		}
		
		return returnValue;
	}
	
	public int getDimension() {
		return dimension;
	}
	
	public void setElementToValue(int index, double value) {
		this.data.set(index, value);
	}
	
	public double getElement(int index) {
		return this.data.get(index);
	}
	
	@Override
	public String toString() {
		String stringRepresentation = new String();
		
		for(int i = 0; i < dimension; i++) {
			stringRepresentation = stringRepresentation.concat(data.get(i).toString() + "\n");
		}
		
		return stringRepresentation;
	}
}
