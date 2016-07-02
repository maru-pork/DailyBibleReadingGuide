package com.maryann.dbrg.model;

/**
 * Created by Rufo on 7/2/2016.
 */
public class IterationModel {
    private int iteration;
    private int currentIteration;

    public IterationModel(int iteration, int currentIteration) {
        this.currentIteration = currentIteration;
        this.iteration = iteration;
    }

    public int getIteration() {
        return iteration;
    }

    @Override
    public String toString() {
        if (currentIteration == iteration) {
            return iteration + (" (current)");
        }
        return String.valueOf(iteration);
    }
}
