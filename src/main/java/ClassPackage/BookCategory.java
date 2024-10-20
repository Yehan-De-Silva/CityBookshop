/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ClassPackage;

import java.io.BufferedReader;
import java.io.IOException;



/**
 *
 * @author yehan
 */
public class BookCategory extends Books  {     
    
    FileManagement Categorylist = new FileManagement ("BookCategory.txt"){};
    
    private String CategoryName;

    public BookCategory() {
    }
    

    public BookCategory(String CategoryName) {
        this.CategoryName = CategoryName;
    }
  
    public String getCategoryName() {
        return CategoryName;
    }

    public void setCategoryName(String CategoryName) {
        this.CategoryName = CategoryName;
    }
    
    public boolean AddCategory(){
    
        String record;
        
        if (!Categorylist.CreateNewFile()){
         
            record = CategoryName;
            
            return Categorylist.WriteFile(record);
        }
       return false;
    }
    
   
    public String viewAllCategories() {

        String List, Alllist = " ";
        String[] words = null;
        
        BufferedReader bufferedReader = Categorylist.ReadFile();
        try {
            while ((List = bufferedReader.readLine()) != null) {
                words = List.split(" ");
                Alllist = Alllist + words[0] + "\n";
                
            }
        } catch (IOException e) {
            System.out.println("Failed to add category!!" + e);
        }
       
        return Alllist;
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
     
    
}
