package com.assignment.fdarecord.api.service.structure;

public enum OperationKey {
    BRAND_NAME("openfda.brand_name"),
    MANUFACTURER_NAME("openfda.manufacturer_name");

    public final String name;

    private OperationKey(String name) {
        this.name = name;
    }
}
