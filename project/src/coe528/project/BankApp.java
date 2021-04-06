package coe528.project;

/**
 *
 * @author Ahmed Ahmed
 */
import java.util.ArrayList;
public class BankApp {
    Manager manager;
    ArrayList<Customer> customers;
    int current = 0;
    
    public BankApp(){
        manager = new Manager();
        customers = new ArrayList<>();
        customers.add(new Customer(" "," "));
    }
    
    public boolean managerLogin(String user, String pass){
        return user.equals("admin") && pass.equals("admin");
    }
    
    public boolean customerLogin(String user, String pass){
        int index = -1;
        for(int i=0;i<customers.size();i++){
            if(customers.get(i).username.equals(user)){
                index = i;
                break;
            }
        }
        
        if(index == -1)
            return false;
        
        if(customers.get(index).password.equals(pass)){
            current = index;
            return true;
        }
        
        else
            return false; 
    }
    
    public boolean addcustomer(String user, String pass){
        for (Customer customer : customers) {
            if (customer.username.equals(user)) {
                return false;
            }
        }
        
        customers.add(new Customer(user, pass));
        return true;
    }
    
    public boolean deletecustomer(String user){
        int index = -1;
        for(int i=0;i<customers.size();i++){
            if(customers.get(i).username.equals(user)){
                index = i;
                break;
            }
        }
        
        if(index == -1)
            return false;
        
        customers.remove(index);
        return true;
    }
    
    public boolean deposit(double amount){
        if(amount < 0)
            return false;
        
        customers.get(current).balance += amount;
        customers.get(current).checkLevel();
        return true;
    }
    
    public boolean withdraw(double amount){
        if(amount > customers.get(current).balance || amount < 0)
            return false;
        
        customers.get(current).balance -= amount;
        customers.get(current).checkLevel();
        return true;
    }
    
    public String getUsername(){
        return customers.get(current).username;
    }
    
    public double getBalance(){
        return customers.get(current).balance;
    }
    
    public String getLevel(){
        return customers.get(current).level;
    }
    
    public boolean doOnlinePurchase(double amount){
        if(amount < 50)
            return false;
        
        if(customers.get(current).level.equals("silver"))
            return this.withdraw(amount+20);
        
        else if (customers.get(current).level.equals("gold"))
            return this.withdraw(amount+10);
        
        else
            return this.withdraw(amount);
    }
}
