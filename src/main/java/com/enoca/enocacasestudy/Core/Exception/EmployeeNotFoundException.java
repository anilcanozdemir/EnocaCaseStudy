package com.enoca.enocacasestudy.Core.Exception;

public class EmployeeNotFoundException extends EntityNotFoundException {
    public EmployeeNotFoundException(Long id) {
        super("Employee with id  :" + id + " is not found.");
    }
}
