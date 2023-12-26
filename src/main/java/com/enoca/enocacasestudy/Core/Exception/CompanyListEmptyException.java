package com.enoca.enocacasestudy.Core.Exception;

public class CompanyListEmptyException extends EntityListEmptyException {
    public CompanyListEmptyException() {
        super("CompanyList is empty.");
    }
}
