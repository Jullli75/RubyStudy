package com.solution.kirichenko.task3;

import java.util.List;

/**
 * The {@code Route} class
 * This class determine route trader
 *
 * @author Juliia Kirichenko
 * @since 26.06.2021
 * @version 1.0
 */
public class Route {

    private List<Checkpoint> checkpoints; //list of checkpoints

    /**
     * Constructor for class Route
     */
    public Route() {
    }

    /**
     * Constructor for class Route with parameters
     * @param checkpoints - list of checkpoints
     */
    public Route(List<Checkpoint> checkpoints) {
        this.checkpoints = checkpoints;
    }

    /**
     * This method add checkpoint
     * @param checkpoint - current checkpoint
     */
    public void add(Checkpoint checkpoint) {
        checkpoints.add(0, checkpoint);
    }

    /**
     * Getter
     * @return list of checkpoints
     */
    public List<Checkpoint> getCheckpoints() {
        return checkpoints;
    }

    /**
     * Returns a string representation of the object
     * @return town + good
     */
    @Override
    public String toString() {
        String output = "";
        for (Checkpoint checkpoint : checkpoints)
            output += checkpoint.getTown() + ":" + checkpoint.getGood() + (checkpoint.isLast() ? "" : "->");
        return output;
    }
}
