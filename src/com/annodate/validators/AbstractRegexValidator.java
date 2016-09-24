package com.annodate.validators;


public abstract class AbstractRegexValidator<T> {

    public ValidationResult getResult( T obj, String regex ){
        String val;
        if( obj != null && obj instanceof Object){
            val = obj.toString();
        }else{
            val = String.valueOf(obj);
        }
        String lParsed = String.valueOf(obj);
        boolean valid = lParsed.matches( regex );
        return new ValidationResult( valid, valid ? null : "Value does not match regex '" + regex + "'");
    }
}
