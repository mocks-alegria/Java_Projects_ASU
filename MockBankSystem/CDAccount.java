public class CDAccount extends BankAccount {
  double interestRate;
  
  int monthTerm;
  
  public CDAccount() {
    this.interestRate = 0.0D;
    this.monthTerm = 99999;
    deposit(0.0D);
  }
  
  public CDAccount(double rate, int numMonths, double balance) {
    this.interestRate = rate / 100.0D;
    this.monthTerm = numMonths;
    deposit(balance);
  }
  
  public void monthEnd() {
    if (this.monthTerm > 0) {
      this.monthTerm--;
      deposit(this.interestRate * getBalance());
    } else {
      System.out.println("Term is over");
    } 
  }
  
  public void withdrawal(double amt) {
    if (this.monthTerm > 0) {
      double penalty = getBalance() * 0.1D;
      double amtWithdraw = getBalance() - penalty;
      super.withdrawal(getBalance());
      System.out.printf("Early CD Withdrawal. $%.2f penalty, $%.2f cashed out", new Object[] { Double.valueOf(penalty), Double.valueOf(amtWithdraw) });
    } else {
      System.out.printf("Mature CD Withdrawal. No penalty, $%.2f cashed out", new Object[] { Double.valueOf(getBalance()) });
      super.withdrawal(getBalance());
    } 
  }
  
  public String toString() {
    return String.format("CD: Balance=$%.2f, Term=%d, Rate=%.3f%%", new Object[] { Double.valueOf(getBalance()), Integer.valueOf(this.monthTerm), Double.valueOf(this.interestRate) });
  }
}