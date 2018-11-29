package edu.psu.cmpsc221.model;

import edu.psu.cmpsc221.exceptions.ItemNotInInventoryException;

public class FiniteInventorySystem extends InventorySystem {

    //constructor that takes in limit of items
    FiniteInventorySystem(int limit){
        this.limit=limit;
    }

    protected boolean canAddItem(Item item) {
        if(count+1 < limit){
            count++;
            return true;
        }
        return false;
    } /* end canAddItem */

    Item removeItemNamed(String itemName) throws ItemNotInInventoryException {
        // Can use lambdas, but we'll do it manually
        for (Item item : list) {
            if (item.getName().equals(itemName)) {
                count--;
                list.remove(item);
                return item;
            } /* end if */
        } /* end for */

        throw new ItemNotInInventoryException(itemName);
    } /* end removeItemNamed */

    protected String getInventoryFullMessage() {

        return "Yo Pocket too small";
    } /* end getInventoryFullMessage */

    private int limit;
    private int count = 0;
}
