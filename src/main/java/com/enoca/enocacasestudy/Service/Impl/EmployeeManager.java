package com.enoca.enocacasestudy.Service.Impl;

import com.enoca.enocacasestudy.Core.Exception.EmployeeListEmptyException;
import com.enoca.enocacasestudy.Core.Exception.EmployeeNotFoundException;
import com.enoca.enocacasestudy.Core.Result.DataResult;
import com.enoca.enocacasestudy.Core.Result.Result;
import com.enoca.enocacasestudy.Core.Result.SuccessDataResult;
import com.enoca.enocacasestudy.Core.Result.SuccessResult;
import com.enoca.enocacasestudy.DTOs.Employee.EmployeeDto;
import com.enoca.enocacasestudy.DTOs.Employee.EmployeeSaveRequestDto;
import com.enoca.enocacasestudy.Entity.Employee;
import com.enoca.enocacasestudy.ModelMapper.EmployeeMapper;
import com.enoca.enocacasestudy.Repository.EmployeeRepository;
import com.enoca.enocacasestudy.Service.Contract.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EmployeeManager implements EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private EmployeeMapper employeeMapper;

    @Override
    public Result add(EmployeeSaveRequestDto employeeSaveRequestDto) {
        Employee employee = this.employeeRepository.save(employeeMapper.saveRequestDtoToEntity(employeeSaveRequestDto));
        return new SuccessResult(employee.getName() + " " + employee.getSurname() +
                " with id  : " + employee.getId() +
                "   added.");
    }

    @Override
    public DataResult<EmployeeDto> deleteById(Long id) {
        Optional<Employee> employee = employeeRepository.findById(id);
        employee.ifPresent(employeeRepository::delete);
        return new SuccessDataResult<>("Employee with id  " + id + "  deleted successfully.",
                employee.map(employeeMapper::entityToDTO)
                        .orElseThrow(() -> new EmployeeNotFoundException(id)));

    }

    @Override
    public DataResult<List<EmployeeDto>> getAll() {
        List<Employee> airportList = this.employeeRepository.findAll();
        if (airportList.isEmpty()) {
            throw new EmployeeListEmptyException();
        }
        return new SuccessDataResult<>("CompanyList successfully called.",
                airportList.stream()
                        .map(employeeMapper::entityToDTO)
                        .toList());
    }

    @Override
    public DataResult<EmployeeDto> getById(Long id) {
        Optional<Employee> airport = this.employeeRepository.findById(id);
        return new SuccessDataResult<>("Company with id " + id + "successfully called.",
                airport.map(employeeMapper::entityToDTO)
                        .orElseThrow(() -> new EmployeeNotFoundException(id)));
    }

    @Override
    public Result updateById(EmployeeDto entityUpdateRequestDto) {
        Optional<Employee> airportOld = this.employeeRepository.findById(entityUpdateRequestDto.getId());
        if (airportOld.isPresent()) {
            if (airportOld.get().equals(employeeMapper.DTOtoEntity(entityUpdateRequestDto))) {
                this.employeeRepository.save(employeeMapper.DTOtoEntity(entityUpdateRequestDto));
            }
            return new SuccessResult("To city   :" + entityUpdateRequestDto.getName() + " " + entityUpdateRequestDto.getSurname() +
                    "with id  :" + entityUpdateRequestDto.getId() +
                    " employee updated.");
        }
        throw new EmployeeNotFoundException(entityUpdateRequestDto.getId());
    }
}
