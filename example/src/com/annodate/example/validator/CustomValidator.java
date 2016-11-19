package com.annodate.example.validator;

import com.annodate.example.annotation.CustomAnnotation;
import com.annodate.validators.ValidationResult;
import com.annodate.validators.Validator;

public class CustomValidator<T> implements Validator<T, CustomAnnotation> {

    @Override
    public ValidationResult validate(T obj, CustomAnnotation annotation) {
        return null;
    }
}
