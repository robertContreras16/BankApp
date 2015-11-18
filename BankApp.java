//********************************************************************************
//REMEMBER TO UPDATE YOUR STUDENT CREDENTIALS BEFORE SUBMITTING ONLINE
//********************************************************************************
// Student Name:      Robert Contreras
// Program Name:      BankApp Class
// Date:              11/11/2015
// Class and Section: IS 2041 Sec # 001


// Import Scanner for read in through keyboard
import java.util.Scanner; 

// Import ArrayList for use in storing Customer's in a Collection
import java.util.ArrayList;

// Import swing package for use in creating GUI windows and prompts
import javax.swing.*;

// Import Pattern for validation of user input
import java.util.regex.Pattern;

// Import Matcher for matching user input to specified Pattern
import java.util.regex.Matcher;

// Import Date for use of setting dates of birth
import java.util.Date;






/********************************************************
 *                  CLASS BANKAPP                       *
 ********************************************************
 * This class contains 4 instance variables and 5 methods
 * for running this application and for retrieving the 
 * users choice in menu option selection and input from 
 * the keyboard. One method allows for registration of 
 * a customer in a GUI display.
 * 
 * This class will serve as the application that runs 
 * the capabilites of the bank such as creating new 
 * account's, withdrawing and depositing funds and
 * viewing account information. 
 */



public class BankApp 
{
  
  
  
  
  /********************************************************
   *                  CLASS VARIABLES                     *
   ********************************************************/
  
  
  // Global Scanner for receiving input from user through the keyboard from any method in this class
  private static Scanner input = new Scanner(System.in);
  
  // Global ArrayList for storing Customer objects as a Collection from any method in this class
  public static  ArrayList<Customer> studentCustomer = new ArrayList<Customer>();
  
  // Global CustomerList for manipulating a Customer ArrayList from any method in this class
  public static CustomerList customerList = new CustomerList( studentCustomer );
  
  // Global Bank object for use from any method in this class
  public static Bank bank = new Bank(15);
  
  
  
  
  
  
  /*************************************************************************
   *                            METHOD: MAIN                               *
   *************************************************************************
   *                                                                       *
   *    The main method handles all the functions of the bank including    *
   *    creating new accounts, withdrawing or depositing from account,     *
   *    finding accounts and printing account and customer information.    * 
   *                                                                       *
   *************************************************************************/
  
  
  
