/**
 * The item class
 * 
 * @author Jeff
 *
 */
public class Item {
	/**
	 * Class ctor.
	 * 
	 * 
	 * @param _name		Name of the item.
	 * @param _size		Size of the item.
	 * @param _value	Value of the item.
	 */
	public Item(
			String _name,
			int _size,
			int _value
	) {
		name = _name;
		size = _size;
		value = _value;
	}
	
	
	// Data members
	private String name;
	private int size;
	private int value;
	
	// Accessors.
	public String GetName() {
		return name;
	}
	
	public int GetSize() {
		return size;
	}
	
	public int GetValue() {
		return value;
	}
	
	
	/**
	 * Function to print the item as a string.
	 */
	public String toString() {
		//return ("[" + name + ", " + size.toString() + ", " + value.toString());
		return ("[" + name + ", " + size + ", " + value + "]");
	}
}
