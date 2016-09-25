package com.annodate.validators;

public class ValidationResult {

    private String reason;
    private boolean valid;

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
}
