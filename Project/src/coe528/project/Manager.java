/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coe528.project;

import java.util.ArrayList;

/**
 *
 * @author 
 */
public class Manager extends User {
    protected String username; 
    private String password; 
    protected String role; 
    ArrayList <Customer> CustomerList= new ArrayList<>();
    
    public Manager(){
        username = "admin";
        password = "admin";
        role = "manager";
    }
    
    @Override
    public boolean login (String name, String pass, String rol){
        if (name.equals(username) && (pass.equals(password)) && (rol.equals(role))){
            System.out.println("login");
            return(true);
        }
        else{
            System.out.println("Login Failed. Try Again");
            return(false);
        }
    }
    @Override
    public boolean logout(){
        System.out.println("Logout Successful");
        return(true);
    }
    
    public void addCustomer(String Use, String Pas){
        CustomerList.add(new Customer(Use,Pas));
    }
    
    public void deleteCustomer(String Use){
        for (int x = 0;x<CustomerList.size();x++){
            if (CustomerList.get(x).getUsername().equals(Use)){
                CustomerList.remove(x);
            }
               
        }
     
    }
    @Override
    public String toString(){
        String w ="Manager Handles Customers:";
         for (int x = 0;x<CustomerList.size();x++){
             w+=CustomerList.get(x).getUsername();
         }
        return (w);
    }
}
