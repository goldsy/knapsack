/**
 * Packed Item class.
 * 
 * @author Jeff
 *
 */
public class PackedItem {
    /**
     * Class ctor.
     */
    public PackedItem(int _sackCapacity) {
    	sackCapacity = _sackCapacity;
    	item = null;
    	prevPackedItem = null;
    	totalValue = 0;
        
    	// At this sack capacity adding what item adds the most value?
    	// Try each possible item.
    	System.out.println("Current capacity is [" + sackCapacity + "]");
    	
        // Get capacity at prev packed item.
    	int prevCapacity = (sackCapacity - Knapsack.items[0].GetSize());
        
    	// DEBUG
    	System.out.println("Prev capacity is [" + prevCapacity + "]");
        
    	// If negative then this item won't fit.
    	if (prevCapacity >= 0) {
    		// Check if previous capacity's optimal packing has been calculated.
    		if (Knapsack.sackInventory[prevCapacity] == null) {
    			Knapsack.sackInventory[prevCapacity] = new PackedItem(prevCapacity);
    		}
            
    		if ((Knapsack.sackInventory[prevCapacity].GetTotalValue() + Knapsack.items[0].GetValue()) > totalValue) {
    			prevPackedItem = Knapsack.sackInventory[prevCapacity];
                totalValue = Knapsack.sackInventory[prevCapacity].GetTotalValue() + Knapsack.items[0].GetValue();
    		}
            
    		// FINISH ME.
    	}
    }
    
    
    // Data members.
    private int sackCapacity;
    private int totalValue;
    private Item item;
    
    // Stores the optimally previously packed item reference.
    private PackedItem prevPackedItem;
    
    
    public int GetTotalValue() {
    	return totalValue;
    }
    
    
    /**
     * Function to print the packing as a string.
     */
    public String toString() {
    	return ("[Total Value: " + totalValue + "  Item List: " + printInventory() + "]");
    }
    
    
    /**
     * Prints the item inventory.
     */
    public String printInventory() {
    	// There will be no previous item if nothing git this time.
    	if (item != null) {
    		if (prevPackedItem == null) {
    			// This is the first item, just print it.
    			return item.toString();
    		}
    		else {
    			return prevPackedItem.printInventory() + ", " + item.toString();
    		}
    	}
    	else {
    		return "";
    	}
    }
}
