package com.enoca.enocacasestudy.Service.Impl;

import com.enoca.enocacasestudy.Core.Exception.CompanyListEmptyException;
import com.enoca.enocacasestudy.Core.Exception.CompanyNotFoundException;
import com.enoca.enocacasestudy.Core.Result.DataResult;
import com.enoca.enocacasestudy.Core.Result.Result;
import com.enoca.enocacasestudy.Core.Result.SuccessDataResult;
import com.enoca.enocacasestudy.Core.Result.SuccessResult;
import com.enoca.enocacasestudy.DTOs.Company.CompanyDto;
import com.enoca.enocacasestudy.DTOs.Company.CompanySaveRequestDto;
import com.enoca.enocacasestudy.Entity.Company;
import com.enoca.enocacasestudy.ModelMapper.CompanyMapper;
import com.enoca.enocacasestudy.Repository.CompanyRepository;
import com.enoca.enocacasestudy.Service.Contract.CompanyService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor

public class CompanyManager implements CompanyService {
    @Autowired
    private CompanyMapper companyMapper;
    @Autowired
    private CompanyRepository companyRepository;

    @Override
    public Result add(CompanySaveRequestDto companySaveRequestDto) {
        Company savedCompany = this.companyRepository.save(companyMapper.saveRequestDtoToEntity(companySaveRequestDto));
        return new SuccessResult(savedCompany.getCompanyName() +
                " with id  : " + savedCompany.getId() +
                "   added.");
    }

    @Override
    public DataResult<CompanyDto> deleteById(Long id) {
        Optional<Company> company = companyRepository.findById(id);
        company.ifPresent(companyRepository::delete);

        return new SuccessDataResult<>("Company with id  " + id + "  deleted successfully.",
                company.map(companyMapper::entityToDTO)
                        .orElseThrow(() -> new CompanyNotFoundException(id)));
    }

    @Override
    public DataResult<List<CompanyDto>> getAll() {
        List<Company> companyList = this.companyRepository.findAll();
        if (companyList.isEmpty()) {
            throw new CompanyListEmptyException();
        }
        return new SuccessDataResult<>("CompanyList successfully called.",
                companyList.stream()
                        .map(companyMapper::entityToDTO)
                        .toList());
    }

    @Override
    public DataResult<CompanyDto> getById(Long id) {
        Optional<Company> company = this.companyRepository.findById(id);
        return new SuccessDataResult<>("Company with id " + id + "successfully called.",
                company.map(companyMapper::entityToDTO)
                        .orElseThrow(() -> new CompanyNotFoundException(id)));
    }

    @Override
    public Result updateById(CompanyDto entityUpdateRequestDto) {
        Optional<Company> companyOld = this.companyRepository.findById(entityUpdateRequestDto.getId());
        if (companyOld.isPresent()) {
            if (!companyOld.get().getCompanyName().equals(entityUpdateRequestDto.getCompanyName())) {
                this.companyRepository.save(companyMapper.DTOtoEntity(entityUpdateRequestDto));
            }
            return new SuccessResult(entityUpdateRequestDto.getCompanyName() +
                    "with id  :" + entityUpdateRequestDto.getId() +
                    " company updated.");
        }
        throw new CompanyNotFoundException(entityUpdateRequestDto.getId());
    }
}
