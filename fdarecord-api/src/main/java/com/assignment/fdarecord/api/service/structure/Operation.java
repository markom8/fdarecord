package com.assignment.fdarecord.api.service.structure;

public enum Operation {
    SEARCH("search"),
    COUNT("count");

    public final String name;

    private Operation(String name) {
        this.name = name;
    }
}
