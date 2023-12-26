package com.enoca.enocacasestudy.Core.Exception;

public class EmployeeListEmptyException extends EntityListEmptyException {
    public EmployeeListEmptyException() {
        super("EmployeeList is empty.");
    }

    public EmployeeListEmptyException(String s) {
        super(s);
    }
}
