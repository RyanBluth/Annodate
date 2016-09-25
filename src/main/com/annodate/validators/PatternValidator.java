package com.annodate.validators;

import com.annodate.annotations.MatchPattern;

public class PatternValidator<T> extends AbstractRegexValidator<T> implements Validator<T, MatchPattern>{

    @Override
    public ValidationResult validate(T obj, MatchPattern annotation) {

        String regex = "";

        for( char c : annotation.value().toCharArray()){
            if( c == annotation.any()){
                regex += ".";
            }else if( c == annotation.anyCase() ){
                regex += "[A-Za-z]{1}";
            }else if( c == annotation.lowerCase() ){
                regex += "[a-z]{1}";
            }else if( c == annotation.upperCase() ){
                regex += "[A-Z]{1}";
            }else if( c == annotation.numeric() ){
                regex += "[0-9]{1}";
            }else{
                regex += "\\" + c;
            }
        }
        ValidationResult res =  getResult( obj, regex);
        if( !res.isValid() ){
            res.setReason( "Value did not match pattern '" + annotation.value() + "'" );
        }
        return res;
    }
}