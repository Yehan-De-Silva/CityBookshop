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
public class User extends FileManagement{ //Inhetitance concept applied
            
    public User(String fileName) {
        super("UserInformation.txt");
    }
    
    FileManagement userfile = new FileManagement ("UserInformation.txt") {};
     private String UserId;         //Encapsulation concept applied
     private String Password; 
     private String UserType;

    public User(String UserId, String Password) {
        
        this.UserId = UserId;
        this.Password = Password;
    }
                  
     public User(String UserId, String Password, String UserType) {     //Constructor overloading...
        
        this.UserId = UserId;
        this.Password = Password;
        this.UserType = UserType;
    }

    public User() {
        
    }
             
     
    public String getUserId() {
        return UserId;
    }

    public void setUserId(String UserId) {
        this.UserId = UserId;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

    public String getUserType() {
        return UserType;
    }

    public void setUserType(String UserType) {
        this.UserType = UserType;
    }

   
    public boolean AddNewUser() {
        if(!userfile.CreateNewFile()){
            String record = UserId + " " + Password+ " " + UserType ;
            
            return userfile.WriteFile(record);
        }

        return false;
    }

    public boolean ValidateLogin(){
    
         try {
            String[] words = null;
            
            BufferedReader users = userfile.ReadFile();
            String user;

            while ((user = users.readLine()) != null) 
            {              
                words = user.split(" "); 

                if (words[0].equals(UserId) && words[1].equals(Password)) {
                    this.setUserId(words[0]);
                    this.setPassword(words[1]);
                    
                    return true;
                }
                                                                                                                      
            }
        } catch (IOException e)
        {
            System.err.println("Login Failed!! ");
        }
        
        return false;
    }
    
    

    public boolean VerifyAdmin(String passcode){
                 
	if (passcode.equalsIgnoreCase("citybook@123")){
                                        // Passcode for admin users
            return true;
        
        }return false;
                     
}
    
     
     
     
     
     
    
}
