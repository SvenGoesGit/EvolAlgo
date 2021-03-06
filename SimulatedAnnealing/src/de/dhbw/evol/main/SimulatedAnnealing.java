package de.dhbw.evol.main;

import de.dhbw.evol.main.util.Evolution;
import de.dhbw.evol.main.util.Fitness;
import de.dhbw.evol.main.util.VectorND;

public class SimulatedAnnealing {
	private static final double a = 20;
	private static final double b = 0.2;
	private static final double c = 2 * Math.PI;
	private static final int d = 6;

	public SimulatedAnnealing() {
	}

	public static void main(String[] args) {
		Fitness myFitness = new Fitness(a, b, c, d);

		VectorND parameterVector = Evolution.getInstance().generateRandomVector(d);
		double temperature = 1;
		double coolingRate = 0.003;
		double temperatureWeight = 0.000001;
		double intervallBorderWeight = 0.001;
		double tempInterrupt = 10E-4;
		int operationBorder = 200;
		
		int iterations = 10000;

		double fitnessValueOld = myFitness.getFitness(parameterVector);

		while (temperature > tempInterrupt) {
			int noOperationHappened = 0;

//			while (noOperationHappened < operationBorder) {
			for(int i = 0; i < iterations; i++) {
				parameterVector = Evolution.getInstance().updateNElementsOfVectorWithStep(1, parameterVector, temperature * intervallBorderWeight);

				double fitnessValueNew = myFitness.getFitness(parameterVector);

				double differenceFitness = fitnessValueNew - fitnessValueOld;

				if (differenceFitness < 0) {
					fitnessValueOld = fitnessValueNew;
				} else {
					double randomNumber = Evolution.getInstance().getRandomNumberInInterval(0, 1);

					double controlValue = Math.exp(-differenceFitness / temperatureWeight * temperature);

					if (randomNumber < controlValue) {
						fitnessValueOld = fitnessValueNew;
						noOperationHappened = 0;
					} else {
						noOperationHappened++;
					}
				}
			}

			temperature *= 1 - coolingRate;
		}

		System.out.println("Fitness: " + fitnessValueOld);
		
//		//Debug output
//		System.out.println(parameterVector.toString());
//		
//		//Null output
//		VectorND nullVector = new VectorND(d);
//		System.out.println(myFitness.getFitness(nullVector));
//		System.out.println(nullVector.toString());
	}

}
