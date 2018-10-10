package com.app.dashbill.repository;

import java.time.LocalDate;
import java.util.List;

import com.app.dashbill.entity.Debit;

public interface DebitRepositoryCustom {

	List<Debit> getDebitsByDateRange(LocalDate fromDate, LocalDate toDate);
}
