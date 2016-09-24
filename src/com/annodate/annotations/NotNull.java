package com.annodate.annotations;


import com.annodate.validators.NotNullValidator;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME )
@Target( ElementType.FIELD )
@Validators({NotNullValidator.class})
public @interface NotNull {

}
