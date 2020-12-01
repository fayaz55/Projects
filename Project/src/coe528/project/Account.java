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
public class Account {
    protected double balance; 
    Level currentLevel;
    public Account(){
        balance = 100;
        currentLevel=new Silver();
    }
    public void deposit(double mon){
        balance+=mon;
    }
    public void withdraw(double am){
        balance-=am;
    }
    public double balance(){
        return balance;
    }
    
    public void setLevel(Level lev){
        this.currentLevel = lev;
    }
    
    public String check(){
        if (balance<10000)
            setLevel(new Silver());
        else if (balance>=10000 && balance <20000)
            setLevel(new Gold());
        else
            setLevel(new Platinum());
        return(currentLevel.CheckLevel(this));
    }
    public int getF(){
        return(currentLevel.getFee());
    }
    
    public String toString(){
        String t = "Balance is $" + balance;
        return t;
    }
}
