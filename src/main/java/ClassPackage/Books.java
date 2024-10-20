/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ClassPackage;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author yehan
 */


public class Books {        
    
    private String BookID;          
    private String Name;
    private String Category;
    private String Price;
    private String Stock;
    
   FileManagement bookfile = new FileManagement("Books.txt") {};  
   
   

    public Books(String BookID, String Name, String Category, String Price, String Stock) {
        this.BookID = BookID;
        this.Name = Name;
        this.Category = Category;
        this.Price = Price;
        this.Stock = Stock;
    }
    
    public Books(){
   } 

    public String getBookID() {
        return BookID;
    }

    public void setBookID(String BookID) {
        this.BookID = BookID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getCategory() {
        return Category;
    }

    public void setCategory(String Category) {
        this.Category = Category;
    }

    public String getPrice() {
        return Price;
    }

    public void setPrice(String Price) {
        this.Price = Price;
    }

    public String getStock() {
        return Stock;
    }

    public void setStock(String Stock) {
        this.Stock = Stock;
    }
    
    
    public boolean AddBook(){
    
        if (!bookfile.CreateNewFile())
        {
            String record = BookID + " " + Name + " " + Category + " " + Price + " " + Stock + "";
            
            return bookfile.WriteFile(record);
        } else {
        }
        return false;
        
    }
   
    public boolean SearchBookName(String Bookname){
        
          boolean isFound = false;  
            
            try {
            BufferedReader buff = new BufferedReader(bookfile.ReadFile());
            
            String readline;
            
                while ((readline = buff.readLine()) != null){
                    
                    String[] bookdetails = readline.split(" ");
                    if (Bookname.equalsIgnoreCase(bookdetails[1])){
                        
                    isFound = true;
                    
                    this.setBookID(bookdetails[0]);
                    this.setName(bookdetails[1]);
                    this.setCategory(bookdetails[2]);
                    this.setPrice(bookdetails[3]);
                    this.setStock(bookdetails[4]); 
                                                                                                                                                  
                    }
                }                
            } catch (IOException ex) {
                Logger.getLogger(Books.class.getName()).log(Level.SEVERE, null, ex);
            }
        return isFound;   
    }   
     
    
    public boolean SearchBookID (String BookID){
    
         boolean isFound = false;  
            
            try {
            BufferedReader buff = new BufferedReader(bookfile.ReadFile());
            
            String readline;
            
                while ((readline = buff.readLine()) != null){
                    
                    String[] bookdetails = readline.split(" ");
                    if (BookID.equalsIgnoreCase(bookdetails[0])){
                        
                    isFound = true;
                    
                    this.setBookID(bookdetails[0]);
                    this.setName(bookdetails[1]);
                    this.setCategory(bookdetails[2]);
                    this.setPrice(bookdetails[3]);
                    this.setStock(bookdetails[4]); 
                                                                                                                                                  
                    }                    
                    
                }                
            } catch (IOException ex) {
                Logger.getLogger(Books.class.getName()).log(Level.SEVERE, null, ex);
            }
        return isFound;   
                         
 }
    
    
     public List<String[]> ViewAllBooks() 
      {
        
          List<String[]> booksList = new ArrayList<>();
          BufferedReader bufferedReader = bookfile.ReadFile();
    
        try {
            String booklist;
            
            while ((booklist = bufferedReader.readLine()) != null) {     
            String[] words = booklist.split(" ");
            booksList.add(words);               
        }
     } catch (IOException e) {
        System.err.println("Error viewing Books: " + e); 
     }
    
    return booksList; 
                             
                                                 
    }

    
    
        
















    
}
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    

   
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    


                                            
                          
   
   
   
   
   
   
   
   

