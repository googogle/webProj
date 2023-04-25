package com.market.proj.marketProj.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class BiddingDTO {
    private Long idx;
    private Long productIdx;
    private String productName;
    private int biddingPrice;
    private String startPrice;
    private LocalDateTime biddedTime;
    private LocalDateTime endTime;
    private boolean isEnd;
    private boolean isSuccess;
    private int topPriceThisProduct;

}
