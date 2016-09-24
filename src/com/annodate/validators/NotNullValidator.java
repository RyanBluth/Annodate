package com.annodate.validators;

import com.annodate.annotations.NotNull;

public class NotNullValidator<T> implements Validator<T,NotNull> {

    @Override
    public ValidationResult validate(T obj, NotNull annotation) {
        boolean valid =  obj != null;
        return valid ? new ValidationResult( true, null) : new ValidationResult( false, "Value must not be null");
    }
}
