/**
 * Class Candy Store.
 * 
 * This class represents the Candy Store.
 * NOTE : Your only concerns are the methods listed with TODOS. 
 * Feel free to change them (including the parameters and returns). If you did, you might need to change the
 * drivers as well. You can always add new methods to help you complete this task. 
 * DO NOT make any changes to the main method and the Item class.
 */
public class CandyStore {
    /**
     * Main function of the program.
     * 
     * @param args - unused.
     * @return void.
     */
    public static void main(String[] args) {

        // This array is sorted by the code values, Binary Search is applicable for this case.

        final Item[] arrayOfItems = {
            new Item("Gumball", 2.00),
            new Item("Candy Cane", 25.50),
            new Item("Peanuts", 0.50),
            new Item("Poprocks", 3.45),
            new Item("Lollipop", 1.80),
            new Item("Chocolate Bar", 50.00),
            new Item("Gumstrips", 1.25),
            new Item("Marshmallow", 12.75),
            new Item("Salty Popcorns", 5.00),
            new Item("Random Taste Candy", 7.15),
        };

        final int[] arrayOfItemCodes = {
            703, 
            1669, 
            877, 
            500, 
            703,
            488,
            123
        };

        for (int i = 0; i < arrayOfItemCodes.length; i++) {
            Item foundItem = binarySearch(arrayOfItems, arrayOfItemCodes[i]);
            if (foundItem == null) {
                System.out.println("No item found");
            } else {
                System.out.format("Found item : %s [ %.2f ]\n", foundItem.getName(), foundItem.getPrice());
            }
        }

        // Expected output :
        //
        // Found item : Chocolate Bar [ 50.00 ]
        // Found item : Random Taste Candy [ 7.15 ]
        // Found item : Marshmallow [ 12.75 ]
        // Found item : Lollipop [ 1.80 ]
        // Found item : Chocolate Bar [ 50.00 ]
        // Found item : Poprocks [ 3.45 ]
        // No item found
    }

    /**
     * Driver function for the recursive binary search.
     * 
     * @param array - [Item[]] array of Items.
     * @param searchCode - [int] the searched code for the searched item.
     * @return [Item] item whose hash corresponds to searchedCode (can be null if none found).
     */
    private static Item binarySearch(Item[] array, int searchedCode) {
        return binarySearch(array, searchedCode, 0, array.length - 1);
    }

    /**
     * Binary search function using codes to search an item.
     * 
     * TODO : Implement this method using recursion.
     * Hint :
     * 
     * Refer to the Binary Search Algorithm provided in the tutorial and assistants explanations.
     * 
     * @param array - [Item[]] array of Items.
     * @param searchCode - [int] the searched code for the searched item.
     * @param start - [int] starting index which the search starts at.
     * @param end = [int] ending index which the search ends at.
     * @return [Item] item whose hash corresponds to searchedCode (can be null if none found).
     */
    private static Item binarySearch(Item[] array, int searchedCode, int start, int end) {
        if(end>=start){
            //If found
            if(searchedCode == hash(array[(start+end)/2].getName())) {
                return array[(start+end)/2];
            } else if( searchedCode < hash(array[(start+end)/2].getName()) ) {      //If smaller than array
                return binarySearch(array, searchedCode, 0, ((start+end)/2)-1);
            } else if( searchedCode > hash(array[(start+end)/2].getName()) ) {      //if bigger than array
                return binarySearch(array, searchedCode, ((start+end)/2)+1, end);
            }
        }
        return null;
    }

    /**
     * Driver function for the recursive hash function.
     * 
     * @param itemName - [String] name of the item.
     * @return [int] hash of the name (itemName).
     */
    private static int hash(String itemName) {
        return hash(itemName.toUpperCase(), 0, 0);
    }

    /**
     * Simple name based hashing function for Items using sum of [char]*[index]
     * A = 1, B = 2, ...
     * 
     * TODO : Implement this method using recursion.
     * Hint : 
     * You can use the currentHash and currentIndex to keep track of your previous calculations.
     * Do for the rest of the string until you reach the end.
     * 
     * @param itemName - [String] name of the item.
     * @param currentHash - [int] current calculated hash for the string[0:currentIndex].
     * @param currentIndex - [int] current index of to-be-calculated character in the string. 
     * @return [int] hash of the name[0:currentIndex] (itemName).
     */

    private static int hash(String itemName, int currentHash, int currentIndex) {
        if(currentIndex<=itemName.length()-1){                                              //if index is within length
            if(itemName.charAt(currentIndex)==' '){
                return hash(itemName, currentHash, ++currentIndex);                         //only add the index if space
            }
            currentHash += (currentIndex+1)*(((int)itemName.charAt(currentIndex))-64);      //if not space add according to the hash
            return hash(itemName, currentHash, ++currentIndex);
        } else {
            return currentHash;                                                             //base case
        }            
    }
}

/**
 * Class Item.
 * 
 * This class represents the Item stored in the Candy Store.
 */
class Item {
    private String name;
    private double price;

    /**
     * Constructor of Item.
     * 
     * @param name - [String] item name.
     * @param price - [double] item price.
     */
    public Item(String name, double price) {
        this.name = name;
        this.price = price;
    }

    /**
     * Accessor for Item name.
     * 
     * @return [String] item name.
     */
    public String getName() {
        return this.name;
    }

    /**
     * Accessor for Item price.
     * 
     * @return [double] item price.
     */
    public double getPrice() {
        return this.price;
    }
}