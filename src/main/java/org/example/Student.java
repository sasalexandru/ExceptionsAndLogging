package org.example;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.joda.time.DateTime;
import org.joda.time.Period;
import org.joda.time.format.DateTimeFormat;

import java.time.format.DateTimeParseException;
import java.util.Objects;

public class Student {
    static final Logger LOGGER = LogManager.getLogger(Student.class.getName());

    private String firstName;
    private String lastName;
    private DateTime dateOfBirth;
    private Gender gender;
    private String ID;

    public Student(String firstName, String lastName, String dateOfBirth, Character gender, String ID) {
        setFirstName(firstName);
        setLastName(lastName);
        setDateOfBirth(dateOfBirth);
        setGender(gender);
        setID(ID);
    }


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        if(firstName == null || firstName.isEmpty()){
            LOGGER.log(Level.ERROR,"First name cannot be empty");
            throw new ExceptionStudent("First name cannot be empty");
        }
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
       if(firstName == null || firstName.isEmpty()){
           LOGGER.log(Level.ERROR,"Last name cannot be empty");
           throw new ExceptionStudent("Last name cannot be empty");
       }
       this.lastName = lastName;
    }

    public DateTime getDateOfBirth() {

        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        DateTime date;
        DateTime today = DateTime.now();
        try {
            date = DateTime.parse(dateOfBirth, DateTimeFormat.forPattern("dd/MM/yyyy"));
        }catch(DateTimeParseException e){
            throw new ExceptionStudent(e.getMessage());
        }
        if(date.isAfter(today)){
            LOGGER.log(Level.ERROR,"You are not born in the future, sorry");
            throw new ExceptionStudent("You are not born in the future, sorry");
        }
        if(date.getYear() < 1900){
            LOGGER.log(Level.ERROR,"Birthday before 1900 is not accepted");
            throw new ExceptionStudent("Birthday before 1900 is not accepted");
        }
        this.dateOfBirth = date ;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Character gender) {
        Character temp = Character.toUpperCase(gender);
        if (!(temp.equals('M') || temp.equals('F'))) {
            String message = "Gender should be: " + Gender.male + " or " + Gender.female;
            LOGGER.log(Level.ERROR, message);
            throw new ExceptionStudent(message);
        }
        switch (temp) {
            case 'M':
                this.gender = Gender.male;
                break;
            case 'F':
                this.gender = Gender.female;
                break;
        }
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        if (ID == null || ID.isEmpty()) {
            LOGGER.log(Level.ERROR, "The ID cannot be empty of null");
            throw new ExceptionStudent("The ID cannot be empty of null");
        }
        this.ID = ID;
    }
    public int getAge() {
        DateTime date  = DateTime.now();
        Period period = new Period(dateOfBirth,date);
        return period.getYears();
    }

    @Override
    public String toString() {
        return "Student{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", gender=" + gender +
                ", ID='" + ID + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equals(firstName, student.firstName) &&
                Objects.equals(lastName, student.lastName) &&
                Objects.equals(dateOfBirth, student.dateOfBirth) &&
                gender == student.gender &&
                Objects.equals(ID, student.ID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, dateOfBirth, gender, ID);
    }
}
