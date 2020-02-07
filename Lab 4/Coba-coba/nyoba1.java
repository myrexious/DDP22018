public class nyoba1 {
    public static void main(String[] args){
        System.out.println(hash("RANDOM TASTE CANDY", 0, 0));    
        String a = "kambing bandot";
        System.out.println(a.toUpperCase());
    }
/*
    private static int hash(String itemName, int currentHash, int currentIndex) {
        if(currentIndex<=itemName.length()-1){
            if(itemName.charAt(currentIndex)==' '){
                return hash(itemName, currentHash, ++currentIndex);
            }
            currentHash += (currentIndex+1)*(((int)itemName.charAt(currentIndex))-64);
            return hash(itemName, currentHash, ++currentIndex);
        } else {
            return currentHash;
        }        
    }
*/
    private static int hash(String itemName, int currentHash, int currentIndex) {
        if(currentIndex>itemName.length()-1){
            return currentHash;
        } else if(itemName.charAt(currentIndex)==' '){
            int temp_ascii = (int) itemName.charAt(currentIndex);
            temp_ascii -= 64;
            currentHash += (currentIndex+1)*temp_ascii;
            return hash(itemName, currentHash, ++currentIndex);
        } else {
            return hash(itemName, currentHash, ++currentIndex);
        }
        }
    }