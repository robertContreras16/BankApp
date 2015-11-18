

/********************************************************
 *                  CLASS BANKACCOUNT                   *
 ********************************************************
 * The BankAccount class contains 2 instance variables
 * and a constructor. The class has 5 methods which 
 * allow funds to be deposited and withdrawn, retrieval 
 * of the account's number and balance, and a method
 * to display the account's information in a String
 * representation. 
 * 
 * This class allows for a BankAccount object to be
 * created for storing account information that will 
 * be held in the Bank class. 
 */


public class BankAccount 
{
  
  
  
  /********************************************************
   *                  CLASS VARIABLES                     *
   ********************************************************/
  
  // Double value used to store the balance held in an account
  private Double balance;
  // Integer value used to store the account number of an account
  private Integer accountNumber;
  
  
  
  
  
  
  
  /*************************************************************************
   *                             CONSTRUCTOR                               *
   *************************************************************************
   *                                                                       *
   *    The constructor takes two parameters of type Double and Integer.   *
   *    The parameters will be tested for validation and finally set to    *
   *     the instance variable values if they satisfy validation.          *
   *                                                                       *
   *************************************************************************/
  
  
  public BankAccount(Double initialBalance, Integer accountNumber) 
  {
    // Try following code for exceptions thrown
    try
    {
      
      // If initialBalance is less than zero
      if( initialBalance < 0.0 )
      {
        
        // Throw exception notifying user that balance cannot initially be less than zero
        throw new IllegalArgumentException( "Initial account balance can not be less than 0!" );
      }
      
      // Otherwise if initialBalance is valid, but accountNumber is less than 5 digits
      else if( accountNumber.toString().length() < 5)
      {
        
        // Throw exception notifying user that account number cannot be less than 5 digits
        throw new IllegalArgumentException( "Account number can not be less than 5 digits!" );
      }
      
      // Otherwise if both tests are valid
      else
      {
        // Set parameter values as the instance variable values
        balance = initialBalance;
        this.accountNumber = accountNumber;
      }
      
    } // End try block 
    
    // Catch thrown exceptions
    catch( IllegalArgumentException illegalArgumentException )
    {
      // Display message of caught exception
      illegalArgumentException.getMessage();
    } // End catch block 
    
  } // End constructor
    
    
  
  
  
  
  
                    /********************************************************
                     *                    METHOD: DEPOSIT                   *
                     ********************************************************
                     *                                                      *
                     *    This method does not return a value and accepts   *
                     *      a double value that is used to increase the     *
                     *         account balance by the amount passed.        *
                     *                                                      *
                     ********************************************************/
  
  
  
    public void deposit(double amount) 
    {
      
      // If amount passed is less than zero
      if (amount < 0) 
      {
        
        // Throw new exception notifying user to use positive numbers for deposit values
        throw new IllegalArgumentException(
                                           "Don't deposit negative amounts!");
      }
      
      // If amount is postive add amount to existing balance
      balance = balance + amount;
      
    } // End method deposit
    
    
    
    
    
    
    
    
                    /********************************************************
                     *                   METHOD: WITHDRAW                   *
                     ********************************************************
                     *                                                      *
                     *    This method does not return a value and takes a   *
                     *      double parameter that is used to decrease the   *
                     *        account's balance by the amount passed.       *
                     *                                                      *
                     ********************************************************/
    
    
    
    public void withdraw(double amount) throws InsufficientFundsException
    {
      
      
      // If amount is less than zero...
      if( amount < 0 )
      {
        
        // Throw exception notifying user that withdrawal amounts cannot be negative
        throw new IllegalArgumentException( "Withdrawal amount can not be less than 0!" ); 
      }
      
      // And if amount to be withdrawn is greater than available balance...
      else if ( amount > getBalance() )
      {
        
        // Throw InsufficientFundsException
        throw new InsufficientFundsException();
        
      }
      
      // If value of amount is valid then decrease account balance by the amount passed
      balance = balance - amount;
      
    } // End method withdraw
    
    
    
    
    
    
    
    
    
                    /********************************************************
                     *                 METHOD: GETBALANCE                   *
                     ********************************************************
                     * This method returns the Double value of the instance's
                     * account balance. It takes no parameters
                     */
    
    public final Double getBalance()
    {
      return balance;
    } // End method getBalance
    
    
    
    
    
    
                    /********************************************************
                     *               METHOD: GETACCOUNTNUMBER               *
                     ********************************************************
                     * This method returns the Integer value of the instance's
                     * account number. It takes no parameters
                     */
    
    public final Integer getAccountNumber()
    {
      return accountNumber;
    } // End method getAccountNumber
    
    
    
    
                    /********************************************************
                     *                   METHOD: TOSTRING                   *
                     ********************************************************
                     *                                                      *
                     *     Method returns a String representation of the    *
                     *    account's information, and takes no parameters.   *
                     *                                                      *
                     ********************************************************/
    
    
    
    public final String toString()
    {
      
      return String.format( "%nAccount Number: %d"
                             +"%nAccount Balance: $%,.2f",
                           getAccountNumber(), getBalance() );
      
    } // End method toString
    
    
    
    
    
    
    
    
                    /********************************************************
                     *                METHOD: GETBANKACCOUNT                *
                     ********************************************************
                     *                                                      *
                     *   Method returns a BankAccount object and takes an   *
                     *   Integer parameter. The method returns the object   *
                     *                   of this instance.                  *
                     *                                                      *
                     ********************************************************/
    
    
    public BankAccount getBankAccount(Integer accountNumber) 
    {
      return this;
    } // End method getBankAccount
    
    
  } // End class BankAccount
