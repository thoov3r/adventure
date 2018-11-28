package edu.psu.cmpsc221.model;

public class LimitedWeightInventorySystem extends InventorySystem{

    //constructor that takes in limit of items

    LimitedWeightInventorySystem(int limit){
        this.limit=limit;
    }
    protected boolean canAddItem(Item item) {
        if(count <= limit){
            count=count+item.getWeight();
            return true;
        }
        return false;
    } /* end canAddItem */

    protected String getInventoryFullMessage() {
        return "Yo Pocket too small";
    } /* end getInventoryFullMessage */

    private int limit;
    private int count = 0;
}