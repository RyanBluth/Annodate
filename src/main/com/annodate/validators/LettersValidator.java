package com.annodate.validators;


import com.annodate.annotations.Letters;

import java.util.ArrayList;
import java.util.List;

public class LettersValidator<T> implements Validator<T, Letters>{


    @Override
    public ValidationResult validate(T obj, Letters annotation) {
        String stringRep = String.valueOf(obj);
        List<Character> ignoreChars = new ArrayList<>();
        for( char c : annotation.ignoreChars()){
            ignoreChars.add(c);
        }
        for( char c : stringRep.toCharArray() ){
            if( !ignoreChars.contains(c) && !Character.isLetter(c)){
                return ValidationResult.invalid( "Character '" + c + "' is not numeric" );
            }
        }
        return ValidationResult.valid();
    }
}
