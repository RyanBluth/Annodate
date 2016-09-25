package com.annodate.annotations;


import com.annodate.validators.PatternValidator;
import com.annodate.validators.RegexValidator;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME )
@Target( ElementType.FIELD )
@Validators({PatternValidator.class})
public @interface MatchPattern {

    String value();

    char numeric() default '#';

    char any() default '$';

    char lowerCase() default 'a';

    char upperCase() default 'A';

    char anyCase() default '@';

}