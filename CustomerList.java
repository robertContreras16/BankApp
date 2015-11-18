//********************************************************************************
//REMEMBER TO UPDATE YOUR STUDENT CREDENTIALS BEFORE SUBMITTING ONLINE
//********************************************************************************
// Student Name:      Robert Contreras
// Program Name:      CustomerList Class
// Date:              11/11/2015
// Class and Section: IS 2041 Sec # 001

// Import Class ArrayList for use in storing a Collection
import java.util.ArrayList;

// Import NoSuckElementException class to be in used and thrown in this class
import java.util.NoSuchElementException;



 /********************************************************
  *                 CLASS CUSTOMERLIST                   *
  ********************************************************
  * This class contains 1 instance variable with methods
  * for retrieving a single customer from the list or 
  * the whole list. A method to add a new 
  * customer to the current list is also available and 
  * to print the information contained in the list. 
  * 
  * This class contains the framework to create a
  * CustomerList object. 
  */

public class CustomerList 
{
  
  
   /********************************************************
    *                  CLASS VARIABLES                     *
    ********************************************************/
  
  // Declaration of ArrayList of type Customer to store the Collection of Customers
  ArrayList<Customer> customerList;
  
  
  
  
  
   /********************************************************
    *                     CONSTRUCTORS                     *
    ********************************************************/
  
  
   /********************************************************
    *                   CONSTRUCTOR ONE                    *
    ********************************************************
    *                                                      *
    *     This constructor takes an ArrayList of type      *
    *    Customer as its parameter and sets the passed     *
    *        list as the instance variable list.           *
    *                                                      *
    ********************************************************/
  
  
  public CustomerList(ArrayList<Customer> newCustomerList)
  {
    
    this.customerList = newCustomerList;
  } // End constructor
  
  
  
  
   /********************************************************
    *                   CONSTRUCTOR TWO                    *
    ********************************************************
    *                                                      *
    *  This constructor takes a single Customer as its     *
    *  parameter and adds it to the the instance variable  *
    *                          list.                       *
    *                                                      *
    ********************************************************/
  
  public CustomerList(Customer newCustomer)
  {
    
    this.customerList.add(newCustomer);
  } // End constructor 
  
  
  
   /********************************************************
    *                 METHOD: GETCUSTOMERS                 *
    ********************************************************
    *                                                      *
    *   This method takes no parameters and returns the    * 
    *   ArrayList of customers in this objects instance.   *
    *                                                      *
    ********************************************************/
  
  public ArrayList getCustomers()
  {
    return customerList;
  } // End getCustomers
  
  
  
  
   /********************************************************
    *                 METHOD: GETCUSTOMER                 *
    ********************************************************
    *                                                      *
    *  This method returns a Customer and takes a Customer *
    *     parameter. The method will check to see if the   *
    *     customer is in the customer list and if so will  *
    *      return that customer otherwise will throw an    *
    *                     exception.                       *
    *                                                      *
    ********************************************************/
  
  
  public Customer getCustomer(Customer customer)
  {
    
      // If the customer passed is in the customer list...
      if( customerList.contains( customer ) )
      {
        // Return the customer
        return customer;
      }
      // Otherwise
      else
      {
        // throw an exception notifying the user the customer does not exist in this list
        throw new NoSuchElementException( "That customer does not exist!" );
      }
  } // End getCustomer
  
  
  
  
   /********************************************************
    *                 METHOD: SETCUSTOMER                 *
    ********************************************************
    *                                                      *
    *    This method does not return a value but takes a   *
    *    parameter of type Customer. The method checks to  *
    *      see if the passed Customer is already in the    *
    *       customerList. It throws an exception if the    *
    *    customer is in the list and adds the customer to  *
    *               the list if it is not.                 *
    *                                                      *
    ********************************************************/
  

  public void setCustomer(Customer customer)
  {
    // if passed Customer is in the customerList...
    if( customerList.contains( customer ) )
      
      // throw exception notifying user that customer is already in the list
      throw new IllegalArgumentException( "Customer already registered" );
    
    // Otherwise...
    else
      
      // Add the passed Customer to the customerList
      customerList.add ( customer );
    
  } // End setCustomer
  
  
  
  
  
   /********************************************************
    *                  METHOD: TOSTRING                    *
    ********************************************************
    *                                                      *
    *   This method returns a String and takes no values   *
    *     in the parameter. The method return a String     *
    *    representation of the Customers in the list of    *
    *        customers for this object's instance.         *
    *                                                      *
    ********************************************************/
  
  
  public String toString()
  {
    String header = "\n************************************"
      + "\n******   LIST OF CUSTOMERS   *******"
      + "\n************************************";
    
    for (Customer customers : customerList)
    {
      
      header = header + "\n" + customers;
      
    } // End enhanced for
    
    return header;
    
  } // End toString
  
} // End class CustomerList