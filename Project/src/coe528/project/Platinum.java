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
public class Platinum extends Level{
    
      @Override
      public String CheckLevel(Account A){
        String x = "Account Level: Platinum";
        return(x);
      }
      @Override
      public int getFee(){
        return(0);
    }
}
