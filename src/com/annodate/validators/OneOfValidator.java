package com.annodate.validators;

import com.annodate.annotations.OneOf;

public class OneOfValidator<T> implements Validator<T, OneOf> {

    @Override
    public ValidationResult validate(T obj, OneOf annotation) {
        boolean valid = false;
        for (String val : annotation.value()) {
            if (val.equals(String.valueOf(obj))) {
                valid = true;
                break;
            }
        }
        String options = "[";
        if (!valid) {
            String[] value = annotation.value();
            for (int i = 0; i < value.length; i++) {
                String val = value[i];
                if (i != value.length - 1) {
                    val += ", ";
                }
                options += val;
            }
        }
        options += "]";
        return new ValidationResult(valid, valid ? null : "Value must be one of " + options);
    }
}