  public static void main(String[] args) throws InsufficientFundsException
  {
    
    

  /********************************************************
   *                  METHOD VARIABLES                    *
   ********************************************************/
    
    // Declaration of BankAccount variable
    BankAccount account = null;
    
    // int variable used to store the user's menu selection
    int choice;
    
    // Double variable to store an amount to either withdraw or deposit into an account
    Double amount;
    
    // Integer variable to store a customer's account number
    Integer accountNumber;
    
    // Create an array of Customers to hold Customer objects
    Customer[] customerArray = new Customer[4];
    customerArray[0] = new Customer( "Pablo", "Escobar", "Entrepreneurship", "Junior", new Date(49,11,1), "555-555-5555",
                                     1234567, 15000000.23, 12345, 40500.96 );
    customerArray[1] = new Customer( "Antonio", "Montana", "Pharmacy", "Senior", new Date(40, 4, 5), "210-555-5555", 
                                     7654321, 13000000.72, 54321, 32100.45 );
    customerArray[2] = new Customer( "James", "St.Patrick", "Events Management", "Sophomore", new Date(75,5,7), "917-123-4567",
                                     9876543, 10500999.07, 98765, 25674.15 );
    customerArray[3] = new Customer( "Carlito", "Brigante", "Marketing", "Senior", new Date(30,1,1), "917-987-6543",
                                     3456789, 8765899.99, 56789, 15234.27 );
    
    
    // For each customer in the customerArray...
    for( Customer customers : customerArray )
    {
      // Add customer objects into the Customer ArrayList
      studentCustomer.add( customers );
      // Add each new BankAccount into the Bank object
      bank.add( customers.getBankAccount() );
      
    } // End foreach loop
    
    
    
    
    
    
    
  /********************************************************
   *                    METHOD LOGIC                      *
   ********************************************************/
    
    
  /********************************************************
   *                      DO/WHILE                        *
   ********************************************************
   * The do/while loop will continue to process until the
   * user selects to end using the bank functions.
   * The user makes a menu choice which is used to control
   * the switch selection.
   */
    
    do 
    {
      // Choice is equal to the number chosen from the menu options
      choice = getUserChoice();
      
      
  /********************************************************
   *                  SWITCH STATEMENT                    *
   ********************************************************
   * The switch uses the number related to the menu choice
   * made by the user and executes the appropriate code.
   * The user will be given the menu choice again after
   * each menu choice's code has been executed until choice
   * zero is selected.
   */
      
      // Variable choice controls the switch
      switch (choice) 
      {
        
        
        
        
        // If menu choice one is selected
        case 1:
          
          // amount will be set to the amount entered by the user in the getAmount method call
          amount = getAmount();
          // accountNumber will be set to the number entered by the user in the getAccountNumber method call
          accountNumber = getAccountNumber();
          
          // try the following code for exceptions that could be thrown
          try 
          {
            
            // account will be instantiated with a new BankAccount object passing amount and accountNumber
            account = new BankAccount(amount, accountNumber);
            // Add the new BankAccount to the Bank 
            bank.add(account);
            // Display newly created account with account information
            System.out.println("Account info: " + account + "\n");
            
          } // End try block 
          
          // catch thrown exceptions
          catch (IllegalArgumentException exception) 
          {
            // Prints the error message given by the exception
            System.out.println("\n*****ERROR*****: " + exception.getMessage() + "\n");
            
          } // End catch block 
          
          break; // break from case 1 and give menu selection again
          
          
          
          
          
          
          
          
        // If menu choice two is selected  
        case 2:
          
          // amount is set to amount entered by user in getAmount method call
          amount = getAmount();
          
          // try the following code for exceptions that could be thrown
          try 
          {
            
            // Calls method deposit from BankAccount class to add the passed amount to the current balance
            account.deposit(amount);
            
            // Display updated account information
            System.out.println("Account info: " + account + "\n");
            
          } // End try block 
          
          // catch exception if thrown 
          catch (NullPointerException exception) 
          {
            // Print error message
            System.out.println("\n*****ERROR*****: " + "No account! First find account"
                                 + " or create a new account\n");
            
          } // End catch block 
          
          // catch exception if thrown 
          catch (IllegalArgumentException exception) 
          {
            // Display error message
            System.out.println("\n*****ERROR*****: " + exception.getMessage()  + "\n");
            
          } // End catch block 
          
          break; // break from case 2 and give menu selection again
          
          
          
          
          
          
          
        // If menu choice three is selected  
        case 3:
          
          // amount is set to amount entered by user in the getAmount method call
          amount = getAmount();
          
          // try the following code for exceptions that could be thrown 
          try 
          {
            
            // Calls method withdraw from BankAccount class to substract passed amount from the current balance
            account.withdraw(amount);
            
            // Display updated information
            System.out.println("Account info: " + account + "\n");
            
          } // End try block 
          
          // catch exception if thrown 
          catch (IllegalArgumentException exception) 
          {
            
            // Print error message
            System.out.println("\n*****ERROR*****: " + exception.getMessage()  + "\n");
            
          } // End catch block 
          
          break; // break from case 3 and give menu selection again
          
          
        
          
          
          
          
        // If menu choice four is selected  
        case 4:
          
          // accountNumber is set to number entered by user in the getAccountNumber method call
          accountNumber = getAccountNumber();
          
          // Create BankAccount set to account found in current account's held by Bank 
          BankAccount found = bank.find(accountNumber);
          
          // If BankAccount found is not null
          if (found != null) 
          {
            
            // Set BankAccount account to BankAccount found
            account = found;
            
            // Display found account information
            System.out.println("Account info: " + account + "\n");
            
          } 
          
          // Otherwise...
          else 
          {
            // Print error message
            System.out.println("\n*****ERROR*****: Bank account " + accountNumber
                                 + " not found!\n");
          }
          
          break; // break from case 4 and give menu selection again
          
          
          
          
          
          
          
        // If menu choice five is selected
        case 5:
          
          // Display all accounts held in the Bank
          System.out.print("\n\nThe accounts: \n" + bank.toString() );
          
          break; // break from case 5 and give menu selection again
          
          
          
          
          
          
          
          
        // If menu choice six is selected  
        case 6:
          
          // Display Customer information from the customerList
          System.out.printf( customerList.toString() );
          
          break; // break from case 6 and give menu selection again 
          
          
          
          
          
          
        // If menu choice seven is selected  
        case 7:
          
          // Call registerCustomer method to create new customer
          // Send the size of the Customer ArrayList to the method
          registerCustomer( studentCustomer.size() );
          
          break; // break from case 7 and give menu selection again
          
          
        case 8: 
          break;
          
      } // End switch
      
      
      
      
      
    } while (choice != 0); // End do/while
    
    // Prints if menu choice zero is selected
    System.out.println("\n\nGoodbye!");
    
  } // End method main
  
  
  
  
  
  
  
  
  
