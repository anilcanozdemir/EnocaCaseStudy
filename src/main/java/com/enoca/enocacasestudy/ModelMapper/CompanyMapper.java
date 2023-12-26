package com.enoca.enocacasestudy.ModelMapper;

import com.enoca.enocacasestudy.DTOs.Company.CompanyDto;
import com.enoca.enocacasestudy.DTOs.Company.CompanySaveRequestDto;
import com.enoca.enocacasestudy.Entity.Company;
import org.springframework.stereotype.Component;

@Component
public class CompanyMapper implements MapperProfile<CompanyDto, CompanySaveRequestDto, Company> {
    @Override
    public CompanyDto entityToDTO(Company company) {
        return new CompanyDto(company.getId(), company.getCompanyName());
    }

    @Override
    public Company saveRequestDtoToEntity(CompanySaveRequestDto companySaveRequestDto) {
        Company company = new Company();
        company.setCompanyName(companySaveRequestDto.getCompanyName());
        return company;
    }

    @Override
    public Company DTOtoEntity(CompanyDto updateRequestDto) {
        Company company = new Company();
        company.setCompanyName(updateRequestDto.getCompanyName());
        company.setId(updateRequestDto.getId());
        return company;
    }
}
