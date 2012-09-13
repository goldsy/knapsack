import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.io.*;


/**
 * Entry class for the knapsack problem.
 * 
 * @author Jeff
 *
 */
public class Knapsack {
	public static Item[] items = null;
	public static PackedItem[] sackInventory = null;
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// Initialize the items.
		items = new Item[3];
		
		// Remember to remove same size <= value items and larger size <= value items later on.
		items[0] = new Item("Pearl", 3, 4);
		items[1] = new Item("Ring", 4, 5);
		items[2] = new Item("Watch", 7, 10);
		
		
		// Open up a standard input.
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String userInput = "";
		
		boolean exitFlag = false;
		
		while (!exitFlag) {
			// Prompt the user to enter the number of bits to
			// get the possible combinations for.
			System.out.print("Enter size of sack: ");
			
			// Read the input from the command line.  Need to use the try/catch
			/// with the readLine() method.
			try {
				userInput = br.readLine();
			} catch (IOException ioe) {
				System.out.println("IO error trying to read your input!");
				System.exit(1);
			}
			
			System.out.println("You entered [" + userInput + "].");
			
			if (userInput.equals("quit") || userInput == null) {
				System.out.println("Goodbye.");
				exitFlag = true;
			}
			else {
				// Check if the input is integer.
                Pattern p = Pattern.compile("[0-9]");
                Matcher m = p.matcher(userInput);
                
                if (m.matches()) {
                	int maxCapacity = Integer.parseInt(userInput);
                	
                	sackInventory = new PackedItem[maxCapacity + 1];
                	
                	// Init the array references.
                	for (int i = 0; i <= maxCapacity; ++i) {
                		//System.out.println("Initializing sack inventory index [" + i + "]");
                		sackInventory[i] = null;
                	}
                    
                	// TODO: Precompute which capacities must be calculated?????
                	for (int i = 0; i <= maxCapacity; ++i) {
                		System.out.println("Creating sack inventory for capacity [" + i + "]");
                		sackInventory[i] = new PackedItem(i);
                	}
                    
                    System.out.println("Printing inventory for max capacity...");
                	sackInventory[maxCapacity].toString();
                }
                else {
                	System.out.println("Your input must be an integer or enter 'quit'.");
                }
				
			}
		}
	}

}
