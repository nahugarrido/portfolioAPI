package com.portfoliov2.app.portfolioAPI.exceptions;

import org.springframework.http.HttpStatus;

public class PortfolioExceptions extends RuntimeException{
    private String message;
    private HttpStatus httpStatus;

    public PortfolioExceptions(String message, HttpStatus httpStatus) {
        super(message);
        this.message = message;
        this.httpStatus = httpStatus;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public void setHttpStatus(HttpStatus httpStatus) {
        this.httpStatus = httpStatus;
    }
}
