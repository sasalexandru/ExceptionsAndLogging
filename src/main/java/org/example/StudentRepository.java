package org.example;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.ArrayList;
import java.util.List;

public class StudentRepository {
    static final Logger LOGGER = LogManager.getLogger(Student.class.getName());
    private List<Student> students = new ArrayList<>();

    private Student getID(String ID){
        for(Student student: students){
            if(student.getID().contentEquals(ID))
                return student;
        }
        return null;
    }
    public void addStudents(String firstName, String lastName, String dateOfBirth, Character gender, String ID){
        Student newStudent;

        try{
            newStudent = new Student( firstName,  lastName,  dateOfBirth,  gender,  ID);
        }catch (ExceptionStudent e){
            String message = "Student not added: " + e.getMessage();
            LOGGER.log(Level.ERROR,message);
            throw new ExceptionRepository(message);
        }if(students.contains(newStudent)) {
            String message = "This student already in the list";
            LOGGER.log(Level.ERROR, message);
            throw new ExceptionRepository(message);
        }
        students.add(newStudent);
    }
    public void deleteStudent(String ID){
        if(ID.isEmpty()){
            LOGGER.log(Level.ERROR,"Student ID cannot be empty");
            throw new ExceptionRepository("Student ID cannot be empty");
        }Student studentID = getID(ID);
        if(studentID == null){
            LOGGER.log(Level.ERROR,"Student ID is not in the list");
            throw new ExceptionRepository("Student ID is not in the list");
        }
        students.remove(studentID);
    }

    public List<Student> getStudentsWithAge(int age) {
       if(age < 0){
           LOGGER.log(Level.ERROR,"Age cannot be negative");
           throw new ExceptionRepository("Age cannot be negative");
       }
       List<Student> list = new ArrayList<>();
       for(Student student : students){
           int temporaryAge = student.getAge();
           if(temporaryAge == age){
               list.add(student);
           }
       }
       return list;
    }
}
