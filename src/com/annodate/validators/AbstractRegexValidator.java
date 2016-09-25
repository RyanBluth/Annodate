package com.annodate.validators;


public abstract class AbstractRegexValidator<T> {

    public ValidationResult getResult( T obj, String regex ){
        String lParsed = String.valueOf(obj);
        boolean valid = lParsed.matches( regex );
        return new ValidationResult( valid, valid ? null : "Value does not match regex '" + regex + "'");
    }
}
