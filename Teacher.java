/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sa.edu.uqu.education;

import java.util.ArrayList;

/**
 *
 * @author jmkd-
 */
public class Teacher extends Person 
{
    
    
    private static int idCounter = 1;//Counter For ID
    private double salary;
    public ArrayList <Student> studentsList = new ArrayList();

    //Parameterized Constructor
    public Teacher(double salary, String firstName, String lastName, String phoneNumber, String email)
    {
        super(firstName, lastName, phoneNumber, email);
        this.salary = salary;
        this.ID = idCounter ++;
    }
    
    public double getSalary()
    {
        return salary;
    }
    
    //Method to add Student to Students List for this teacher
    public void addStudent(Student s)
    {
        this.studentsList.add(s);
    }
    
    @Override
    public void printAll()
    {
        System.out.println(this.firstName+" "+this.lastName+"\t"+
                this.phoneNumber+"\t"+this.email+"\t"+this.getSalary());
    
    }
    
}//end of class
