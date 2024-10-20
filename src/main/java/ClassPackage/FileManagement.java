/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ClassPackage;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author yehan
 */



abstract class FileManagement {     //Abstraction concept applied
    
    
    File file;
    private String fileName; 

    public FileManagement(String fileName) {
        this.fileName = fileName;
        
        CreateNewFile();
    }

    public FileManagement() {
    }

   
    
    
    public boolean CreateNewFile(){
     
        try {
            file = new File( fileName);
            if (file.createNewFile()){
                System.out.println("File Created Successfully " + file.getName());
                return true;
            }
            
            System.out.println("File Already Exisit ");
            return false;
        } catch(IOException e) {
            System.out.println("Fail to create file!!" + e);
            return false;
        }
       }
    
    public boolean WriteFile(String record){
    
        try {
            file.createNewFile();
            FileWriter wr = new FileWriter(file, true);
            BufferedWriter buff = new BufferedWriter(wr);

            buff.write(record);
            buff.newLine();
            buff.close();
            wr.close();

            return true;
        } catch (IOException e) {
            System.out.println("Fail to write file!!" + e);
            return false;
        }                 
    
    }
    
     public BufferedReader ReadFile() {
        if(!CreateNewFile())
        {
            try {
                FileReader read = new FileReader(file);
                BufferedReader buff = new BufferedReader(read);

                return buff;
            } catch (IOException e) {
                System.out.println("Fail to read file!!" + e);
            }
        }
        
        return null;
    }
            
            
  
    
    
    
    
    
    
}  
    




