package com.assignment.fdarecord.api.exception;

public class FdaApiQueryException extends Exception {
    public FdaApiQueryException() {
        super("Fda api can not implement count and skip operations simultaneously.");
    }
}
