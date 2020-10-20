package org.example;

public class ExceptionRepository extends RuntimeException{
    public ExceptionRepository(String message) {
        super(message);
    }
}
