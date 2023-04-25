package com.market.proj.marketProj.Entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Entity
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idx;
    private int transactionPrice;
    @Builder.Default
    private LocalDateTime transactionTime = LocalDateTime.now();
    private Long transactionSellerIdx;
    private Long transactionBuyerIdx;
    private Long transactionProductIdx;
    private String chatRoomId;

}
