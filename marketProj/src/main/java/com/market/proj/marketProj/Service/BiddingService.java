package com.market.proj.marketProj.Service;

import com.market.proj.marketProj.Entity.Bidding;
import com.market.proj.marketProj.Entity.User;
import com.market.proj.marketProj.repository.BiddingRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@RequiredArgsConstructor
@Service
public class BiddingService {
    private final BiddingRepository biddingRepository;

    public void saveBidding(Bidding bidding) {
        biddingRepository.save(bidding);
    }

    public void removeByIdx(Long idx) { biddingRepository.deleteByIdx(idx); }

    public Bidding findByUserIdx(Long userIdx){ return biddingRepository.findByUserIdx(userIdx); }

    public Bidding findTopPriceBidding(Long productIdx) { return biddingRepository.findFirstByProductIdxOrderByBiddingPriceDesc(productIdx); }

    public Bidding findByProductIdxAndUserIdx(Long productIdx, Long userIdx) { return biddingRepository.findByProductIdxAndUserIdx(productIdx, userIdx); }
}
