package com.annodate.annotations;


import com.annodate.validators.Validator;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME )
@Target(ElementType.ANNOTATION_TYPE)
public @interface Validators {

    Class<? extends Validator>[] value();
}
