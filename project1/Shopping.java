/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RunProject1;
import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader;
import java.lang.*;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.*;

 public class ShoppingBag {
    
    	private GroceryItem[] bag  ;	// array-based implementation of the bag
	private int size;			// number of items currently in the bag
	
     
	//private static ShoppingBag instance = new ShoppingBag();
        
        
        
        public ShoppingBag() {
	
        bag = new GroceryItem[5];//initial size of array = 5
        size = 0;
          
        }
	
     
     
	       
	/**
	 * helper method to grow the capacity
	 */
	 
        private void grow(){
         /*
                        All the index are filled.
                        This creates a new array (newBag) that has size 5 greater than bag (initial array), 
                        copies the content of bag into it and assigns that array to bag (the original array)
                        */
                        
                      GroceryItem[] newBag = new GroceryItem[bag.length + 5];                       
                      System.arraycopy(bag, 0, newBag, 0,bag.length);                              

                           bag = newBag;
                           size = bag.length;
                    }
                
            

        
		
	
        /* 
        this method adds item to the array bag.
        if the array is full then will call
        helper grow method to crease the size by 5 
        and then add the item to the next empty index.
        Assume if the array is partially empty then it will be the last index that is empty.
        */
       /* 
        public void passRefrence(GroceryItem item){
            GroceryItem refrence = item;
            System.out.println(refrence + " hi from refrence ");
        }
*/	
	public void add(GroceryItem item) {
           
             GroceryItem refrence = item;
            //System.out.println(refrence + " hi from add ");
            
            for(int x = 0 ; x<bag.length; x++){
               
                if(bag[x] == null){
                    
                    bag[x] = item;
                    
                   //  System.out.println(item.getname() + " added to the bag ");
               
                    break; //break out of for loop once the next empty index has been filled
                    
                }
            }
       
            //if the array is full, increase and copy the old array then add to the next empty index
            for(int t = 0 ; t<bag.length; t++){
            
                   if(bag[t] != null && bag[bag.length-1] != null){
                     
                       grow(); //calls the helper grow method to copy the array and grow and add the item to the next empty index 
                       System.out.println(bag.length);
                       bag[t] = item;
                       
                      // System.out.println(item.getname() + " added to the bag ");
                       
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
          
            
             
           
             int find = find(item);//is the item in the bag? if so return the index
           
            
             
            boolean return_value = false; 
            
            if(find != -1 ){
                       
                        bag[find] = null;
                       
                        return_value = true; //item found and removed
                        System.out.println(item.getname() + item.getPrice() + " removed from the bag ");
                    
                }
            else if( find == -1){
                System.out.println("Unable to remove, this item is not in the bag");
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
	
            double price = 0;
            
            for(int x = 0 ; x < bag.length ; x++){
                if(bag[x] != null  ){
                price += bag[x].getPrice();
                }
            }      
            return price;
	
        }
	
	public double salesTax() {
		  double taxprice = 0;
         
                  for(int t = 0 ; t < bag.length ; t++){
                      if(bag[t] != null && bag[t].getTax() == true){
                          taxprice += bag[t].getPrice() * 0.06625;
 
                      }
                          
                  }
                      
                      
            return taxprice;

	}
	
	public void print() {
             size = 0;
             int numI = 0;
             
             //to print "title statment"
             for(int e = 0 ; e<bag.length; e++){
                if(bag[e] != null){
                    numI++;
                  }
            } 
            System.out.println("**you have " + numI + " items in bag:"); ///title statment
            
             
             
             
             
             //to print all the items
            for(int e = 0 ; e<bag.length; e++){
                if(bag[e] != null){
                    size++;
                    System.out.println(bag[e].toString());
                   
                }
            } 
            System.out.println("**End of list");
            
          
           
        }

        public void checkOut(){
            
            //format to print tax
            NumberFormat formatter = new DecimalFormat("#0.00"); 
            
            //to get how may item are in bag
             size = 0;
             int numI = 0;
             
            
             for(int e = 0 ; e<bag.length; e++){
                if(bag[e] != null){
                    numI++;
                  }
            }
             
             System.out.println("Checking out " + numI + " items. ");
            
             //print each item in the bag
              for(int e = 0 ; e<bag.length; e++){
                if(bag[e] != null){
                    size++;
                    System.out.println(bag[e].toString());
                   
                }
             
             
             
        }
              //print the total price w/out tax
              System.out.println("*Sales Total: " + salesPrice() );
              
              //print out price of total taxes
              System.out.println("*Sales Tax: " + formatter.format(salesTax()));
        }
           
	/**
	 * helper method to find an item
	 * 
	 * @param grocery item to be removed
	 * @return index of grocery item, -1 if item doesn't exist
	 */
        
        private int find(GroceryItem item){
           
            int re = -1;
        
            for(int x = 0 ; x<bag.length ; x++){
               
                if(item.equals(bag[x]) && bag[x] != null ){
                   
                    re = x; //x means item found at a particular index
                  
                    break;
        }
                else if(bag[x] == null || !item.equals(bag[x])){
                    
                    re = -1; //0 means item not found
                    
                
                }
                
                   
            }
            
            
        
             return re;
            
        }
        //testbed main as a driver to excersice this class
  
        
        public static void main(String[] args) {
           
            
            
            
            
            
            
            
            
            
            
            
            
        }
    
    
    
    
}
