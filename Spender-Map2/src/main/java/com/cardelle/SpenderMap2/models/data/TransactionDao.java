package com.cardelle.SpenderMap2.models.data;

import com.cardelle.SpenderMap2.models.Transaction;
import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;

/**
 * Created by LaunchCode
 */
@Transactional
public interface TransactionDao extends CrudRepository<Transaction, Integer> {
}
