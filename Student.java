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
public class Student extends Person
{
    
    
    private static int idCounter = 1;//Counter For ID
    private double GPA;
    public ArrayList <Teacher> teachersList = new ArrayList();
    
    //Parameterized Constructor
    public Student(double GPA, String firstName, String lastName, String phoneNumber, String email)
    {
        super(firstName, lastName, phoneNumber, email);
        this.GPA = GPA;
        this.ID = idCounter ++;
    }

    public double getGPA() 
    {
        return GPA;
    }
    
    //Method to add Teacher to Teachers List of this Student
    public void addTeacher(Teacher t)
    {
        this.teachersList.add(t);
    }
    
    @Override
    public void printAll()
    {
        System.out.println(this.firstName+" "+this.lastName+"\t"+
                this.phoneNumber+"\t"+this.email+"\t"+this.getGPA());
    
    }


    
}//End of the class
