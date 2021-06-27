package com.solution.kirichenko.task3;

import java.util.ArrayList;
import java.util.List;

/**
 * The {@code Checkpoint} class
 * This class determine checkpoint parent and childs
 *
 * @author Juliia Kirichenko
 * @since 26.06.2021
 * @version 1.0
 */
public class Checkpoint {

    private Checkpoint parent; //parent of checkpoint
    private List<Checkpoint> childs; //child of checkpoint

    private Town town; //all information about town
    private Good good; //all information about good

    /**
     * Constructor for class Checkpoint
     */
    public Checkpoint() {
    }

    /**
     * Constructor for class Checkpoint with parameters
     * @param parent - parent of checkpoint
     * @param town - all information about town
     * @param good - all information about good
     * @param nexts - list of towns
     */
    public Checkpoint(Checkpoint parent, Town town, Good good, List<Town> nexts) {
        this.town = town;
        this.good = good;
        this.parent = parent;
        childs = new ArrayList<>();
        for (Town next : nexts) {
            List<Town> remainTowns = new ArrayList<>(nexts);
            remainTowns.remove(next);
            List<Good> remainGoods = new ArrayList<>(next.getPricelist());
            remainGoods.remove(good);
            if (!remainTowns.isEmpty())
                for (Good nxtGood : remainGoods)
                    childs.add(new Checkpoint(this, next, nxtGood, remainTowns));
            else
                childs.add(new Checkpoint(this, next, null, remainTowns));
        }
    }

    /**
     * This method check checkpoint if it last
     * @return true(if checkpoint is last) or false
     */
    public boolean isLast() {
        return childs == null || childs.isEmpty();
    }

    /**
     * Getter
     * @return get parent of checkpoint
     */
    public Checkpoint getParent() {
        return parent;
    }

    /**
     * Getter
     * @return get child of checkpoint
     */
    public List<Checkpoint> getChilds() {
        return childs;
    }

    /**
     * This method build routes of trader
     * @param routes - routes of trader
     */
    public void buildRoutes(List<Route> routes) {
        if (isLast()) {
            Checkpoint chp = this;
            Route route = new Route(new ArrayList<>());
            while (chp != null) {
                route.add(chp);
                chp = chp.getParent();
            }
            routes.add(route);
        } else
            for (Checkpoint child : childs)
                child.buildRoutes(routes);
    }

    /**
     * Getter
     * @return get town
     */
    public Town getTown() {
        return town;
    }

    /**
     * Getter
     * @return get good
     */
    public Good getGood() {
        return good;
    }

    /**
     * Returns a string representation of the object
     * @return checkpoint
     */
    @Override
    public String toString() {

        String output = "";

        if (isLast()) {
            Checkpoint chp = this;
            while (chp != null) {
                output = chp.town + ":" + chp.good + (chp.isLast() ? "" : "->") + output;
                chp = chp.getParent();
            }
            output += "\n";

        } else
            for (Checkpoint child : childs)
                output += child;

        return output;
    }
}
