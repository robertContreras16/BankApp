// Import DateFormat class for use with SimpleDateFormat
import java.text.DateFormat;

// Import SimpleDateFormat to format dates in a specific locale
import java.text.SimpleDateFormat;

// Import Date class for use in creating Date object type variables
import java.util.Date;




/********************************************************
 *                     CLASS STUDENT                    *
 ********************************************************
 * 
 * The class serves as the superclass for the Customer
 * class. It contains 6 instance variables as well as 
 * appropriate set and get methods for each variable. 
 * There are 3 constructors and 2 other methods for
 * displaying the Student's information. 
 * 
 * This class provides the framework needed to create 
 * a Student object.
 */

public class Student
{
  
  
  
  /********************************************************
   *                  CLASS VARIABLES                     *
   ********************************************************/
  
  // String variable to hold the Student's first name
  private String firstName;
  
  // String variable to hold the Student's last name 
  private String lastName;
  
  // String variable to hold the Student's declared major 
  private String major;
  
  // Date variable to hold the Student's date of birth 
  private Date birthDay;
  
  // String variable to hold the Student's classification
  // such as Freshman or Senior
  private String classification;
  
  // String variable to hold the Student's phone number
  private String tel;
  
  
  /********************************************************
   *                     CONSTRUCTORS                     *
   ********************************************************/
  
  
  public Student()
  {
    // null constructor
  } // End constructor
  
  
                    /********************************************************
                     *                   CONSTRUCTOR TWO                    *
                     ********************************************************
                     *                                                      *
                     *     This constructor takes parameters for all the    *
                     *    instance variables of this class. It passes the   *
                     *    parameters as arguments to their respective set   *
                     *     methods to instantiate the instance variables.   *
                     *                                                      *
                     ********************************************************/
  
  
  public Student(String firstName, String lastName, String major, String classification, Date birthDay, String tel) 
  {
    setFirstName(firstName);
    setLastName(lastName);
    setMajor(major);
    setClassification(classification);
    setBirthDay(birthDay);
    setTel(tel);
  }
  
  
                    /********************************************************
                     *                 CONSTRUCTOR THREE                    *
                     ********************************************************
                     *                                                      *
                     *    This constructor takes parameters just for the    *
                     *   first and last name of the Student and passes the  *
                     *   parameters as arguments to the set methods. These  *
                     *    will set the appropriate values to the instance   *
                     *                       variables.                     *
                     *                                                      *
                     ********************************************************/
  
  
  public Student( String firstName, String lastName )
  {
    setFirstName(firstName);
    setLastName(lastName);
  } // End constructor
  
  
  
  /*****************************************************************************************
   *                                  SET & GET METHODS                                    *
   *****************************************************************************************
   * The following methods will set and get the values in the instance variables. The get
   * methods all return the appropriate value for the return type. The set methods will 
   * not return values and take parameters appropriate for the value they are setting. 
   * The passed arguments will be set as the instance variable values. 
   */
  
  public String getFirstName() 
  {
    return firstName;
  } 
  
  public void setFirstName(String firstName) 
  {
    this.firstName = firstName;
  }
  
  public String getLastName() 
  {
    return lastName;
  }
  
  public void setLastName(String lastName) 
  {
    this.lastName = lastName;
  }
  
  public String getMajor() 
  {
    return major;
  }
  
  public void setMajor(String major) 
  {
    this.major = major;
  }
  
  public String getClassification() 
  {
    return classification;
  }
  
  public void setClassification(String classification) 
  {
    this.classification = classification;
  }
  
  public Date getBirthDay() 
  {
    return birthDay;
  }
  
  public void setBirthDay(Date birthDay) 
  {
    this.birthDay = birthDay;
  }
  
  public String getTel() 
  {
    return tel;
  }
  
  public void setTel(String tel) 
  {
    this.tel = tel;
  }
  
  
  
  
  
  
  
                    /********************************************************
                     *                   METHOD: TOSTRING                   *
                     ********************************************************
                     *                                                      *
                     *     Method returns a String representation of the    *
                     *    student's information, and takes no parameters.   *
                     *                                                      *
                     ********************************************************/
  
  
  
  public String toString() 
  {
    
    return String.format("%s %s with major %s and classification %s has birthday %s and telephone number %s",
                         lastName, firstName, major, classification, birthDay, tel);
  } // End method toString
  
  
  
  
                    /********************************************************
                     *                METHOD: STUDENTNAME                   *
                     ********************************************************
                     *                                                      *
                     *     Method returns a formatted form of just the      *
                     *           Student's first and last name.             *
                     *                                                      *
                     ********************************************************/
  
  
  public String studentName()
  {
    return String.format( "%nFirst Name: %s"
                         +"%nLast Name: %s",
                         getFirstName(), getLastName() );
  } // End method studentName
  
  
  
                    /********************************************************
                     *                    METHOD: DETAILS                   *
                     ********************************************************
                     *                                                      *
                     *   Method returns a formatted String representation   *
                     *      of the account's information, and takes no      *
                     *                     parameters.                      *
                     *                                                      *
                     ********************************************************/
  
  public String details() 
  {
    DateFormat formatter = new SimpleDateFormat("MMM-dd-yyyy");
    
    return
      "\nFirst Name: " + getFirstName() +
      "\nLast Name: " + getLastName() +
      "\nMajor: " + getMajor() +
      "\nClassification: " + getClassification() +
      "\nBirth Day: " + formatter.format(getBirthDay()) +
      "\nTel No.: " + getTel() ;
  } // End method details
  
  
} // End class Student