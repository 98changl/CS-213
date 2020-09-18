/**
 * The container class that defines the abstract data type
 * @author Liman Chang, Kenneth Christian
 */

public class ShoppingBag {
    
    	private GroceryItem[] bag ;	// array-based implementation of the bag
	private int size;			// number of items currently in the bag
	
	
        public  ShoppingBag() {
	
        bag = new GroceryItem[5];//initial size of array = 5
        size = bag.length;
            
        }
	
	/**
	 * helper method to find an item
	 * 
	 * @param grocery item to be removed
	 * @return index of grocery item, -1 if item doesn't exist
	 */
	
          private int find(GroceryItem item) {
        
            int return_value = 0;
              
            for(int x = 0 ; x == bag.length ; x++){
                
                if(bag[x] == item){
                  
                    return_value = x ;
                }
                else
                    return_value = -1;
                
               }
            
         return return_value;
        }
            
	/**
	 * helper method to grow the capacity
	 */
	 
        private void grow(){
           
            boolean empty = false; //assume array is full
            
            /*
            This while loop checks to see if all the index of array are full
            */
            while(empty == false){
               
                for(int x = 0 ; x < bag.length; x++){
                
                    if(bag[x] == null){
                    
                        empty = true; //array is partiallty empty
                 }
                    else{
                        /*
                        All the index are filled.
                        This creates a new array (newBag) that has size 5 greater than bag (initial array), 
                        copies the content of bag into it and assigns that array to bag (the original array)
                        */
                        
                      GroceryItem[] newBag = new GroceryItem[bag.length + 5];                       
                      System.arraycopy(bag, 0, newBag, 0, bag.length);                              

                           bag = newBag;
                           size = bag.length;
                    }
                }
            }
            
        }
		
	
        /* 
        this method adds item to the array bag.
        if the array is full then will call
        helper grow method to crease the size by 5 
        and then add the item to the next empty index.
        Assume if the array is partially empty then it will be the last index that is empty.
        */
	
	public void add(GroceryItem item) {
           
            for(int x = 0 ; x<bag.length; x++){
               
                if(bag[x] == null){
                    
                    bag[x] = item;
               
                    break; //break out of for loop once the next empty index has been filled
                    
                }
            }
            
            //if the array is full, increase and copy the old array then add to the next empty index
            for(int t = 0 ; t<bag.length; t++){
            
                   if(bag[t] != null && bag[bag.length-1] != null)){//checks both in and the last index to see if all index are full
                     
                       grow(); //calls the helper grow method to copy the array and grow and add the item to the next empty index 
                       
                       bag[t+1] = item;
                       
                       break; //break out of for loop
                         }
                    }
                }
                
        /*
        This method removes item from the bag
        by calling the helper method find.
        Method also shifts each element in array towards the left if item is removed.
        */
	public boolean remove(GroceryItem item) {
          
            int find = find(item);//is the item in the bag?
          
            boolean return_value = false; 
            
            if(find != -1){
                        bag[find] = null;
                        return_value = true;
                        
                    
                }
            
        //if the item is found and removed then 
        //shift everything in array to "left" to ensure empty indexes at the right/end of array
        for (int j=0; j<bag.length; j++){
            if (bag[j]==null){
                for (int k=j+1; k<bag.length; k++){
                    bag[k-1] = bag[k];
                }
                bag[bag.length-1] = null;
                break;
            }
        }
            
            
           	return return_value; //
        }
	
        
	public double salesPrice() {
		
            return 0.0;
	}
	
	public double salesTax() {
		
            return 0.0;
	}
	
	public void print() {
		System.out.println(size + " items in bag");
		
		for (int i = 0; i < size; i++) {
			String prt;
			prt = bag[i].toString();
			System.out.println(prt);
		}
		
	}
	
	
        
        public static void main(String[] args) {
		// TODO Auto-generated method stub

              
    
                
	}
    
    
    
}
