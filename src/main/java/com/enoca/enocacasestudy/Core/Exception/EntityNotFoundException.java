package com.enoca.enocacasestudy.Core.Exception;

public abstract class EntityNotFoundException extends RuntimeException {


    public EntityNotFoundException(String s) {
        super(s);
    }

    public EntityNotFoundException(Long s) {
        super(String.valueOf(s));
    }
}
