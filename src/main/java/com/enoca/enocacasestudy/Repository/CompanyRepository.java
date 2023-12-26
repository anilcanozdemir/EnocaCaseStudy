package com.enoca.enocacasestudy.Repository;

import com.enoca.enocacasestudy.Entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepository extends JpaRepository<Company,Long> {
}
