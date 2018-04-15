/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TimeTableGA;

import java.util.Comparator;

/**
 *
 * @author Jay
 */
public class IndividualComparator implements Comparator<Individual> {

    @Override
    public int compare(Individual o1, Individual o2) {

        if (o1.getFitness() > o2.getFitness()) {
            return -1;
        } else if (o1.getFitness() < o2.getFitness()) {
            return 1;
        }
        return 0;

    }

}
