package com.annodate.validators;


import com.annodate.annotations.MaxLength;
import com.annodate.exception.TypeNotSupportedException;
import com.annodate.util.GenericsUtil;

import java.util.Collection;

public class MaxLengthValidator<T> implements Validator<T, MaxLength> {

    @Override
    public ValidationResult validate(T obj, MaxLength annotation) {
        boolean valid;
        if (obj instanceof Collection) {
            valid = ((Collection) obj).size() <= annotation.value();
        } else if (obj.getClass().isArray()) {
            int length = GenericsUtil.getGenericArrayLength( obj );
            valid = length <= annotation.value();
        } else if (obj instanceof String) {
            valid = ((String) obj).length() <= annotation.value();
        } else {
            throw new TypeNotSupportedException(obj.getClass(), this);
        }
        if (valid) {
            return new ValidationResult(true, null);
        } else {
            return new ValidationResult(false, "Length must not be greater than " + annotation.value());
        }
    }

}
