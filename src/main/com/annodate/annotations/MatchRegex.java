package com.annodate.annotations;

import com.annodate.validators.RegexValidator;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME )
@Target( ElementType.FIELD )
@Validators({RegexValidator.class})
public @interface MatchRegex {

    String value();

}
