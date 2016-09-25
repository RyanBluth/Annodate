package com.annodate.annotations;


import com.annodate.validators.NotNullValidator;
import com.annodate.validators.OneOfValidator;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME )
@Target( ElementType.FIELD )
@Validators({OneOfValidator.class})
public @interface OneOf {
    String[] value();
}