package com.market.proj.marketProj.dto;

import com.market.proj.marketProj.Entity.Category;
import com.market.proj.marketProj.Entity.Product;
import com.market.proj.marketProj.Entity.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class ProductDTO {
    private Long idx;
    private String productName;
    private String productDescription;
    private String productImage;
    private String productStartingPrice;
    private String productTickPrice;
    private LocalDateTime endTime;
    private List<Category> productCategories;
    private List<String> productCategories_s;
    private LocalDateTime updatedAt;
    private boolean isEnd;
    private int topPrice;
    private Long buyerIdx;


    @Transactional
    public static ProductDTO EntityTODto(Product productEntity){
        ProductDTO userDto = ProductDTO.builder()
                .idx(productEntity.getIdx())
                .productName(productEntity.getProductName())
                .productDescription(productEntity.getProductDescription())
                .productImage(productEntity.getProductImage())
                .productStartingPrice(productEntity.getProductStartingPrice())
                .productTickPrice(productEntity.getProductTickPrice())
                .endTime(productEntity.getEndTime())
                .productCategories(productEntity.getProductCategories())
                .updatedAt(productEntity.getUpdatedAt())
                .isEnd(productEntity.getIsEnd())
                .build();
        return userDto;
    }

}
