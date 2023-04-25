package com.market.proj.marketProj.repository;

import com.market.proj.marketProj.Entity.Bidding;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
public interface BiddingRepository extends JpaRepository<Bidding, Long> {

    @Modifying
    @Transactional
    void deleteByIdx(Long idx);

    Bidding findByUserIdx(Long userIdx);

    Bidding findFirstByProductIdxOrderByBiddingPriceDesc(Long productIdx);

    Bidding findByProductIdxAndUserIdx(Long productIdx, Long userIdx);
}
