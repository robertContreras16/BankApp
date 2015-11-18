//********************************************************************************
//REMEMBER TO UPDATE YOUR STUDENT CREDENTIALS BEFORE SUBMITTING ONLINE
//********************************************************************************
// Student Name:      Robert Contreras
// Program Name:      Customer Class
// Date:              11/11/2015
// Class and Section: IS 2041 Sec # 001

// Import Date class for use in setting dates of birth
import java.util.Date;



/********************************************************
 *                  CLASS CUSTOMER                      *
 ********************************************************
 * This class contains 5 instance variables with the 
 * appropriate sets and gets for each variable. There are
 * 4 constructors that take different parameters for
 * creating Customer objects. Included is 1 toString
 * method to give a String representation of a Customer's
 * account information.
 * 
 * This class provides the framework for creating a 
 * Customer object.
 */

public class Customer extends Student 
{
  
  
  
  /********************************************************
   *                  CLASS VARIABLES                     *
   ********************************************************/
  
  
  
  // An Integer variable for storing the Customer's ID number
  private Integer id;
  
  // A Double variable for storing the dollar amount in the Customer's account
  private Double balance;
  
  // An Integer variable for storing the Customer's account number
  private Integer accountNumber;
  
  // A Double variable for storing the Customer's salary as a dollar amount
  private Double salary;
  
  // A BankAccount object variable that will be used to tie
  // this Customer to a BankAccount. That account will be added to the Bank
  private BankAccount account;
  
  
  
  
  
  
  
  /********************************************************
   *                     CONSTRUCTORS                     *
   ********************************************************/
  
  
  
                    /********************************************************
                     *                   CONSTRUCTOR ONE                    *
                     ********************************************************
                     *                                                      *
                     *  This constructor takes parameters just for the id,  *
                     *     balance, accountNumber, and salary instance      *
                     *   variables. A call to the BankAccount constructor   *
                     *   is made to create a BankAccount object that will   *
                     *    be tied to this Customer using the balance and    *
                     *   accountNumber that is set through this parameter   *
                     *                        list.                         *
                     *                                                      *
                     ********************************************************/
  
  
  public Customer( Integer id, Double balance, 
                  Integer accountNumber, Double salary )
  {
    setId(id);
    setBalance(balance);
    setAccountNumber(accountNumber);
    setSalary(salary);
    // Uses the values retrieved from the get methods to create 
    // a BankAccount object for this Customer
    account = new BankAccount( getBalance(), getAccountNumber() );
    
  } // End constructor 
  
  
  
                    /********************************************************
                     *                   CONSTRUCTOR TWO                    *
                     ********************************************************
                     *                                                      *
                     *    This constructor takes parameters for the super-  *
                     *    class instance variables firstName and lastName   *
                     *     and the id, balance, accountNumber, and salary   *
                     *    instance variables of this class. A call to the   *
                     *       BankAccount constructor is made to create a    *
                     *       BankAccount object that will be tied to this   *
                     *   Customer using the balance and accountNumber that  *
                     *         is set through this parameter list.          *
                     *                                                      *
                     ********************************************************/
  
  
  public Customer( String firstName, String lastName, Integer id, 
                  Double balance, Integer accountNumber, Double salary )
  {
    super( firstName, lastName );
    
    setId(id);
    setBalance(balance);
    setAccountNumber(accountNumber);
    setSalary(salary);
    // Uses the values retrieved from the get methods to create 
    // a BankAccount object for this Customer
    account = new BankAccount( getBalance(), getAccountNumber() );
    
  } // End constructor
  
  
  
