/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sa.edu.uqu.education;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author jmkd-
 */
public class University
{
     
    static Scanner input = new Scanner(System.in);
    static ArrayList<Teacher> allTeachers = new ArrayList();
    static ArrayList<Student> allStudents = new ArrayList();
    
    private static void addTeacher()
    {
        try
        {
            System.out.println("Enter Teacher First Name: ");
            String firstName = input.next();
            System.out.println("Enter Teacher Last Name: ");
            String lastName = input.next();
            System.out.println("Enter Teacher Mobile Phone Number: ");
            String phoneNumber = input.next();
            System.out.println("Enter Teacher Email Address: ");
            String email = input.next();
            System.out.println("Enter Teacher Salary: ");
            double salary = input.nextDouble();
            //Initialize using Constructor
            Teacher t = new Teacher(salary, firstName, lastName, phoneNumber, email);
            System.out.println("New Teacher has been added successfully");
            allTeachers.add(t);//add the object to all teachers List          
        }
        catch (Exception e)
        {
            System.out.println("Invalid input...");
        }//end of try catch
    }//end of method
    
    public static void validateGPA(double GPA) throws InvalidGPAException
    {
        if (GPA > 4.00 || GPA < 0)
            throw new InvalidGPAException("Invalid student GPA. A valid GPA " +
"value should be in the 0.0 to 4.0 range!");

    }
    
    private static void addStudent() throws InvalidGPAException
    {
  //      try
      //  {
            System.out.println("Enter Student First Name: ");
            String firstName = input.next();
            System.out.println("Enter Student Last Name: ");
            String lastName = input.next();
            System.out.println("Enter Student Mobile Phone Number: ");
            String phoneNumber = input.next();
            System.out.println("Enter Student Email Address: ");
            String email = input.next();
            System.out.println("Enter Student GPA: ");
            double GPA = input.nextDouble();
            validateGPA(GPA); //chech if the GPA is in the range

            //Initialize using Constructor
            Student s = new Student(GPA, firstName, lastName, phoneNumber, email);
            System.out.println("New Student has been added successfully");
            allStudents.add(s);//add the object to all students list
     //   }
    //    catch (Exception e)
     //   {
    //        System.out.println("Invalid value....");
     //   }//end of try catch
    }//end of method
    
    //Method to Search and return the teacher that own the ID
    private static Teacher findTeacherByID(int ID)
    {
        for (Teacher t: allTeachers )
        {
            if (ID == t.getID())
                return t;
        }
        return null;
    }
    
    //Method to Search and return the Student that own the ID
    private static Student findStudentByID(int ID)
    {
        for(Student s : allStudents)
        {
            if (ID == s.getID())
                return s;
        }
        return null;         
    }
    
    //Method to assign student to teacher
    private static void assignStudentToTeacher()
    {
        try
        {   
            System.out.println("Enter The Teacher ID: ");
            int teacherID = input.nextInt();
            Teacher teacher = findTeacherByID(teacherID);
            System.out.println("Enter Student ID: ");
            int studentID = input.nextInt();
            Student student = findStudentByID(studentID);


            if (teacher == null || student == null)
                System.out.println("There is no teacher or student with this ID");
            else{
                teacher.addStudent(student);
                student.addTeacher(teacher);
                System.out.println("Student " + student.getFirstName() + " added to Teacher " + teacher.getFirstName() + " successfully"  );
            }//end of if-else
            
        } 
        catch (Exception e)
        {
            System.out.println("Invalid value....");
        }//end of try catch
    
   }//end of method
    
    private static void printAllTeachers()
    {
        if(allTeachers.isEmpty())
            System.out.println("There is no Teachers.");
        else
        {
            System.out.println("Teacher Name\t|Phone Number\t|Email address\t|Salary");
            for (Teacher t : allTeachers)
                t.printAll();
        }//end of if-else
        
    }//end of method
    
    private static void printAllStudents()
    {
        if(allStudents.isEmpty())
            System.out.println("There is no Students.");
        else
        {
            System.out.println("Student Name\t|Phone Number\t|Email address\t|GPA");
            for (Student s : allStudents)
                s.printAll();
        }//emd of if-else
    }//end of method
    