                    /********************************************************
                     *                 METHOD: GETUSERCHOICE                *
                     ********************************************************
                     *                                                      *
                     *    Method returns an int value and does not take     *
                     *    any parameters. This method allows for the user   *
                     *    to make a choice based on the given menu          *
                     *    options and then returns the choice to the        *
                     *                      calling method.                 *
                     *                                                      *
                     ********************************************************/
  
  
  private static int getUserChoice() 
  {
    // Declare int variable to hold the user's selected menu choice
    int choice;
    
    
    do 
    {
      // Initialize choice to a number that is not one of the menu options
      choice = -1;
      
      // Creates the menu to be chosen from 
      System.out.println("\nMenu Options:");
      System.out.println("0) Quit");
      System.out.println("1) Create new account");
      System.out.println("2) Deposit to current account");
      System.out.println("3) Withdraw from current account");
      System.out.println("4) Find account");
      System.out.println("5) Print all accounts");
      System.out.println("6) Print Customer List");
      System.out.println("7) Register New Account");
      
      
      // Prompts for user choice
      System.out.print("Enter your choice (0 - 7): ");
      
      // try the following code for exceptions that could be thrown
      try 
      {
        
        // Set choice equal to Integer value of the String value entered by the user
        choice = Integer.parseInt(input.nextLine());
        
      } // End try block
      
      // catch exception if thrown
      catch (NumberFormatException exception) 
      {
      } // End catch block
      
      
      // If choice made is outside of the menu option range
      if (choice < 0 || choice > 7)
        // Print Error Message
        System.out.println("Invalid choice");
      
    } while (choice < 0 || choice > 7); // End do/while
    
    // Return the choice made by the user to the calling method
    return choice;
    
  } // End method getUserChoice
  
  
  
  
  
  
  
                    /********************************************************
                     *                    METHOD: GETAMOUNT                 *
                     ********************************************************
                     *                                                      *
                     *   Method returns a double value and does not take    *
                     *   any parameters. The method prompts the user for    *
                     *      an amount to be entered, then checked for       *
                     *     validation and then finally returned to the      *
                     *                   calling method.                    *
                     *                                                      *
                     ********************************************************/
  
  
  private static double getAmount() 
  {
    
    // Prompts for amount given by the user
    System.out.print("Enter the amount: $ ");
    
    // Creates a double variable to hold the amount
    double amount = -1;
    
    // Creates a boolean variable for controlling the do/while
    boolean valid = false;
    
    
    do 
    {
      
      // try the following code for exceptions that could be thrown
      try 
      {
        // Set amount equal to the double value input by the user
        amount = Double.parseDouble(input.nextLine());
        
        // Set valid to true
        valid = true;
        
      } // End try block
      
      // catch exceptions if they were thrown 
      catch (NumberFormatException exception) 
      {
        
        // Print error message
        System.out.println("Make sure you enter a valid double!");
        
      } // End catch block 
      
    } while (!valid); // End do/while
    
    
    return amount; // Return the amount input by the user to the calling method
    
  } // End method getAmount
  
  
  
  
  
  
  
                    /********************************************************
                     *              METHOD: GETACCOUNTNUMBER                *
                     ********************************************************
                     *                                                      *
                     *    Method returns an int value and does not take     *
                     *    any parameters. This method prompts the user      *
                     *    for an account number and then validates the      *
                     *    input and then returns the value to the calling   *
                     *                        method.                       *
                     *                                                      *
                     ********************************************************/
  
  
  
