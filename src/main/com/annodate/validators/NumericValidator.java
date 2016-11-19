package com.annodate.validators;

import com.annodate.annotations.Numeric;

import java.util.ArrayList;
import java.util.List;

public class NumericValidator<T> implements Validator<T, Numeric>{


    @Override
    public ValidationResult validate(T obj, Numeric annotation) {
        String stringRep = String.valueOf(obj);
        List<Character> ignoreChars = new ArrayList<>();
        for( char c : annotation.ignoreChars()){
            ignoreChars.add(c);
        }
        for( char c : stringRep.toCharArray() ){
            if( !ignoreChars.contains(c) && !Character.isDigit(c)){
                return ValidationResult.invalid( "Character '" + c + "' is not numeric" );
            }
        }
        return ValidationResult.valid();
    }
}
