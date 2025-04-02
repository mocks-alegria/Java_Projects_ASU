import java.util.ArrayList;
import java.util.Scanner;

public class Banking {
  static Scanner in = new Scanner(System.in);
  
  public static void main(String[] args) {
    char option = ' ';
    System.out.println("ACME Banking Application - Maximiliano Alegria");
    ArrayList<BankAccount> accounts = new ArrayList<>();
    accounts.add(new CheckingAccount(3, 100.0D));
    accounts.add(new SavingsAccount(100.0D, 2.5D, 200.0D));
    accounts.add(new CDAccount(7.5D, 60, 10000.0D));
    accounts.add(new SavingsAccount(100.0D, 2.5D, 300.0D));
    accounts.add(new CheckingAccount(3, 400.0D));
    accounts.add(new CDAccount(5.0D, 2, 5000.0D));
    while (option != 'Q') {
      option = printMenu();
      switch (option) {
        case 'D':
          makeDeposit(accounts);
          continue;
        case 'W':
          makeWithdrawal(accounts);
          continue;
        case 'M':
          doMonthEnd(accounts);
          continue;
        case 'L':
          listAll(accounts);
          continue;
        case 'Q':
          continue;
      } 
      System.out.println("Select D, W, M, L, or Q");
    } 
  }
  
  public static char printMenu() {
    System.out.println("\nL)ist All D)eposit W)ithdraw M)onth end Q)uit");
    return in.nextLine().toUpperCase().charAt(0);
  }
  
  public static void makeDeposit(ArrayList<BankAccount> accounts) {
    System.out.print("Account Number ");
    int acctNum = in.nextInt();
    BankAccount targetAccount = accounts.get(acctNum);
    System.out.print("Amount ");
    double amount = in.nextDouble();
    in.nextLine();
    targetAccount.deposit(amount);
    System.out.printf("*** New balance: %.2f\n", new Object[] { Double.valueOf(targetAccount.getBalance()) });
  }
  
  public static void makeWithdrawal(ArrayList<BankAccount> accounts) {
    System.out.print("Account Number ");
    int acctNum = in.nextInt();
    BankAccount targetAccount = accounts.get(acctNum);
    System.out.print("Amount ");
    double amount = in.nextDouble();
    in.nextLine();
    targetAccount.withdrawal(amount);
    System.out.printf("*** New balance: %.2f\n", new Object[] { Double.valueOf(targetAccount.getBalance()) });
  }
  
  public static void doMonthEnd(ArrayList<BankAccount> accounts) {
    for (int acct = 0; acct < accounts.size(); acct++) {
      BankAccount b = accounts.get(acct);
      b.monthEnd();
      System.out.printf("%2d: %7.2f\n", new Object[] { Integer.valueOf(acct), Double.valueOf(b.getBalance()) });
    } 
  }
  
  public static void listAll(ArrayList<BankAccount> accounts) {
    for (int i = 0; i < accounts.size(); i++)
      System.out.println(String.valueOf(i) + ": " + ((BankAccount)accounts.get(i)).toString()); 
  }
}
