package com.annodate.example;

import com.annodate.Annodate;
import com.annodate.AnnodateError;
import com.annodate.example.model.User;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        User user1 = new User();
        user1.setEmail("test@examplle.org");
        user1.setFirstName("tim");
        user1.setLastName("tom");
        user1.setPassword("password");
        user1.setPhoneNumber("(123) 555-5555");
        user1.setPostalCode("A1A 1A1");

        List<AnnodateError> errors =  Annodate.validate( user1 );

        printErrors( "User 1", Annodate.validate( user1 ) );

        User user2 = new User();
        user2.setEmail("test!examplle.org");
        user2.setFirstName("1tdzfzvzxcvcxvxzcvxcvxcvxcvxcvxcvxcvxcvxim");
        user2.setLastName("2toxczvzxcvzxcvzxcvzxcvzxcvzxcvzxcvzxcvxzcvzxcvzxcvxczvm");
        user2.setPassword("pasrd");
        user2.setPhoneNumber("!(23) 555-5555");
        user2.setPostalCode("AAA 1A1");

        printErrors( "User 2", Annodate.validate( user2 ) );
    }

    private static void printErrors(String user, List<AnnodateError> errors){
        System.out.println("----------------------------------------------------");
        System.out.println(user + " has the following errors:");
        for(AnnodateError error : errors ){
            System.out.println("\tThe errors for field " + error.getField() + " are:");
            for(String errorString : error.getErrors()){
                System.out.println("\t\t -> " + errorString);
            }
        }
    }
}
