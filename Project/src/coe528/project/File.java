/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coe528.project;

/**
 *
 * @author 
 */
public class File {
    // Overview: File is an immutable object which stores
    // a customer's credentials such as Username, Password, and Role
    // The abstraction function is:
    // a) Write the abstraction function here
    // 
    // AF(C)= a File object containing 3 string variables where c.getName() 
    //returns customer's username, c.getPassword() returns password and c.getRole()
    // returns customer role
    // The rep invariant is: 
    // b) Write the rep invariant here
    // 
    // User and Password can be any values;
    // 
    protected String Username;
    private String Password; 
    protected String role;
    
    // Requires: NA since String can accept null and empty values
    // Modifies: Username and Password
    // Effects: Sets Username and Password
    
    public File(String User, String Pass){
        Username = User; 
        Password = Pass;
        role = "customer";
    }
    
    // Requires: NA 
    // Modifies: NA 
    // Effects: Returns Username
    public String getName(){
        return(Username);
    }
    
    // Requires: NA
    // Modifies: NA 
    // Effects: Returns Password
    public String getPass(){
        return(Password);
    }
    
    // Requires: NA
    // Modifies: NA 
    // Effects: Returns Role
    public String getRole(){
        return(role);
    }
    
    //Requires: NA
    //Modifies: f
    //Effects: Returns Username, Password and Role in one String f
    public String toString(){
        String f = "Username: " + Username + ", Password: " + Password + ", Role: " + role ;
        return(f);
    }
    
    public boolean repoK(){
        if (Username.isEmpty() ||Password.isEmpty()||Username.isBlank() ||Password.isBlank())
            return true;
        else 
            return true;
    }
}
