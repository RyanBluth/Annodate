package com.annodate.annotations;


import com.annodate.validators.LettersValidator;
import com.annodate.validators.NumericValidator;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME )
@Target( ElementType.FIELD )
@Validators({LettersValidator.class})
public @interface Letters {

    char[] ignoreChars() default {};

}
