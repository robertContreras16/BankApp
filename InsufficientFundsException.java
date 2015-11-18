// Student Name:      Robert Contreras
// Program Name:      InsufficientFundsException Class
// Date:              11/11/2015
// Class and Section: IS 2041 Sec # 001



/********************************************************
 *          CLASS INSUFFICIENTFUNDSEXCEPTION            *
 ********************************************************
 * 
 * The class extends Exception to inherit it's methods.
 * It also provides the foundation to be able to create
 * and throw exceptions of the type InsufficientFunds.
 * 
 */

public class InsufficientFundsException extends Exception
{
  
  
  /********************************************************
   *                     CONSTRUCTORS                     *
   ********************************************************/
  
  
  public InsufficientFundsException()
  {
    // Empty parameter constructor provides an explicit message
    super("Withdrawal amount was greater than the balance in the account!");
  }// End constructor
  
  public InsufficientFundsException(String message)
  {
    // String parameter constructor displays passed message
    super(message);
  } // End overloaded constructor
  
  
} // End class InsufficientFundsException