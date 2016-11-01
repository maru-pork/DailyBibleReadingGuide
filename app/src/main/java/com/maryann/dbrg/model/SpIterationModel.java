package com.maryann.dbrg.model;

/**
 * Created by Rufo on 10/24/2016.
 */
public class SpIterationModel {

    private int iteration;
    private int currentIteration;

    public SpIterationModel(int iteration, int currentIteration) {
        this.iteration = iteration;
        this.currentIteration = currentIteration;
    }

    public int getIteration() {
        return iteration;
    }

    @Override
    public String toString() {
        if (currentIteration == iteration)
            return iteration + " (current)";
        return String.valueOf(iteration);
    }
}
