public class BankAccount {
  private double balance;
  
  public BankAccount() {
    this.balance = 0.0D;
  }
  
  public BankAccount(double initBalance) {
    this.balance = initBalance;
  }
  
  public void deposit(double amt) {
    this.balance += amt;
  }
  
  public void withdrawal(double amt) {
    this.balance -= amt;
  }
  
  public void monthEnd() {}
  
  public double getBalance() {
    return this.balance;
  }
}