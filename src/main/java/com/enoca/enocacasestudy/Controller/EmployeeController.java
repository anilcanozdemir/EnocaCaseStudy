package com.enoca.enocacasestudy.Controller;

import com.enoca.enocacasestudy.Core.Result.DataResult;
import com.enoca.enocacasestudy.Core.Result.Result;
import com.enoca.enocacasestudy.DTOs.Employee.EmployeeDto;
import com.enoca.enocacasestudy.DTOs.Employee.EmployeeSaveRequestDto;
import com.enoca.enocacasestudy.Service.Contract.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/employee")
public class EmployeeController implements CRUDController<EmployeeDto, EmployeeSaveRequestDto> {

    @Autowired
    private EmployeeService employeeService;
    @Override
    @PostMapping("/add")
    public ResponseEntity<Result> add(@RequestBody EmployeeSaveRequestDto employeeSaveRequestDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(employeeService.add(employeeSaveRequestDto));
    }

    @Override
    @GetMapping("/getAll")

    public ResponseEntity<DataResult<List<EmployeeDto>>> getAll() {
        return ResponseEntity.status(HttpStatus.OK).body(employeeService.getAll());
    }

    @Override
    @GetMapping("/getById")

    public ResponseEntity<DataResult<EmployeeDto>> getById(@RequestParam Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(employeeService.getById(id));
    }

    @Override
    @PostMapping("/updateById")
    public ResponseEntity<Result> updateById(@RequestBody EmployeeDto entityResponseDto) {
        return ResponseEntity.status(HttpStatus.OK).body(employeeService.updateById(entityResponseDto));
    }

    @Override
    @DeleteMapping("deleteById")
    public ResponseEntity<DataResult<EmployeeDto>> deleteById(@RequestParam Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(employeeService.deleteById(id));
    }
}
