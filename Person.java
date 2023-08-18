/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sa.edu.uqu.education;

/**
 *
 * @author jmkd-
 */
public abstract class Person 
{
    protected String firstName;
    protected String lastName;
    protected String phoneNumber;
    protected String email;
    protected int ID;

    
    public Person()
    {
    }

    public Person(String firstName, String lastName, String phoneNumber, String email)
    {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }//End of Constructor
    
    public int getID()
    {
        return ID;
    }

    public String getFirstName() 
    {
        return firstName;
    }

    public String getLastName() 
    {
        return lastName;
    }

    public String getPhoneNumber() 
    {
        return phoneNumber;
    }

    public String getEmail() 
    {
        return email;
    }
    
    //Method to print all the details in good form
    public abstract void printAll();
    
    
}//End of class
