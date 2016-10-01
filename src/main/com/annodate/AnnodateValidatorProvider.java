package com.annodate;

import com.annodate.validators.Validator;

import java.lang.annotation.Annotation;
import java.util.List;
import java.util.Map;

public interface AnnodateValidatorProvider {

    Map<Class<? extends Annotation>, List<Class<? extends Validator>>> wireValidators();

}
