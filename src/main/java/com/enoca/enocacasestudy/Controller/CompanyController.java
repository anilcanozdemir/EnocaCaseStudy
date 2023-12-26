package com.enoca.enocacasestudy.Controller;

import com.enoca.enocacasestudy.Core.Result.DataResult;
import com.enoca.enocacasestudy.Core.Result.Result;
import com.enoca.enocacasestudy.DTOs.Company.CompanyDto;
import com.enoca.enocacasestudy.DTOs.Company.CompanySaveRequestDto;
import com.enoca.enocacasestudy.Service.Contract.CompanyService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/company")
public class CompanyController implements CRUDController<CompanyDto, CompanySaveRequestDto>{
    @Autowired
    private CompanyService companyService;
    @Override
    @PostMapping("/add")
    public ResponseEntity<Result> add(@RequestBody CompanySaveRequestDto companySaveRequestDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(companyService.add(companySaveRequestDto));
    }

    @Override
    @GetMapping("/getAll")
    public ResponseEntity<DataResult<List<CompanyDto>>> getAll() {
        return ResponseEntity.status(HttpStatus.OK).body(companyService.getAll());
    }

    @Override
    @GetMapping("/getById")
    public ResponseEntity<DataResult<CompanyDto>> getById(@RequestParam Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(companyService.getById(id));
    }

    @Override
    @PostMapping("/updateById")
    public ResponseEntity<Result> updateById(@RequestBody CompanyDto entityResponseDto) {
        return ResponseEntity.status(HttpStatus.OK).body(companyService.updateById(entityResponseDto));
    }

    @Override
    @DeleteMapping("/deleteById")
    public ResponseEntity<DataResult<CompanyDto>> deleteById(@RequestParam Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(companyService.deleteById(id));
    }
}
