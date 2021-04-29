import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class CashRegister {
  public static final String OUTSTANDING_RECEIPTS_PATH = "./outstandingReceipts.txt";
  public static final String RECEIPT_PATH = "./receipt.txt";

  public static void main(String[] args) throws InputMismatchException, IOException {

    // get starting balance
    double startBalance = getMoneyValue("How much money do you have?");
    System.out.println("Ok, you have $" + startBalance);

    // calculate total register amount by combining receipt payments and starting balance.
    File outstandingReceiptsFile = new File(OUTSTANDING_RECEIPTS_PATH);
    Scanner fileScanner = new Scanner(outstandingReceiptsFile);
    double registerSubtotal = 0.0;
    while(fileScanner.hasNext()) {
      registerSubtotal += fileScanner.nextDouble();
    }
    double registerTotal = registerSubtotal + startBalance;
    System.out.println("Register Current Balance: $" + registerTotal);

    // call processOrder to allow cashier continuously process orders, until `exit`
    System.out.println("Hit enter to process orders:");
    Scanner cashierScanner = new Scanner(System.in);
    String cashierOption = cashierScanner.nextLine();
    while(!cashierOption.equals("exit")) {
      registerTotal = processOrder(registerTotal);
      System.out.println("Press enter to process another order, or enter `exit` to terminate:");
      cashierOption = cashierScanner.nextLine();
    }
  }

  public static double processOrder(double registerTotal) throws IOException {
    // get cost of customer order
    double costOfOrder = getMoneyValue("How much is the customer's order?");
    System.out.println("Ok, you have entered $" + costOfOrder);

    // continuously prompt for reasonable amount of cash for the order
    double providedCash = getMoneyValue("How much is the customer provided?");
    double changeDue = providedCash - costOfOrder;
    while(providedCash < costOfOrder || registerTotal < changeDue) {
      if(providedCash < costOfOrder) {
        providedCash = getMoneyValue("Sorry, this is not enough fund for the order. Please try again:");
        changeDue = providedCash - costOfOrder;
      } else if(registerTotal < changeDue) {
        providedCash = getMoneyValue("Sorry, please provide fund closer to the cost of order.");
        changeDue = providedCash - costOfOrder;
      }
    }
    System.out.println("The customer has provided $" + providedCash);
    System.out.println("Final change due is $" + changeDue);
    registerTotal += costOfOrder;
    System.out.println("Current register: $" + registerTotal);

    // Write order details to receipt.txt
    File receipt = new File(RECEIPT_PATH);
    FileWriter receiptWriter = new FileWriter(receipt, true);
    receiptWriter.write(costOfOrder + " ");
    receiptWriter.write(providedCash + " ");
    receiptWriter.write(changeDue + "\n");
    receiptWriter.close();

    return registerTotal;
  }

  public static Double getMoneyValue(String prompt) {
    Scanner inputScanner = new Scanner(System.in);
    System.out.println(prompt);
    String userInput = inputScanner.nextLine();
    while(userInput.isBlank()) {
      System.out.println("Sorry, please enter a value to proceed:");
      userInput = inputScanner.nextLine();
    }
    return Double.parseDouble(userInput);
  }
}
