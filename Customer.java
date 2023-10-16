package ATMSystem;

import java.util.List;

public class Customer {
  private String name;
  private String id;
  private String password;
  private int balance;
  private String unit = "¥";

  public Customer() {

  }

  public Customer(String name, String id, String password, int balance) {
    this.name = name;
    this.id = id;
    this.password = password;
    this.balance = balance;
  }

  public String getID() {
    return id;
  }

  public void setID(String id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public int getBalance() {
    return balance;
  }

  public void setBalance(int balance) {
    this.balance = balance;
  }

  // To show customers table list
  public void showCustomerAccount(List<Customer> customers) {
    int custno = 1;
    System.out.println("SSဘဏ်တွင်အောက်ပါ Customer ၁၀ ဦး၏စာရင်းရှိပါတယ်။");
    // formatted table header
    System.out.println("-------------------------------------------------------------------------");
    System.out.printf("| %-2s |%-12s |  %-14s | %-15s | %-16s |%n", "No.", "အမည်", "ID", "Password", "လက်ကျန်ငွေ");
    System.out.println("-------------------------------------------------------------------------");

    // Show list of customer accounts
    for (Customer cs : customers) {
      System.out.printf("| %-2s |%-12s |  %-14s | %-15s | %s%-11s |%n", custno, cs.name, cs.id, cs.password, unit,
          cs.balance);
      System.out.println("-------------------------------------------------------------------------");
      custno++;
    }
  }
}