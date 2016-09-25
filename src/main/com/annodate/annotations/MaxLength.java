package com.annodate.annotations;


import com.annodate.validators.MaxLengthValidator;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME )
@Target( ElementType.FIELD )
@Validators({MaxLengthValidator.class})
public @interface MaxLength {

    int value() default 0;
}
