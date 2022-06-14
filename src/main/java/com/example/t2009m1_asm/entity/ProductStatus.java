package com.example.t2009m1_asm.entity;

public enum ProductStatus {
    ON_SALE(1),STOP_SALE(0),DELETED(-1);
    private final int value;
    ProductStatus(int value){
        this.value = value;
    }
    public int getValue(){
        return value;
    }
    public static ProductStatus getAccountStatus(int value){
        for(ProductStatus productStatus : ProductStatus.values()){
            if(productStatus.getValue() == value){
                return productStatus;
            }
        }
        return ON_SALE;
    }
}
