package Exceptions;

public class InvalidAmount extends RuntimeException{
    public InvalidAmount(String message){
        super(message);
    }
}