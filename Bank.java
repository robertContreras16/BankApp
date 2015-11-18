
import java.util.*;


/********************************************************
 *                     CLASS BANK                       *
 ********************************************************
 * The Bank class contains 2 instance variables, a 
 * constructor. It also contains 3 methods to add an 
 * account, find an account and display account 
 * information. 
 * 
 * This class contains the framework needed to create a 
 * Bank object that can be used to store bank accounts.
 */

public class Bank 
{
  
  
  
  /********************************************************
   *                  CLASS VARIABLES                     *
   ********************************************************/
  
  
  //The HashMap of BankAccount objects
  private Map<Integer, BankAccount> BankAccounts = new HashMap<Integer, BankAccount>();
  
  //The number of Accounts allowed in the Bank
  private Integer NUMBER_OF_ACCOUNTS = 0;
  
  
  
  /*************************************************************************
   *                             CONSTRUCTOR                               *
   *************************************************************************
   *                                                                       *
   *    The constructor takes an Integer parameter that sets that to       *
   *    maximum number of accounts allowed in the bank.                    *
   *                                                                       *
   *************************************************************************/
  
  
  //Creates a bank that can have up to numAccounts accounts.
  public Bank(Integer numAccounts) 
  {
    NUMBER_OF_ACCOUNTS = numAccounts;
  } // End constructor
  
  
  
  
  
                    /********************************************************
                     *                    METHOD: ADD                       *
                     ********************************************************
                     *                                                      *
                     *   This method does not return a value and takes a    *
                     *   BankAccount parameter that is added to the bank    *
                     *   so long as the bank does not contain the maximum   *
                     *   number of accounts allowed.                        *
                     *                                                      *
                     ********************************************************/
  
  
  // Adds the given BankAccount to the bank. If the bank is full
  public void add(BankAccount bankAccount) 
  {
    
    // If the max number of accounts allowed exists...
    if (BankAccounts.size() == NUMBER_OF_ACCOUNTS) {
      
      // Throw exception notifying user that bank is full
      throw new IllegalArgumentException("Bank is full. No account can be added.");
    }
    
    // Otherwise...
    else
    {
      // Add the passed account to the Bank
      BankAccounts.put(bankAccount.getAccountNumber(), bankAccount);
    }
    
  } // End method add
  
  
                    /********************************************************
                     *                    METHOD: FIND                      *
                     ********************************************************
                     *                                                      *
                     *   This method returns a BankAccount and takes an     *
                     *   Integer parameter. The passed parameter is used    *
                     *   as the key to see if the account is within this    *
                     *   particular Bank. If so the account number is       *
                     *   returned, otherwise an exception will be thrown.   *
                     *                                                      *
                     ********************************************************/
  
  
  // Returns the bank account with the given account number.
  // Throw the specified error if no such account exist
  public BankAccount find(Integer acctNumber) 
  {
    
    // If the Map contains the key with the associated acctNumber
    if(BankAccounts.containsKey(acctNumber))
    {
      // Return the acctNumber from the Map
      return BankAccounts.get(acctNumber);
    }
    
    // Otherwise 
    else 
    {
      
      // Throw an exception notifying user that account is not in this Bank
      throw new NoSuchElementException("There is no such account in this Bank!");
    }
    
  } // End method find
  
  
  
  
                    /********************************************************
                     *                   METHOD: TOSTRING                   *
                     ********************************************************
                     *                                                      *
                     *  This method returns a String value and does not     *
                     *  take any parameters. The method will return a       *
                     *  String representation of the accounts contained in  *
                     *  this class's Map using a foreach loop.              *
                     *                                                      *
                     ********************************************************/
  
  
  public String toString() 
  {
    
    // Declares and initializes the header to be displayed
    String header =
      "\n************************************\n" +
      "******     BANK ACCOUNTS     *******\n" +
      "************************************\n" ;
    
    // Declares a String that will be used to store the account's information
    String body = "";
    
    // Foreach loop to cycle through the Map's entries 
    for(Map.Entry<Integer, BankAccount> entry : BankAccounts.entrySet()) 
    {
      
      // For each entry in the Map, display it's account number and balance
      body = String.format( "%nAccount Number: %d"
                        +"%nAccount Balance: $%,.2f%n",
                        entry.getKey(), entry.getValue().getBalance() );
      
      // Concatenates the String's to include the header and each iteration of the loop
      header = header + body;
    }
    
    // Return display to be viewed
    return header;
    
    
  } // End method toString
  
} // End class Bank
