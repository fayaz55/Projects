# Java Bank Account Application Project 

## Introduction

This is a Bank Account Application Project created for one of my computer engineering courses at Ryerson 
University.
The problem statement is described below:

You will develop a simple Bank Account Application. The application must be a graphical user interface (GUI) based. 
There are two kinds of users of this application: Manager and Customer. Here we will assume there is only one manager 
and zero or more customers who uses the application. Every customer has only one bank account. A customer can login, 
logout, deposit money, withdraw money, get balance, do online purchase(s). The manager  can login, logout, add customer,
and delete customer.
 
Every customer has three levels: silver, gold, platinum. When a customer has less than 10000 dollars in her account,
she is at silver level. When a customer has 10000 dollars or more but less than 20000 dollars in her account,
she is at gold level. When a customer has 20000 dollars or more in her account, she is at platinum level. A customer
can do an online purchase using the money in her account. The online purchase must be of 50 dollars or more. When a
silver customer does an online purchase using her ac-count, she needs to pay a fee of 20 dollars in addition to 
the purchase amount from her account. When a gold customer does an online purchase using her account, she needs 
 to pay a fee of 10 dollars. When a platinum customer does an online purchase, she does it without paying any fee.
 
In this application, the manager has username: admin, password:admin, and role = manager.  A customer has a username,
 password, and role = customer, bank account and level. The information about the customers is stored in separate 
 files—one file per customer; the filename can have the username of the customer. When a manager tries to login 
 through the user interface, the manager’s username, password and role are authenticated. When a customer tries 
 to login through the user interface, the customer’s username, password and role are authenticated using the 
 information stored in the relevant file. Only the manager of the bank has the authority to add or delete a customer. 
 When the manager adds a customer, she must create the account of the customer as well with a 100 dollar balance in 
 the account. When the manager deletes a customer, the associated account should get deleted as well. It is assumed
 that no two users can have the same username.
 
Your project must apply the State design pattern. The change of level of the customer is the re-sponsibility of the concrete state classes.

The GUI of the application has to be developed using JavaFX.

## Files

* `Account.java` Class defining Account object. Contains Level and Balance for Account
* `BankApp.java` GUI for App
* `Customer.java` Class defining Customer object. Holds File and Account of Customer and methods of actions allowed by customer.
* `File.java` Class defining File object. Contains customer credentials.
* `Level.java` Abstract class for silver,gold and platinum levels
* `Silver.java , Gold.java, Platinum.java` Class defining levels for each account type
* `Manager.java` Class Defining Manager object. Holds credentials and methods of actions allowed by manager
* `TestApp.java` Test application to verify whether application works successfully
* `User.java` Abstract class for manager and customer



