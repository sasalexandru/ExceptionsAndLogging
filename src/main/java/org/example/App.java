package org.example;

import java.util.List;

public class App {


    public static void main(String[] args) {
        StudentRepository studentRepository = new StudentRepository();
        studentRepository.addStudents("Catalin", "Oliviu","06/05/1997",'m',"1");
        studentRepository.addStudents("Gandalf", "Cristian","06/05/2000",'m',"3");
        studentRepository.addStudents("Prince", "Dog","06/05/2000",'m',"4");
        studentRepository.addStudents("Catalin", "Oliviu","06/05/1997",'m',"1");
        List<Student> ageList = studentRepository.getStudentsWithAge(23);
        System.out.println(ageList);
    }
}
