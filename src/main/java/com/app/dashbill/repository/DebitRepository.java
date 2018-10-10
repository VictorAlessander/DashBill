package com.app.dashbill.repository;


import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.app.dashbill.entity.Debit;

public interface DebitRepository extends JpaRepository<Debit, Long>, DebitRepositoryCustom {
	
	@Query(
		value = "SELECT id, balance, date, category, person_id FROM debits WHERE date BETWEEN :fromDate AND :toDate;",
		nativeQuery=true)
	public List<Debit> getDebitsByDateRange(@Param("fromDate") LocalDate fromDate, @Param("toDate") LocalDate toDate);
}