    //Method to print one student Teachers
    private static void printTeachersOfStudent()
    {
        try
        {           
            System.out.println("Enter the Student ID: ");
            int id = input.nextInt();
            Student stu = findStudentByID(id);
            if (stu == null)
                System.out.println("There is no student with this ID.");
            else
                if(stu.teachersList.isEmpty())
                    System.out.println("There is no Teachers for this student");
                else
                {    
                    System.out.println("Student "+ stu.getFirstName()+ " Teachers:");
                    System.out.println("Name\t\t|Phone Number\t|Email address\t|Salary");
                    for (Teacher t : stu.teachersList)
                        t.printAll();
                }//end of the inner if-else 

        } 
        catch (Exception e)
        {
            System.out.println("Invalid value....");
        }//end of try-catch
    }//end of method
    
    //Method to print one teacher Students
    private static void printStudentsOfTeacher()
    {
        try
        {
            
            System.out.println("Enter the Teacher ID: ");
            int id = input.nextInt();
            Teacher tea = findTeacherByID(id);
            if (tea == null)
                System.out.println("There is no Teacher with this ID.");
            else
                if(tea.studentsList.isEmpty())
                    System.out.println("There is no students fot this Teacher");
                else
                {
                System.out.println("Teacher "+ tea.getFirstName()+ " Students:");
                System.out.println("Name\t\t|Phone Number\t|Email address\t|GPA");
                for (Student s : tea.studentsList)
                    s.printAll();
                }//end of inner if-else

        } 
        catch (Exception e)
        {
            System.out.println("Imvalid value....");
        }//end of try-catch
    }//end of method
    
    //Message Before Exit the program
    public static void exitMsg()
    { 
        System.out.println("Exciting from the program…");
    }
    
    public static void main(String[] args) throws InvalidGPAException
    {
        System.out.println("Abdulmajeed Bakr | 443011939 | Group 4 | s443011939@st.uqu.edu.sa\n"+
                "Alawi Mohammad | 443008495 | Group 4 | s443008495@st.uqu.edu.sa\n");
        
        Teacher t1 = new Teacher(20000, "Amir", "Ahmad", "0557234235", "Amir@gmail.com");
        Teacher t2 = new Teacher(15000, "Mohammad", "Ahmad", "0550550555", "Moah@gmail.com");
        allTeachers.add(t1);
        allTeachers.add(t2);
        Student s1 = new Student(3.9, "ALi", "Jambi", "0553847173", "Alij@gmail.com");
        Student s2 = new Student(3.8, "Mohammed", "Monshi", "0563859365", "Mohmon@gmail.com");
        Student s3 = new Student(4.0, "Sari", "ahmad", "0542836584", "Sari234@gmail.com");
        allStudents.add(s1);
        allStudents.add(s2);
        allStudents.add(s3);
        
       
        while(true)
        {
            System.out.println("Enter 1 to Add a new teacher ");
            System.out.println("Enter 2 to Add a new student ");
            System.out.println("Enter 3 to Assign an existing student to an existing teacher");
            System.out.println("Enter 4 to Print all teachers informations");
            System.out.println("Enter 5 to Print all students informations");
            System.out.println("Enter 6 to Display all teachers information for a certain student");
            System.out.println("Enter 7 to Display all students information for a certain teacher");
            System.out.println("Enter 8 to Exit the program");
            int choice = input.nextInt();
            
            switch (choice)
            {
                case 1:
                    addTeacher();
                break;
                
                case 2:
                    addStudent();
                break;
                
                case 3:
                    assignStudentToTeacher();
                break;
                
                case 4:
                    printAllTeachers();
                break;
                
                case 5:
                    printAllStudents();
                break;
                
                case 6:
                    printTeachersOfStudent();
                break;
                
                case 7:
                    printStudentsOfTeacher();
                break;
                
                case 8:
                    exitMsg();
                return ;
                
                default:
                    System.out.println("Invalid choice value");
            }//end of switch-case

        }//end of while
    
    }//end of main method
    
}//end of class
