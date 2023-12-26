package com.enoca.enocacasestudy.ModelMapper;

import com.enoca.enocacasestudy.Core.Exception.CompanyNotFoundException;
import com.enoca.enocacasestudy.DTOs.Employee.EmployeeDto;
import com.enoca.enocacasestudy.DTOs.Employee.EmployeeSaveRequestDto;
import com.enoca.enocacasestudy.Entity.Employee;
import com.enoca.enocacasestudy.Repository.CompanyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class EmployeeMapper implements MapperProfile<EmployeeDto, EmployeeSaveRequestDto, Employee> {
    @Autowired
    private CompanyRepository companyRepository;

    @Override
    public EmployeeDto entityToDTO(Employee employee) {
        return new EmployeeDto(employee.getId(), employee.getCompany().getId(), employee.getName(), employee.getSurname(), employee.getSalary(), employee.getAge(), employee.getEmail());
    }

    @Override
    public Employee saveRequestDtoToEntity(EmployeeSaveRequestDto employeeSaveRequestDto) {
        Employee employee = new Employee();
        return getEmployee(employee, employeeSaveRequestDto.getAge(), employeeSaveRequestDto.getName(), employeeSaveRequestDto.getSalary(), employeeSaveRequestDto.getEmail(), employeeSaveRequestDto.getSurname(), employeeSaveRequestDto.getCompanyId());
    }

    @Override
    public Employee DTOtoEntity(EmployeeDto updateRequestDto) {
        Employee employee = new Employee();
        employee.setId(updateRequestDto.getId());
        return getEmployee(employee, updateRequestDto.getAge(), updateRequestDto.getName(), updateRequestDto.getSalary(), updateRequestDto.getEmail(), updateRequestDto.getSurname(), updateRequestDto.getCompanyId());
    }

    private Employee getEmployee(Employee employee, Integer age, String name, double salary, String email, String surname, Long companyId) {
        employee.setAge(age);

        employee.setName(name);
        employee.setSalary(salary);
        employee.setEmail(email);
        employee.setSurname(surname);
        employee.setCompany(companyRepository.findById(companyId).
                orElseThrow(() -> new CompanyNotFoundException(companyId)));
        return employee;
    }
}
