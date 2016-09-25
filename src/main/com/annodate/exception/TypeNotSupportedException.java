package com.annodate.exception;

import com.annodate.validators.Validator;

public class TypeNotSupportedException extends RuntimeException {

    public TypeNotSupportedException(Class typeClass, Validator validator ){
        super( "Validator of type '" + validator.getClass().getName()
                + "' does not support type '" + typeClass.getName() + "'");
    }
}
