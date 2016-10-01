package com.annodate;


import com.annodate.validators.ValidationResult;
import com.annodate.validators.Validator;

public interface AnnodateErrorProvider {

    AnnodateError buildError( Validator validator, ValidationResult validationResult );

}
