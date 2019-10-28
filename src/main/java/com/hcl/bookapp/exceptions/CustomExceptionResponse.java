package com.hcl.bookapp.exceptions;

public class CustomExceptionResponse {
    // Basically the variable name will act as key in JSON object response
    // { "productId" : whatever value we passed in
    private String errorResponse;

    public CustomExceptionResponse(String errorResponse) {
        this.errorResponse = errorResponse;
    }

    public String getErrorResponse() {
        return errorResponse;
    }

    public void setErrorResponse(String errorResponse) {
        this.errorResponse = errorResponse;
    }
}
