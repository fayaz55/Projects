/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coe528.project;

import java.util.ArrayList;
import java.util.Scanner;
/**
 *
 * @author 
 */
public class TestApp {

    /**
     * @param args the command line arguments
     */
    ArrayList <Customer> CustomerList= new ArrayList<>();
    
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner s = new Scanner(System.in);
        
        Manager M = new Manager();
        
        Customer a = new Customer("a","b");
        
        Customer b = new Customer("b","b");
        
        System.out.println("Enter Customer Username");
         String lk = s.nextLine();
        System.out.println("Enter Password");
         String x = s.nextLine();
         M.addCustomer(lk, x);
         for (int i=0;i<M.CustomerList.size();i++){
         System.out.println(M.CustomerList.get(i).login(lk,x, "customer"));
         }
       
         //a.depositMoney(5000);
         //a.depositMoney(20000);
         //a.withdrawMoney(50000);
         //a.purchase(500);
         M.addCustomer("bob", "bob");
         M.addCustomer("bobb", "bob");
         
         System.out.println(M.toString());
         //M.deleteCustomer("bob");
         
         System.out.println(M.toString());
         M.CustomerList.get(1).depositMoney(5000);
         M.CustomerList.get(2).depositMoney(6000);
          M.CustomerList.get(0).depositMoney(4000);
         System.out.println(M.CustomerList.get(1).File.toString());
         System.out.println(M.CustomerList.get(1).Account.toString());
        System.out.println(M.CustomerList.get(0).File.toString());
         System.out.println(M.CustomerList.get(0).Account.toString());
         System.out.println(M.CustomerList.get(2).File.toString());
         System.out.println(M.CustomerList.get(2).Account.toString());
         
    }
    
}
