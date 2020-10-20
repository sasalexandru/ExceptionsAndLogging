package org.example;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;


public class AppTest {

    @Test
    public void addStudentWithNoNameInput(){
        StudentRepository studentRepository = new StudentRepository();

        Assertions.assertThrows(ExceptionRepository.class, () -> studentRepository.addStudents("", "Alex",
                "23/09/1983", 'm', "1"));
    }
    @Test
    public void addingExistingStudent() {
        StudentRepository studentRepository = new StudentRepository();
        studentRepository.addStudents("Sas", "Alex", "23/09/1983", 'm', "1");
        Assertions.assertThrows(ExceptionRepository.class, () -> studentRepository.addStudents("Sas", "Alex",
                "23/09/1983", 'm', "1"));
    }
    @Test
    public void deleteStudentWithIdNotInTheList() {
        StudentRepository studentRepository = new StudentRepository();
        studentRepository.addStudents("Sas", "Alex", "23/09/1983", 'm', "1");
        Assertions.assertThrows(ExceptionRepository.class, () -> studentRepository.deleteStudent("2"));
    }
    @Test
    public void deleteWithNoIdInput() {
        StudentRepository studentRepository = new StudentRepository();
        studentRepository.addStudents("Sas", "Alex", "23/09/1983", 'm', "1");
        Assertions.assertThrows(ExceptionRepository.class, () -> studentRepository.deleteStudent(""));
    }
    @Test
    public void deleteWithCorrectIdInput() {
        StudentRepository repository = new StudentRepository();
        repository.addStudents("Sas", "Alex", "23/09/1983", 'm', "1");
        repository.deleteStudent("1");
        Assertions.assertThrows(ExceptionRepository.class, () -> repository.deleteStudent("1"));
    }
    @Test
    public void testStudentAge() {
        StudentRepository repository = new StudentRepository();
        repository.addStudents("Sas", "Alex", "23/09/1997", 'm', "1");
        repository.addStudents("Mihai", "Cristian", "23/09/1997", 'm', "2");
        repository.addStudents("Pop", "Cristian", "23/09/1996", 'm', "3");
        Assertions.assertEquals(2, repository.getStudentsWithAge(23).size());
    }

    @Test
    public void testAge(){
        Student student = new Student("Sas", "Alex", "23/09/1997", 'm', "1");
        Assertions.assertEquals(23,student.getAge());
    }
    @Test
    public void testAgeLowerThan1900(){
        Assertions.assertThrows(ExceptionStudent.class, () -> new Student("Sas", "Alex",
                "23/09/1881", 'm', "1"));
    }
    @Test
    public void testAgeBiggerThan2020(){
        Assertions.assertThrows(ExceptionStudent.class, () -> new Student("Sas", "Alex",
                "23/09/2021", 'm', "1"));
    }
    @Test
    public void testIfInputFirstNameIsEmpty(){
        Assertions.assertThrows(ExceptionStudent.class, () -> new Student("", "Alex",
                "23/09/1997", 'm', "1"));
    }
    @Test
    public void testIfInputLastNameIsEmpty(){
        Assertions.assertThrows(ExceptionStudent.class, () -> new Student("Sas", "",
                "23/09/1997", 'm', "1"));
    }
    @Test
    public void testIfInputIDIsEmpty(){
        Assertions.assertThrows(ExceptionStudent.class, () -> new Student("Sas", "Alex",
                "23/09/1997", 'm', ""));
    }
    @Test
    public void testIfInputGenderInvalid(){
        Assertions.assertThrows(ExceptionStudent.class, () -> new Student("Sas", "Alex",
                "23/09/1997", 'D', "1"));
    }
}
