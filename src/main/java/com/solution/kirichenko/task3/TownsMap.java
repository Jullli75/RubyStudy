package com.solution.kirichenko.task3;

import java.util.ArrayList;
import java.util.List;

/**
 * The {@code TownsMap} class
 * This class determine name of town and price list goods
 *
 * @author Juliia Kirichenko
 * @since 25.06.2021
 * @version 1.0
 */
public class TownsMap {

    private List<Checkpoint> checkpoints; //list of checkpoints
    private List<Town> towns; //list of towns
    private List<Route> routes; //list of routes

    /**
     * Constructor for class TownsMap
     */
    public TownsMap() {
    }

    /**
     * Constructor for class TownsMap with parameters
     * @param towns - list of towns
     */
    public TownsMap(List<Town> towns) {
        this.towns = towns;
        checkpoints = new ArrayList<>();
        routes = new ArrayList<>();
    }

    /**
     * The method used for building towns with goods and prices
     */
    public void build() {
        for (Town town : towns) {
            for (Good good : town.getPricelist()) {
                List<Town> remain = new ArrayList<>(towns);
                remain.remove(town);
                checkpoints.add(new Checkpoint(null, town, good, remain));
            }
        }
        for (Checkpoint checkpoint : checkpoints)
            checkpoint.buildRoutes(routes);
    }

    /**
     * Getter
     * @return list of towns
     */
    public List<Town> getTowns() {
        return towns;
    }

    /**
     * Getter
     * @return list of routes
     */
    public List<Route> getRoutes() {
        return routes;
    }

    /**
     * Returns a string representation of the object
     * @return checkpoint
     */
    @Override
    public String toString() {
        String output = "";
        for (Checkpoint checkpoint : checkpoints) {
            output += checkpoint;
        }
        return output;
    }
}