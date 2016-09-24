package com.annodate;


import java.util.ArrayList;
import java.util.List;

public class AnnodateError {

    private String field;
    private List<String> errors;

    public AnnodateError(String field) {
        this.field = field;
        errors = new ArrayList<>();
    }

    public void addError( String error ){
        errors.add(error);
    }

    public List<String> getErrors() {
        return errors;
    }

    public String getField() {
        return field;
    }
}
