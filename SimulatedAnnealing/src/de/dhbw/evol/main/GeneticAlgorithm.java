package de.dhbw.evol.main;

import de.dhbw.evol.main.util.Fitness;

public class GeneticAlgorithm {
	private static final double a = 20;
	private static final double b = 0.2;
	private static final double c = 2 * Math.PI;
	private static final int d = 6;

	public GeneticAlgorithm() {
	}

	public static void main(String[] args) {
		Fitness myFitness = new Fitness(a, b, c, d);
	}
}