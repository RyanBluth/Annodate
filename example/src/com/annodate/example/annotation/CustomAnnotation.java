package com.annodate.example.annotation;


import com.annodate.annotations.Validators;
import com.annodate.example.validator.CustomValidator;

@Validators({CustomValidator.class})
public @interface CustomAnnotation {
}
