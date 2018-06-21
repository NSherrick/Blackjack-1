/*
 *player class
 */
//strategy class composition at later point----
package blackjack;

public class Player {
    private String name;
    private double balance;
    
    //empty constructor
    public Player(){        
    }
    //constructor with name and balance
    public Player(String name, double balance){
        this.name = name;
        if(balance > 0)
            this.balance = balance;
    }
    //setters and getters for name
    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return name;
    }
    //setters and getters for balance
    public void setBalance(double balance){
        if(balance > 0){
            System.out.println("The balance of the account is:\t"+balance);
            this.balance = balance;
        }        
    }
    public double getBalance(){
        return balance;
    }
    //add winnings to balance
    public void addWinnings(double amountWon){
        balance+=amountWon;
    }
    //placing bets method
    public void placeBet(double bet){
        if(balance-bet >0){
            balance-=bet;
        }
        else{
            System.out.println("Not enough money in account!");
        }
    }
    @Override
    public String toString(){
        return String.format("Customer Name:  %s\nAccount Balance:  $%.2f", getName(), getBalance());
    }   
    
}
