package com.annodate.validators;

import com.sun.istack.internal.Nullable;

public class ValidationResult {

    private String reason;
    private boolean valid;

    public ValidationResult( boolean valid, @Nullable String reason) {
        this.reason = reason;
        this.valid = valid;
    }

    public String getReason() {
        return reason;
    }

    public boolean isValid() {
        return valid;
    }
}
