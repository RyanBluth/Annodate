package com.annodate.validators;

public class ValidationResult {

    private String reason;
    private boolean valid;
    private Object value;
    private Object expectedValue;
    private String fieldName;

    public ValidationResult( boolean valid, String reason) {
        this.reason = reason;
        this.valid = valid;
    }

    public String getReason() {
        return reason;
    }

    public boolean isValid() {
        return valid;
    }

    protected void setReason( String reason ){
        this.reason = reason;
    }

    public void setValid(boolean valid) {
        this.valid = valid;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    public Object getExpectedValue() {
        return expectedValue;
    }

    public void setExpectedValue(Object expectedValue) {
        this.expectedValue = expectedValue;
    }

    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }
}
