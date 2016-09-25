package com.annodate.validators;

import com.annodate.annotations.Email;

public class EmailValidator<T> extends AbstractRegexValidator<T> implements Validator<T, Email>{

    @Override
    public ValidationResult validate(T obj, Email annotation) {
        return getResult( obj, RegexConstants.EMAIL );
    }
}
