package edu.psu.cmpsc221.model;

public class FiniteInventorySystem extends InventorySystem {

    //constructor that takes in limit of items
    FiniteInventorySystem(int limit){
        this.limit=limit;
    }
    protected boolean canAddItem(Item item) {
        if(count+1 <= limit){
            count++;
            return true;
        }
        return false;
    } /* end canAddItem */

    protected String getInventoryFullMessage() {
        return "Yo Pocket too small";
    } /* end getInventoryFullMessage */

    private int limit;
    private int count = 1;
}