  private static int getAccountNumber() 
  {
    // Prompts the user to enter an account number
    System.out.print("Enter the account number: ");
    
    // Creates variable to store the value input by the user
    int amount = -1;
    
    // Creates a boolean variable to store a value for testing the do/while
    boolean valid = false;
    
    do 
    {
      
      // try the following code for exceptions that could be thrown 
      try 
      {
        
        // Set amount equal to the integer value input by the user
        amount = Integer.parseInt(input.nextLine());
        
        // Set valid to true
        valid = true;
        
      } // End try block 
      
      // catch exceptions if they were thrown 
      catch (NumberFormatException exception) 
      {
        
        // Print error message
        System.out.println("Make sure you enter a valid integer!");
        
      } // End catch block 
      
    } while (!valid); // End do/while
    
    return amount; // Return the account number to the calling method
    
  } // End method getAccountNumber
  
  
  
  
  
  
  
                    /********************************************************
                     *                 METHOD: REGISTERCUSTOMER             *
                     ********************************************************
                     *                                                      *
                     *  Method does not return a value and takes and int    *
                     *  parameter. This method allows for a new customer    *
                     *    to be created and added to the current list of    *
                     *    customers and to the Bank holding all accounts.   *
                     *  The information for the customer such as name and   *
                     *     account information will be validated before     *
                     *              creating the new customer.              *
                     *                                                      *
                     ********************************************************/
  
  
  private static void registerCustomer( int listSize )
  {
    
    // These Pattern objects will validate the input given by the user
    
    // This Pattern tests to make sure ID Number will consist only of digits of whole numbers
    final Pattern ID_NUMBER = Pattern.compile( "^[\\d]+$" );
    
    // This Pattern tests to make sure Account Balance will be entered as digits of whole or fraction numbers
    final Pattern ACCOUNT_BALANCE = Pattern.compile( "^[\\d]*[.][\\d]{2}$|^[\\d]*$" );
    
    // This Pattern tests to make sure the Customers Name will consist of appropriate alpha and special characters
    final Pattern LETTERS = Pattern.compile( "^[\\p{Alpha} .'-]+$" );
    
    // This Pattern tests to make sure Account Number will consist of at least 5 digits of whole numbers
    final Pattern ACCOUNT_NUMBER = Pattern.compile( "^[\\d]{5,}$" );
    
    // This Pattern tests to make sure Salary will consist of digits of whole or fraction numbers
    final Pattern SALARY = Pattern.compile( "^[\\d]*[.][\\d]{2}$|^[\\d]*$" );
    
    
    
    // try the following code for exceptions that could be thrown 
    try
    {
      
      // Create String to hold a prepopulated value in the ID GUI field using the passed parameter to create the ID number
      String newId = String.format( "%05d", ++listSize);
      
      // Create String to hold a prepopulated value in the account number GUI field using a random generated number 
      String acctNumber = String.format( "%05d", 
                                        (int)(Math.round( Math.random() * 89999 ) + 10000) );
      
      
      // Create new frame to be used in the GUI window
      JFrame frame = new JFrame();
      
      // Creates new text fields that will be shown in the GUI input window
      // Only the fields for ID and Account Number will be prepopulated
      JTextField field_id = new JTextField( newId );
      JTextField field_firstName = new JTextField();
      JTextField field_lastName = new JTextField();
      JTextField field_accountBal = new JTextField();
      JTextField field_accountNumber = new JTextField( acctNumber );
      JTextField field_salary = new JTextField();
      
      
      // Creates an array of Objects that will populate the GUI 
      // window to display the prompts to the user
      Object[] message = { "Account ID:", field_id,
        "First Name:", field_firstName,
        "Last Name:", field_lastName,
        "Account Balance:", field_accountBal,
        "Account Number:", field_accountNumber,
        "Salary $:", field_salary };
      
      
      // An int variable is created to hold the value of the option chosen by the user
      // The value will be associated with either the OK button or the CANCEL button
      int option = JOptionPane.showConfirmDialog( frame, message, "Customer Registration", 
                                                 JOptionPane.OK_CANCEL_OPTION);
      
      // If option equals the OK button in the GUI window....
      if( option == JOptionPane.OK_OPTION)
      {
        
        // Create String variables to hold the values input by the user
        // for each section of the customer's account information
        String id = field_id.getText();
        String fName = field_firstName.getText();
        String lName = field_lastName.getText();
        String acctBal = field_accountBal.getText();
        String acctNum = field_accountNumber.getText();
        String salary = field_salary.getText();
        
        
        // If id does not match the Pattern in ID_NUMBER
        if( !(ID_NUMBER.matcher( id ).matches() ) )
        {
          
          // throw new exception notifying user of the reason 
          throw new IllegalArgumentException( "Invalid ID number" ); 
          
        }
        
        // Or if first name does not match the Pattern in LETTERS
        else if( !(LETTERS.matcher( fName ).matches() ) )
        {
          
          // throw new exception notifying the user of the reason 
          throw new IllegalArgumentException( "Invalid First Name Entry" );
          
        } 
        
        // Or if last name does not match the Pattern in LETTERS
        else if( !(LETTERS.matcher( lName ).matches() ) )
        {
          
          // throw new exception notifying the user of the reason
          throw new IllegalArgumentException( "Invalid Last Name Entry" );
        } 
        
        // Or if acctBal does not match the Pattern in ACCOUNT_BALANCE
        else if( !(ACCOUNT_BALANCE.matcher( acctBal ).matches() ) )
        {
          
          // throw new exception notifying the user of the reason
          throw new IllegalArgumentException( "Invalid Balance Format"
                                               + "\nEnter balance in the format of a whole number"
                                               + "\nor a whole number followed by a decimal and the number of cents" );
          
        } 
        
        // Or if acctNum does not match the Pattern in ACCOUNT_NUMBER
        else if( !(ACCOUNT_NUMBER.matcher( acctNum ).matches() ) )
        {
          
          // throw new exception notifying user of the reason 
          throw new IllegalArgumentException( "Invalid Account Number" );
          
        } 
        
        // Or if salary does not match the Pattern in SALARY
        else if( !(SALARY.matcher( salary ).matches() ) )
        {
          
          // throw new exception notifying the user of the reason 
          throw new IllegalArgumentException( "Invalid Salary Format"
                                               + "\nEnter balance in the format of a whole number"
                                               + "\nor a whole number followed by a decimal and the number of cents" ); 
          
        }
        
        
        
        
        
        /************* IF DATA PASSES ALL THE VALIDATION TESTS*****************/
        
        
        
        // Parses the string values of all digits to either integers or doubles
        // as appropriate for each field type
        int idNumber = Integer.parseInt( id );
        double balance = Double.parseDouble( acctBal );
        int accountNumber = Integer.parseInt( acctNum );
        double acctSalary = Double.parseDouble( salary );
        
        
        // Create new Customer object passing the values input by user as the 
        // arguments to the constructor
        Customer registeredCustomer = new Customer( fName, lName, idNumber, 
                                                   balance, accountNumber, acctSalary );
        
        // Use information from the new customer to create a new BankAccount that will 
        // be added to the other accounts in the Bank
        bank.add( registeredCustomer.getBankAccount() );
        
        
        // Add the the new Customer to the customerList 
        customerList.setCustomer( registeredCustomer );
        
        
        // Show confirmation window that the account was successfully created
        JOptionPane.showMessageDialog( frame, "Account Successfully Registered", "Registration Successful",
                                      JOptionPane.INFORMATION_MESSAGE );
        
      }
      
      
      // Otherwise if the cancel option was selected
      else 
      {
        
        // Show message in window that the registration was cancelled
        JOptionPane.showMessageDialog( frame, "Customer Registration Cancelled", "Registration Cancelled",
                                      JOptionPane.ERROR_MESSAGE );
        
      } // End if/else 
      
      
      
    } // End try block
    
    
    
    // catch the exceptions that could have been thrown in the previous code
    catch( IllegalArgumentException illegalArgumentException)
    {
      
      // Display the error message in a GUI window 
      JOptionPane.showMessageDialog( null, illegalArgumentException.getMessage(), 
                                    "Invalid Data", JOptionPane.ERROR_MESSAGE );
      
      
    } // End catch block
    
  } // End method registerCustomer
  
} // End Application class BankApp
