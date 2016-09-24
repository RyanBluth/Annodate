package com.annodate.validators;


import java.lang.annotation.Annotation;

public interface Validator<T, A extends Annotation> {

    ValidationResult validate( T obj, A annotation );

}
