package com.enoca.enocacasestudy.Core.Exception;

public class CompanyNotFoundException extends EntityNotFoundException {


    public CompanyNotFoundException(Long id) {
        super("Company with id  :" + id + " is not found.");
    }
}
