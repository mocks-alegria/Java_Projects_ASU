public class CheckingAccount extends BankAccount {
  private int maxWithdraw;
  
  private int withdrawalCount;
  
  CheckingAccount(int withdrawLimit, double initialBalance) {
    this.maxWithdraw = withdrawLimit;
    this.withdrawalCount = 0;
    deposit(initialBalance);
  }
  
  public void withdrawal(double amt) {
    super.withdrawal(amt);
    this.withdrawalCount++;
    if (this.withdrawalCount > 3)
      super.withdrawal(1.0D); 
  }
  
  public void monthEnd() {
    this.withdrawalCount = 0;
  }
  
  public String toString() {
    return String.format("Checking: Balance=$%.2f, Allowed Withdrawals=%d, #Withdrawals=%d", new Object[] { Double.valueOf(getBalance()), Integer.valueOf(this.maxWithdraw), Integer.valueOf(this.withdrawalCount) });
  }
}
