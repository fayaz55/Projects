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

public class Customer extends User {
      
      int i=-1;
      int idc;
      Account Account;
      File File;
      public Customer(String User, String Pass){
          this.File = new File(User,Pass);
          this.Account = new Account();
      }
    
     @Override
    public boolean login (String name, String pass, String rol){
        if ((this.File.getName().equals(name)) && (this.File.getPass().equals(pass)) && (this.File.getRole().equals(rol)) )
            return true;
        else
            return false;
    }
    
    @Override
    public boolean logout(){
        return true;
    }
    
    public String getUsername(){
      return(this.File.getName()); 
    }
    public String getPassword(){
      return(this.File.getPass());
    }
    public String getUserRole(){
      return(this.File.getRole());
    }
    public void depositMoney(double money){
      this.Account.deposit(money);
      this.Account.check();
      getbalance();
    }
    
    public void withdrawMoney(double amount){
      if (amount>Account.balance){
          System.out.println("Not enough Money in Account");
          
      }
      else{
        this.Account.withdraw(amount);  
        System.out.println(this.Account.check());
        getbalance();
      }
    }
    public double getbalance(){
      return(this.Account.balance());
    }
    
    public void purchase(int q,double num){
        if (num>=50){
            num+= Account.getF();
            this.withdrawMoney(num);
        }
        else 
            System.out.println("Purchase must be $50 or more");
    }
}
