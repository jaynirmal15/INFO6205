/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TimeTableGA;

import java.util.Random;

/**
 *
 * @author Jay
 */
public class GeneticAlgorithm {

    private int populationSize;
    private double mutationRate;
    private double crossoverRate;
    private int elitismCount;
    protected int tournamentSize;

    public GeneticAlgorithm(int populationSize, double mutationRate, double crossoverRate, int elitismCount,
            int tournamentSize) {

        this.populationSize = populationSize;
        this.mutationRate = mutationRate;
        this.crossoverRate = crossoverRate;
        this.elitismCount = elitismCount;
        this.tournamentSize = tournamentSize;
    }

    public Population initPopulation(Schedule timetable) {
        // Initialize population
        Population population = new Population(this.populationSize, timetable);
        return population;
    }
    public double calcFitness(Individual individual, Schedule timetable) {
        Schedule newTimeTable = new Schedule(timetable);
        newTimeTable.createNewClasses(individual);
        int numberOfClashes = newTimeTable.calculateClashes();
        double fitness = 1 / (double) (numberOfClashes + 1);
        individual.setFitness(fitness);
        return fitness;
    }
    public Individual selectParent1(Population population) {
        Population tournament = new Population(this.tournamentSize);
        population.shuffle();
        for (int i = 0; i < this.tournamentSize; i++) {
            Individual tournamentIndividual = population.getIndividual(i);
            tournament.setIndividual(i, tournamentIndividual);
        }
        return tournament.getFittest(1);
    }
    public Individual selectParent2(Population population) {
        Population tournament = new Population(this.tournamentSize);
        population.shuffle();
        for (int i = 0; i < this.tournamentSize; i++) {
            Individual tournamentIndividual = population.getIndividual(i);
            tournament.setIndividual(i, tournamentIndividual);
        }
        return tournament.getFittest(0);
    }
    public Population crossoverPopulation(Population population) {
        Population newPopulation = new Population(population.populationSize());
        Random r = new Random();
        for (int i = 0; i < population.populationSize(); i++) {
            Individual parent1 = selectParent1(population);
            Individual parent2 = selectParent2(population);
            Individual offspring = new Individual(parent1.getChromosomeLength());
            int crossOverPoint = r.nextInt(parent1.getChromosomeLength());
            for (int j = 0; j < parent1.getChromosomeLength(); j++) {
                if (j < crossOverPoint) {
                    offspring.setGene(j, parent1.getGene(j));

                } else {
                    offspring.setGene(j, parent2.getGene(j));
                }
            }
            newPopulation.setIndividual(i, offspring);
        }
        return newPopulation;
    }
    public Population mutatePopulation(Population population, Schedule timetable) {
        Population newPopulation = new Population(this.populationSize);
        for (int i = 0; i < population.populationSize(); i++) {
            Individual individual = population.getFittest(i);
            Individual randomIndividual = new Individual(timetable);
            for (int j = 0; j < individual.getChromosomeLength(); j++) {
                if (i > this.elitismCount) {
                    if (this.mutationRate > Math.random()) {
                        individual.setGene(j, randomIndividual.getGene(j));
                    }
                }
            }
            newPopulation.setIndividual(i, individual);
        }

        return newPopulation;
    }


    public boolean GenerationReachedToMaximumPoint(int generationNumber, int maxCount) {
        if (generationNumber > maxCount) {
            return true;
        }
        return false;
    }

    public boolean isTerminationConditionMet(Population population) {
        if (population.getFittest(0).getFitness() == 1.0) {
            System.out.println(population.getFittest(0));
            return true;
        }
        return false;
    }
    
    
    public void evalPopulation(Population population, Schedule timetable) {
        double populationFitness = 0;
        for (Individual individual : population.getIndividuals()) {
            populationFitness += this.calcFitness(individual, timetable);
        }
        population.setPopulationFitness(populationFitness);
    }
}
