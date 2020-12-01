/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coe528.project;

import java.util.Scanner;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.geometry.Insets; 
import javafx.scene.control.TextField; 
import javafx.scene.control.PasswordField;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.scene.text.Text;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Font;
import java.lang.Exception;
import java.lang.ArithmeticException;
import java.lang.ArrayStoreException;
import java.lang.IllegalArgumentException;
  

/**
 *
 * @author 
 */
public class BankApp extends Application{

    /**
     * @param args the command line arguments
     */
   Manager M = new Manager();
   int id=0;
   
   @Override // Override the start method in the Application class
  public void start(Stage primaryStage) {
    // Create a scene and place a button in the scene
    M.addCustomer("bobby", "bobby");
    M.CustomerList.get(0).depositMoney(100000);
    M.addCustomer("ralph", "ralph");
    M.CustomerList.get(1).depositMoney(14000);
    M.addCustomer("bob","bob");
    Pane r = new Pane();
    Pane r1 = new Pane();
    Pane r2 = new Pane();
    
    
    //Bank Name
    Text name = new Text("Bank App");
    name.setFont(Font.font("times new roman", FontWeight.BOLD, FontPosture.REGULAR, 20));
    name.relocate(200,25);
    
    // Username Text and TextField
    Text userType = new Text("Username");
    userType.relocate(150, 75);
    TextField useT = new TextField();
    useT.setPrefSize(200, 25);
    useT.relocate(150, 100);
    
    // Password Text and TextField
    Text passw = new Text("Password");
    passw.relocate(150, 125);
    PasswordField passT = new PasswordField();
    passT.setPrefSize(200, 25);
    passT.relocate(150, 150);
   
    // Role Text and TextField
    Text RoleType = new Text("Role");
    RoleType.relocate(150, 175);
    TextField rT = new TextField();
    rT.setPrefSize(200, 25);
    rT.relocate(150, 200);
    
    //Login Button
    Button log = new Button("Login");
    log.setPrefSize(50, 25);
    log.relocate(225, 250);
    
    // Add All to Pane 
    r.getChildren().add(name);
    r.getChildren().add(log);
    r.getChildren().add(userType);
    r.getChildren().add(useT);
    r.getChildren().add(passw);
    r.getChildren().add(passT);
    r.getChildren().add(RoleType);
    r.getChildren().add(rT);
    
    
    Scene scene = new Scene(r, 500, 400);
    primaryStage.setTitle("Bank Application"); // Set the stage title
    primaryStage.setScene(scene); // Place the scene in the stage
    primaryStage.show(); // Display the stage
    
    
    
    //Customer Window
    Button logo = new Button("Logout");
    logo.setPrefSize(75, 25);
    logo.relocate(225, 350);
    r1.getChildren().add(logo);
    
    Button with = new Button("Withdraw");
    with.setPrefSize(100, 25);
    with.relocate(150,300);
    r1.getChildren().add(with);
    
    TextField withT = new TextField();
    withT.setPrefSize(100, 25);
    withT.relocate(150, 250);
    r1.getChildren().add(withT);
    
    Button deposit = new Button("Deposit");
    deposit.setPrefSize(100, 25);
    deposit.relocate(275,300);
    r1.getChildren().add(deposit);
    
    TextField depT = new TextField();
    depT.setPrefSize(100, 25);
    depT.relocate(275, 250);
    r1.getChildren().add(depT);
    
    Button bal = new Button("Balance");
    bal.setPrefSize(100, 25);
    bal.relocate(150,200);
    r1.getChildren().add(bal);
    
    TextField balT = new TextField();
    balT.setPrefSize(100, 25);
    balT.setText("$Balance");
    balT.relocate(150, 150);
    r1.getChildren().add(balT);
    
    Button pur = new Button("Purchase");
    pur.setPrefSize(100, 25);
    pur.relocate(275,200);
    r1.getChildren().add(pur);
    
    TextField purT = new TextField();
    purT.setPrefSize(100, 25);
    purT.relocate(275, 150);
    r1.getChildren().add(purT);
   
    
    Text uname = new Text("Customer");
    uname.setFont(Font.font("times new roman", FontWeight.BOLD, FontPosture.REGULAR, 20));
    uname.relocate(175,50);
    r1.getChildren().add(uname);
    
    Text lev = new Text("Level");
    lev.setFont(Font.font("times new roman", FontWeight.BOLD, FontPosture.REGULAR, 15));
    lev.relocate(175,100);
    r1.getChildren().add(lev);
    
    Scene scene1 = new Scene(r1,500,400);
    primaryStage.setTitle("Customer"); // Set the stage title
    primaryStage.show();
    
    Stage stage = new Stage(); // Create a new stage
    Pane w = new Pane();
    Scene w1 = new Scene(w, 200,200);
    stage.setTitle("Withdraw");
    
    
   
    
    
    // Manager Window
    
    Button logou = new Button("Logout");
    logou.setPrefSize(75, 25);
    logou.relocate(225, 350);
    r2.getChildren().add(logou);
    
    Button add = new Button("Add Customer");
    add.setPrefSize(100, 25);
    add.relocate(212,150);
    r2.getChildren().add(add);
    
    TextField nam = new TextField();
    nam.setPrefSize(100, 25);
    nam.relocate(150, 100);
    r2.getChildren().add(nam);
    
    Text addname = new Text("Username");
    addname.setFont(Font.font("times new roman", FontPosture.REGULAR, 12));
    addname.relocate(150,80);
    r2.getChildren().add(addname);
    
    PasswordField pas = new PasswordField();
    pas.setPrefSize(100, 25);
    pas.relocate(275, 100);
    r2.getChildren().add(pas);
    
    Text addpas = new Text("Password");
    addpas.setFont(Font.font("times new roman", FontPosture.REGULAR, 12));
    addpas.relocate(275,80);
    r2.getChildren().add(addpas);
    
    Button delete = new Button("Delete Customer");
    delete.setPrefSize(125, 25);
    delete.relocate(200,250);
    r2.getChildren().add(delete);
    
    TextField delc = new TextField();
    delc.setPrefSize(100, 25);
    delc.relocate(212, 212);
    r2.getChildren().add(delc);
    
    Text delname = new Text("Username");
    delname.setFont(Font.font("times new roman", FontPosture.REGULAR, 12));
    delname.relocate(212,190);
    r2.getChildren().add(delname);
    
    Text man = new Text("Manager");
    man.setFont(Font.font("times new roman", FontWeight.BOLD, FontPosture.REGULAR, 20));
    man.relocate(212,25);
    r2.getChildren().add(man);
    
    Scene scene2 = new Scene(r2,500,400);
    primaryStage.setTitle("Manager");
    
    
    
    log.setOnAction(new EventHandler<ActionEvent>() {
    @Override public void handle(ActionEvent e) {
        System.out.println(rT.getText());
        if(rT.getText().matches("manager")){
            if (M.login(useT.getText(),passT.getText(),rT.getText())){
                primaryStage.setScene(scene2);
            }
            else {
                rT.setText("Error");
                useT.setText("Invalid User");
                passT.clear();
            }
        }
        else if(rT.getText().matches("customer")){
            
            for(int x = 0;x<M.CustomerList.size();x++){
                if (M.CustomerList.get(x).login(useT.getText(),passT.getText(),rT.getText())){
                    id=x;
                    uname.setText("Customer: " +M.CustomerList.get(id).getUsername());
                    lev.setText(M.CustomerList.get(id).Account.check());
                    primaryStage.setScene(scene1);
                }
                
            }  
            if (id==-1){
                rT.setText("Error");
                useT.setText("Invalid User");
                passT.clear();
            }
            else{
                rT.setText("Error");
                useT.setText("Invalid User");
                passT.clear();
            }
                
        }
        else {
                rT.setText("Error");
                useT.setText("Invalid User");
                passT.clear();
            }
    }
});
    
    logo.setOnAction(new EventHandler<ActionEvent>() {
    @Override public void handle(ActionEvent e) {
        M.CustomerList.get(id).logout();
        rT.clear();
        useT.clear();
        passT.clear();
        balT.setText("$Balance");
        primaryStage.setScene(scene);
    }
});
    logou.setOnAction(new EventHandler<ActionEvent>() {
    @Override public void handle(ActionEvent e) {
        M.logout();
        rT.clear();
        useT.clear();
        passT.clear();
        balT.setText("$Balance");
        primaryStage.setScene(scene);
    }
});
    deposit.setOnAction(new EventHandler<ActionEvent>() {
    @Override public void handle(ActionEvent e) {
        try {
        System.out.println("Deposit");
        M.CustomerList.get(id).depositMoney(Double.valueOf(depT.getText()));
        lev.setText(M.CustomerList.get(id).Account.check());
        depT.clear();
        }
        catch(NumberFormatException s){
            depT.setText("Error");
        }
    }
});
   
    Exception t = new Exception("Too Much");
    with.setOnAction(new EventHandler<ActionEvent>() {
    @Override public void handle(ActionEvent e) {
        try{
            if (Double.valueOf(withT.getText())> M.CustomerList.get(id).getbalance())
                throw t;
        System.out.println("withdraw");
        M.CustomerList.get(id).withdrawMoney(Double.valueOf(withT.getText()));
        lev.setText(M.CustomerList.get(id).Account.check());
        withT.clear();
        }
        catch(NumberFormatException s){
            withT.setText("Error");
        }
        catch(Exception t){
            withT.setText("Not Enough $");
        }
        
    }
    
    
});
    bal.setOnAction(new EventHandler<ActionEvent>() {
    @Override public void handle(ActionEvent e) {
        System.out.println("balance");
        balT.setText(String.valueOf(M.CustomerList.get(id).getbalance()));
        lev.setText(M.CustomerList.get(id).Account.check());
    }
    
 
});
    ArithmeticException u = new ArithmeticException("Purchase");
    pur.setOnAction(new EventHandler<ActionEvent>() {
    @Override public void handle(ActionEvent e) {
        try{
            if (Double.valueOf(purT.getText())<50)
                throw u;
            if (Double.valueOf(purT.getText())>M.CustomerList.get(id).getbalance())
                throw t;
            System.out.println("purchase");
            M.CustomerList.get(id).purchase(id,Double.valueOf(purT.getText()));
            lev.setText(M.CustomerList.get(id).Account.check());
            purT.clear();
        }
        catch(NumberFormatException s){
            purT.setText("Error");
        }
        catch(ArithmeticException u){
            purT.setText("Must be >=$50");
        }
        catch(Exception t){
            purT.setText("Can't Afford");
        }
        
    }
    
    
});
    ArrayStoreException l = new ArrayStoreException("Same Name");
    IllegalArgumentException m = new IllegalArgumentException("Empty");
    add.setOnAction(new EventHandler<ActionEvent>() {
    @Override public void handle(ActionEvent e) {
        try{
            for (int x = 0;x<M.CustomerList.size();x++){
                if (M.CustomerList.get(x).getUsername().equals(nam.getText()))
                    throw l;
                if(nam.getText().equals("")||pas.getText().equals(""))
                    throw m;
            }
            M.addCustomer(nam.getText(), pas.getText());
            nam.clear();
            pas.clear();
        }
        catch (ArrayStoreException l){
             nam.setText("User Exists");
             pas.clear();
        }
        catch(IllegalArgumentException m){
            nam.setText("Empty Fields!");
        }
        
    }
}); 
    delete.setOnAction(new EventHandler<ActionEvent>() {
    @Override public void handle(ActionEvent e) {
        try{
            if(delc.getText().equals(""))
                throw m;
            boolean dne=false;
            for (int x = 0;x<M.CustomerList.size();x++){
                if (M.CustomerList.get(x).getUsername().equals(delc.getText())){
                    M.deleteCustomer(delc.getText());
                    delc.clear();
                    dne=true;
                }
            }
            if (dne==false){
                throw l;
            }
            
            
        }
        catch(ArrayStoreException l){
            delc.setText("Error DNE");
        }
        catch(IllegalArgumentException m){
            delc.setText("FILL IN");
        }   
        
    }
});
  } 
  
  
  public static void main(String[] args) { 
    
    launch(args);
  }
}