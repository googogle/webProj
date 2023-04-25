package com.market.proj.marketProj.Service;

import com.market.proj.marketProj.Entity.Transaction;
import com.market.proj.marketProj.repository.TransactionRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;


@Slf4j
@RequiredArgsConstructor
@Service
public class TransactionService {
    private final TransactionRepository transactionRepository;

    public Transaction save(Transaction transaction){ return transactionRepository.save(transaction); }

    public Transaction findByTransactionBuyerIdxAndTransactionProductIdx(Long transactionBuyerIdx, Long transactionProductIdx) { return transactionRepository.findByTransactionBuyerIdxAndTransactionProductIdx(transactionBuyerIdx, transactionProductIdx); }

    public Transaction findByProductIdx(Long productIdx) { return transactionRepository.findByTransactionProductIdx(productIdx); }

    public List<Transaction> findAll() { return transactionRepository.findAll(); }
}
