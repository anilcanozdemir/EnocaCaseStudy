package com.enoca.enocacasestudy.Controller;

import com.enoca.enocacasestudy.Core.Result.DataResult;
import com.enoca.enocacasestudy.Core.Result.Result;
import com.enoca.enocacasestudy.DTOs.Employee.EmployeeDto;
import com.enoca.enocacasestudy.DTOs.Employee.EmployeeSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class EmployeeController implements CRUDController<EmployeeDto, EmployeeSaveRequestDto> {


    private EmployeeService employeeService;
    @Override
    public ResponseEntity<Result> add(EmployeeSaveRequestDto employeeSaveRequestDto) {
        return null;
    }

    @Override
    public ResponseEntity<DataResult<List<EmployeeDto>>> getAll() {
        return null;
    }

    @Override
    public ResponseEntity<DataResult<EmployeeDto>> getById(Long id) {
        return null;
    }

    @Override
    public ResponseEntity<Result> updateById(EmployeeDto entityResponseDto) {
        return null;
    }

    @Override
    public ResponseEntity<DataResult<EmployeeDto>> deleteById(Long id) {
        return null;
    }
}
