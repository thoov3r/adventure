package edu.psu.cmpsc221.model;

import edu.psu.cmpsc221.exceptions.ItemNotInInventoryException;

public class LimitedWeightInventorySystem extends InventorySystem{

    //constructor that takes in limit of items

    LimitedWeightInventorySystem(int limit){
        this.limit=limit;
    }
    protected boolean canAddItem(Item item) {
        if(count+item.getWeight() <= limit){
            count=count+item.getWeight();
            return true;
        }
        return false;
    } /* end canAddItem */

    Item removeItemNamed(String itemName) throws ItemNotInInventoryException {
        // Can use lambdas, but we'll do it manually
        for (Item item : list) {
            if (item.getName().equals(itemName)) {
                count = count - item.getWeight();
                list.remove(item);
                return item;
            } /* end if */
        } /* end for */

        throw new ItemNotInInventoryException(itemName);
    } /* end removeItemNamed */


    protected String getInventoryFullMessage() {
        return "You are holding too much weight";
    } /* end getInventoryFullMessage */

    private int limit;
    private int count = 0;
}