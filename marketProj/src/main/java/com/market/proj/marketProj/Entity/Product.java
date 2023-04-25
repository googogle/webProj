package com.market.proj.marketProj.Entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Data
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idx;
    private String productName;
    private String productDescription;
    private String productImage;
    private String productStartingPrice;
    private String productTickPrice;
    private LocalDateTime endTime;
    @ToString.Exclude
    @OneToMany(mappedBy = "product")
    @Builder.Default
    private List<Bidding> productBidded = new ArrayList<>();
    @ToString.Exclude
    @OneToMany(mappedBy = "product")
    @Builder.Default
    private List<Category> productCategories = new ArrayList<>();
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_idx")
    private User user;
    @Builder.Default
    private LocalDateTime createdAt = LocalDateTime.now();
    @Builder.Default
    private LocalDateTime updatedAt = LocalDateTime.now();
    private boolean isEnd ;

    public boolean getIsEnd() {
        return this.isEnd;
    }
}
