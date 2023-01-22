package com.assignment.fdarecord.api.exception;

public class FdaApiSearchException extends Exception {
    public FdaApiSearchException() {
        super("Fda api can not implement search by openfda.manufacturer_name and openfda.brand_name simultaneously.");
    }
}
