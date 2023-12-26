package com.enoca.enocacasestudy.Core.Exception;

public abstract class EntityListEmptyException extends EntityNotFoundException {

    public EntityListEmptyException(String s) {
        super(s);
    }
}
