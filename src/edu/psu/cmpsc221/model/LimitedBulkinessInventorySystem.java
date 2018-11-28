package edu.psu.cmpsc221.model;

import edu.psu.cmpsc221.exceptions.ItemNotInInventoryException;

public class LimitedBulkinessInventorySystem extends InventorySystem {

    //constructor that takes in limit of items
    LimitedBulkinessInventorySystem(int limit){
        this.limit=limit;
    }
    protected boolean canAddItem(Item item) {
        if(count+item.getBulkiness() <= limit){
            count=count+item.getBulkiness();
            return true;
        }
        return false;
    } /* end canAddItem */


    Item removeItemNamed(String itemName) throws ItemNotInInventoryException {
        // Can use lambdas, but we'll do it manually
        for (Item item : list) {
            if (item.getName().equals(itemName)) {
                count = count-item.getBulkiness();
                list.remove(item);
                return item;
            } /* end if */
        } /* end for */

        throw new ItemNotInInventoryException(itemName);
    } /* end removeItemNamed */

    protected String getInventoryFullMessage() {
        return "This Item wayyyyy to thick";
    } /* end getInventoryFullMessage */

    private int limit;
    private int count = 0;
}