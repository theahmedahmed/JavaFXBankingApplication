package coe528.project;

/**
 *
 * @author Ahmed Ahmed
 */

public class Customer {
    /**
     * Overview: Customer is a mutable collection of
     * information about a customer's banking account.
     * 
     * The abstraction function is:
     * username = The username of the bank account.
     * password = The password of the bank account.
     * balance = The amount of money the account holds.
     * level = The level of the bank account (silver, gold, or platinum).
     * 
     * The rep invariant is:
     * - All of the instance variables exist (are not null).
     * - The balance has to be a positive number.
     * - The level has to be either silver, gold, or platinum.
     * 
     */
    
    String username;
    String password;
    double balance;
    String level;
    
    public Customer(String user, String pass){
        username = user;
        password = pass;
        balance = 100.0;
        level = "silver";
    }
    
    
    /**
     * Requires: N/A
     * Modifies: N/A
     * Effects: Changes (or keeps) the level of the customer based on the
     * balance of their bank account.
     */
    public void checkLevel(){
        if(balance < 10000)
            level = "silver";
        
        else if (balance >= 10000 && balance < 20000)
            level = "gold";
        
        else
            level = "platinum";
    }
    
    public boolean repOK(){
        if(username == null || password == null || level == null)
            return false;
        
        if(balance < 0)
            return false;
        
        return level.equals("silver") || level.equals("gold") || level.equals("platinum");
    }
    
    @Override
    public String toString(){
        return "Username: " + username + "\n" + "Password: " + password + "\n" + "Balance: " + balance + "\n" + "Level: " + level;
    }
}
