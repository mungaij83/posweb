package main.java.dao;

import main.java.models.PaymentTransactions;

import org.springframework.data.repository.CrudRepository;

public interface PaymentTransactionDao extends
		CrudRepository<PaymentTransactions, Long> {

}
