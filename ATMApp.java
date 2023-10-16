package ATMSystem;

import java.util.*;

public class ATMApp {
  public static void main(String[] args) {
    // Create list of Customers
    List<Customer> customers = new ArrayList<Customer>();
    customers.add(new Customer("Kyaw Kyaw", "A0001", "judde34(", 1000));
    customers.add(new Customer("Hla Hla", "A0002", "jf2s9403", 80000));
    customers.add(new Customer("Myo Myo", "A0003", "fsf-0=3325", 30000));
    customers.add(new Customer("Htun Htun", "A0004", "893)(23d2#", 5000));
    customers.add(new Customer("Ko Ko", "A0005", "333#453fvd", 19000));
    customers.add(new Customer("Mg Mg", "A0006", "dsd22dx,m", 900));
    customers.add(new Customer("Thu Thu", "A0007", "mkjp.oudsf", 700));
    customers.add(new Customer("Chit Chit", "A0008", "748s09#", 100));
    customers.add(new Customer("Moe Moe", "A0009", "sdfs!#edfs$", 100000));
    customers.add(new Customer("Su Su", "A0010", "dfrrwFg", 30000));

    Customer customer = new Customer();
    // Show Account information
    customer.showCustomerAccount(customers);

    boolean authenticated = false;
    Customer currentCustomer = null;

    Scanner scanner = new Scanner(System.in);

    while (!authenticated) {
      System.out.println("Please enter customer ID : ");
      String enteredAccountID = scanner.nextLine();
      for (Customer cs : customers) {
        // Check Account ID
        if (enteredAccountID.equals(cs.getID())) {
          while (!authenticated) {
            System.out.println("Please enter password : ");
            currentCustomer = cs;
            String enteredPassword = scanner.nextLine();
            // Check password
            if (enteredPassword.equals(cs.getPassword())) {
              currentCustomer = cs;
              authenticated = true;
              break;
            }
            if (!authenticated) {
              System.err.println("Password is incorrect.");
            }
          }
        }
      }
      if (!authenticated)
        System.err.println("Customer ID does not exist.");
    }
    int currentBalance = currentCustomer.getBalance();
    System.out.println("Name: " + currentCustomer.getName());
    System.out.println("Balance: " + currentBalance + "yen");
    authenticated = false;
    while (!authenticated) {
      System.out.println("Wolud you like to withdraw? (Yes/No)");
      String withdrawOrNot = scanner.next();
      // Check withdraw or not
      if (withdrawOrNot.toLowerCase().equals("yes")) {
        authenticated = false;
        while (!authenticated) {
          System.out.println("Please enter withdrawl amount : ");
          int enteredAmount = scanner.nextInt();
          // Check withdraw or not
          if (enteredAmount < currentCustomer.getBalance() && enteredAmount > 0) {
            currentBalance -= enteredAmount;
            System.out.println("Withdrawal amount : " + enteredAmount + "yen");
            System.out.println("Your balance : " + currentBalance + "yen");
            System.out.println("Thank you for using our service.");
            authenticated = true;
            break;
          } else {
            System.err.println("Invalid Balance!");
          }
        }
      } else if (withdrawOrNot.toLowerCase().equals("no")) {
        System.out.println("Thank you for using our service.");
        authenticated = true;
      } else {
        System.err.println("Invalid input");
      }
    }
    scanner.close();

  }

}