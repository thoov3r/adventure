package edu.psu.cmpsc221.model;

public class LimitedBulkinessInventorySystem extends InventorySystem {

    //constructor that takes in limit of items
    LimitedBulkinessInventorySystem(int limit){
        this.limit=limit;
    }
    protected boolean canAddItem(Item item) {
        if(count <= limit){
            count=count+item.getBulkiness();
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