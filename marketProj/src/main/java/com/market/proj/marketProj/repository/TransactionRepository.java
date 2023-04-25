package com.market.proj.marketProj.repository;


import com.market.proj.marketProj.Entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {
    @Override
    <S extends Transaction> S save(S Transaction);

    Transaction findByTransactionBuyerIdxAndTransactionProductIdx(Long buyerIdx, Long productIdx);

    Transaction findByTransactionProductIdx(Long productIdx);

    List<Transaction> findAll();
}
