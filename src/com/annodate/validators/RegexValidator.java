package com.annodate.validators;

import com.annodate.annotations.MatchRegex;

public class RegexValidator<T> extends AbstractRegexValidator<T> implements Validator<T, MatchRegex>{

    @Override
    public ValidationResult validate(T obj, MatchRegex annotation) {
        return getResult( obj, annotation.value());
    }
}
