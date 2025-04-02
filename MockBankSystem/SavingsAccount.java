public class SavingsAccount extends BankAccount {
  private double rate;
  
  private double minimumBalance;
  
  SavingsAccount(double minimum, double rate, double initialBalance) {
    this.minimumBalance = minimum;
    this.rate = rate / 100.0D;
    deposit(initialBalance);
  }
  
  public void monthEnd() {
    if (getBalance() >= this.minimumBalance)
      deposit(this.rate * getBalance()); 
  }
  
  public String toString() {
    return String.format("Savings: Balance=$%.2f, Minimum=$%.2f, Rate=%.3f%%", new Object[] { Double.valueOf(getBalance()), Double.valueOf(this.minimumBalance), Double.valueOf(this.rate) });
  }
}
