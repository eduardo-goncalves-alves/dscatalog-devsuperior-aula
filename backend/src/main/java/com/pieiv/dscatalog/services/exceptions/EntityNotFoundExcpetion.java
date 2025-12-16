package com.pieiv.dscatalog.services.exceptions;

public class EntityNotFoundExcpetion extends RuntimeException{
    private static final long serialVersionUID = 1L;

    public EntityNotFoundExcpetion(String msg) {
        super(msg);
    }
}