                    /********************************************************
                     *                 CONSTRUCTOR THREE                    *
                     ********************************************************
                     *                                                      *
                     *   This constructor takes parameters for the super-   *
                     *     class instance variables firstName, lastName     * 
                     *   major, classification, birthDay, tel and the id,   *
                     *   balance, accountNumber, and salary instance        *
                     *  variables of this class. A call to the BankAccount  *
                     *  constructor is made to create a BankAccount object  *
                     *     that will be tied to this Customer using the     *
                     *  balance and accountNumber that is set through this  *
                     *                    parameter list.                   *
                     *                                                      *
                     ********************************************************/
  
  
  public Customer( String firstName, String lastName, String major, 
                  String classification, Date birthDay, String tel, 
                  Integer id, Double balance, Integer accountNumber, 
                  Double salary)
  {
    super( firstName, lastName, major, 
          classification, birthDay, tel );
    
    setId(id);
    setBalance(balance);
    setAccountNumber(accountNumber);
    setSalary(salary);
    // Uses the values retrieved from the get methods to create 
    // a BankAccount object for this Customer
    account = new BankAccount( getBalance(), getAccountNumber() );
    
  } // End constructor
  
  
  
                    /********************************************************
                     *                  CONSTRUCTOR FOUR                    *
                     ********************************************************
                     *                                                      *
                     *  This constructor takes parameters just for the id,  *
                     *  balance, accountNumber, salary and account instance *
                     *   variables. The BankAccount will be set for this    *
                     *     constructor by calling the set method for the    *
                     *            BankAccount of this class.                *
                     *                                                      *
                     ********************************************************/
  
  
  public Customer( String firstName, String lastName, Integer id, 
                  Double balance, Integer accountNumber, Double salary, BankAccount account)
  {
    super( firstName, lastName );
    
    setId(id);
    setBalance(balance);
    setAccountNumber(accountNumber);
    setSalary(salary);
    setBankAccount(account);
    
  }
  
  
  
  
  
  /*****************************************************************************************
   *                                    SET METHODS                                        *
   *****************************************************************************************
   * The following methods follow similar structure. The receive the appropriate type of
   * parameter that corresponds to the related instance variable. They return no values. 
   * The value passed to this method will be set as the value for the instance variable 
   * associated with it.
   */ 
  
  
  public final void setId( Integer id )
  {
    
    this.id = id;
    
  } // End method setId
  
  public final void setBalance( Double balance )
  {
    if( balance < 0.0 )
      throw new IllegalArgumentException( "Balance can not be less than 0!" );
    else
      this.balance = balance;
    
  } // End method setBalance
  
  public final void setAccountNumber( Integer accountNumber )
  {
    if( accountNumber.toString().length() < 5 )
      throw new IllegalArgumentException( "Account number can not be less than 5 digits!" );
    else
      this.accountNumber = accountNumber;
    
  } // End method setAccountNumber
  
  public final void setSalary( Double salary )
  {
    
    this.salary = salary;
    
  } // End method setSalary
  
  public final void setBankAccount( BankAccount account )
  {
    
    this.account = account;
    
  } // End method setBankAccount
  
  
  
  
  
  
  /*****************************************************************************************
   *                                    GET METHODS                                        *
   *****************************************************************************************
   * The following get methods follow similar structure. They receive no parameters and
   * return the value associated with it's instance variable. 
   */
  
  public final Integer getId()
  {
    
    return id;
    
  } // End method getId
  
  public final Double getBalance()
  {
    
    return balance;
    
  } // End method getBalance
  
  public final Integer getAccountNumber()
  {
    
    return accountNumber;
    
  } // End method getAccountNumber
  
  public final Double getSalary()
  {
    
    return salary;
    
  } // End method getSalary
  
  public final BankAccount getBankAccount()
  {
    
    return account;
    
  } // End method getBankAccount
  
  
  
                    /********************************************************
                     *                   METHOD: TOSTRING                   *
                     ********************************************************
                     *                                                      *
                     *     Method returns a String representation of the    *
                     *    customer's information, and takes no parameters.  *
                     *                                                      *
                     ********************************************************/
  
  
  
  public final String toString()
  {
    return String.format( "%s"
                           +"%nAccount Number: %d"
                           +"%nAccount Balance: $%,.2f"
                           +"%nSalary: $%,.2f%n",
                         studentName(), getAccountNumber(),
                         getBalance(), getSalary() );
    
  } // End method toString

  
} // End class Customer
